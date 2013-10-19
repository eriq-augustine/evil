package evil;

import evil.evilTypeChecker.*;
import evil.evilCFG.*;
import evil.sparc.*;
import evil.optimizations.*;

import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import org.antlr.stringtemplate.*;

import java.io.*;
import java.util.Vector;
import java.util.HashMap;

public class Evil
{
   public static void main(String[] args)
   {
      parseParameters(args);

      CommonTokenStream tokens = new CommonTokenStream(createLexer());
      EvilParser parser = new EvilParser(tokens);
      EvilParser.program_return ret = null;
      
      try
      {
         ret = parser.program();
      }
      catch (org.antlr.runtime.RecognitionException e)
      {
         error(e.toString());
      }

      CommonTree t = (CommonTree)ret.getTree();
      if (_displayAST && t != null)
      {
         DOTTreeGenerator gen = new DOTTreeGenerator();
         StringTemplate st = gen.toDOT(t);
         System.out.println(st);
      }

      //TypeChecker
      try
      {
         CommonTreeNodeStream nodes = new CommonTreeNodeStream(t);
         nodes.setTokenStream(tokens);
         EvilTypeChecker tparser = new EvilTypeChecker(nodes);

         tparser.program();
      }
      catch (org.antlr.runtime.RecognitionException e)
      {
         error(e.toString());
      }
      
      evil.evilCFG.SymbolTable sym = null;
      evil.evilCFG.StructTable structs = null;
      BasicBlock cfg = null;

      if (_optFold || _optAll)
      {
         System.out.println("Running Constant Folding Optimization");
      }


      //CFG Builder
      try
      {
         CommonTreeNodeStream nodes = new CommonTreeNodeStream(t);
         nodes.setTokenStream(tokens);
         EvilCFGBuilder tparser = new EvilCFGBuilder(nodes);

         sym = new evil.evilCFG.SymbolTable();
         structs = new evil.evilCFG.StructTable();

         cfg = tparser.buildCFG(_debug, (_optFold || _optAll), sym, structs);

      }
      catch (org.antlr.runtime.RecognitionException e)
      {
         error(e.toString());
      }

      //Sanity Check
      if (!_noSanity)
      {
         try
         {
            cfg.sanityCheck();
         }
         catch (evil.evilCFG.BasicBlock.SanityException ex)
         {
            System.err.println("PRE-OPTIMIZTION SANITY ERROR! - " + ex.getMessage());
            ex.printStackTrace();
            System.exit(1);
         }
      }
      else
      {
         System.out.println("Bypassing sanity checks.");
      }
      
      //Optimizations
      if (_optAll || _optCopy || _optUseless || _optMessage)
      {
         Optimizations opt = new Optimizations();

         if (_optAll)
         {
            System.out.println("Running All Optimizations!");
            opt.optAll();
         }
         else
         {
            if (_optMessage)
            {
               System.out.println("Messaging the CFG");
               opt.optMessage();
            }

            if (_optCopy)
            {
               System.out.println("Running Copy Propigation Optimization");
               opt.optCopyProp();
            }

            if (_optUseless)
            {
               System.out.println("Running Useless Code Removal Optimization");
               opt.optUselessCode();
            }
         }
      }

      //Sanity Check
      if (!_noSanity)
      {
         try
         {
            cfg.sanityCheck();
         }
         catch (evil.evilCFG.BasicBlock.SanityException ex)
         {
            System.err.println("POST-OPTIMIZTION SANITY ERROR! - " + ex.getMessage());
            ex.printStackTrace();
            System.exit(1);
         }
      }
      
      //Print ILOC
      if (_dumpIL)
      {
         String outFile = _inputFile.replaceFirst("\\.([^\\.])+$", ".il");
         PrintStream myStream = null;
         try
         {
            myStream = new PrintStream(new File(outFile));
         }
         catch (Exception e)
         {
            System.err.println("Unable to make output stream for dumpIL, using stdout");
            myStream = System.out;
         }

         System.out.println("Dumping ILOC to " + outFile);
         BasicBlock.dumpInstructions(myStream, sym);
      }
      
      //ILOC to Sparc
      if (_noCompile)
      {
         System.out.println("Not Compiling");
      }
      else
      {
         SparcGenerator gen = new SparcGenerator(sym, structs, cfg);
       
         String outFile = null; 
         if (_compileFile == null)
         {
            outFile = _inputFile.replaceFirst("\\.([^\\.])+$", ".s");
         }
         else
         {
            outFile = _compileFile;
         }

         PrintStream myStream = null;
         try
         {
            myStream = new PrintStream(new File(outFile));
         }
         catch (Exception e)
         {
            System.err.println("Unable to make output stream for generating sparc");
            myStream = System.out;
         }

         System.out.println("Dumping Sparc to " + outFile);
         gen.generateSparc(myStream, outFile.replaceFirst("^/?(\\w*/)*(\\w*\\.s)$", "$2"));
      }
   }

   private static final String DISPLAYAST = "-displayAST";
   private static final String DUMPIL = "-dumpIL";
   private static final String DEBUG = "-debug";
   private static final String C_FILE = "-c";
   private static final String NO_COMPILE = "--no-compile";
   private static final String OPT_ALL = "-oA";
   private static final String OPT_COPY = "-oC";
   private static final String OPT_CONSTANT_FOLDING = "-oCF";
   private static final String OPT_USELESS = "-oU";
   private static final String OPT_MESSAGE = "-oM";
   private static final String INSANE = "--insane";
   private static final String NO_SANITY = "--no-sanity";

   private static String _inputFile = null;
   private static String _compileFile = null;
   private static boolean _displayAST = false;
   private static boolean _dumpIL = false;
   private static boolean _debug = false;
   private static boolean _noCompile = false;
   private static boolean _optAll = false;
   private static boolean _optCopy = false;
   private static boolean _optUseless = false;
   private static boolean _optMessage = false;
   private static boolean _noSanity = false;
   private static boolean _optFold = false;

   private static void parseParameters(String [] args)
   {
      for (int i = 0; i < args.length; i++)
      {
         if (args[i].equals(DISPLAYAST))
         {
            _displayAST = true;
         }
         else if (args[i].equals(OPT_ALL))
         {
            _optAll = true;
         }
         else if (args[i].equals(OPT_COPY))
         {
            _optCopy = true;
         }
         else if (args[i].equals(OPT_CONSTANT_FOLDING))
         {
            _optFold = true;
         }
         else if (args[i].equals(OPT_MESSAGE))
         {
            _optMessage = true;
         }
         else if (args[i].equals(OPT_USELESS))
         {
            _optUseless = true;
         }
         else if (args[i].equals(INSANE) || args[i].equals(NO_SANITY))
         {
            _noSanity = true;
         }
         else if (args[i].equals(C_FILE))
         {
            _compileFile = args[++i];
         }
         else if (args[i].equals(NO_COMPILE))
         {
            _noCompile = true;
         }
         else if (args[i].equals(DUMPIL))
         {
            _dumpIL = true;
         }
         else if (args[i].equals(DEBUG))
         {
            _debug = true;
         }
         else if (args[i].charAt(0) == '-')
         {
            System.err.println("unexpected option: " + args[i]);
            System.exit(1);
         }
         else if (_inputFile != null)
        {
            System.err.println("too many files specified");
            System.exit(1);
         }
         else
         {
            _inputFile = args[i];
         }
      }
   }


   private static void error(String msg)
   {
      System.err.println(msg);
      System.exit(1);
   }

   private static EvilLexer createLexer()
   {
      try
      {
         ANTLRInputStream input;
         if (_inputFile == null)
         {
            input = new ANTLRInputStream(System.in);
         }
         else
         {
            input = new ANTLRInputStream(
               new BufferedInputStream(new FileInputStream(_inputFile)));
         }
         return new EvilLexer(input);
      }
      catch (java.io.IOException e)
      {
         System.err.println("file not found: " + _inputFile);
         System.exit(1);
         return null;
      }
   }
}
