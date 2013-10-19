#Eriq Augusine
# Build .java files for instructions.
# Will read all files given on command line.
# Format for instruction is (# denote comments):
# '@' == label
# '&' == immediate
# 
# BEGIN
# <opcode>
# <field 1 name>
# <field 2 name>?
# <field 3 name>?
# END

class Inst
   @@tab = "   "

   def initialize(className, opcode, fields)
      @className = className
      @opcode = opcode
      @fields = fields
   end

   def toFile(file)
      writeHeader(file)
      file.puts "public class #{@className} implements Instruction"
      file.puts "{\n"
      writeDecs(file)
      writeConstructor(file)
      writeGetters(file)
      writeSetters(file)
      writeToString(file)
      file.puts "}"
   end

   def writeConstructor(file)
      file.print @@tab + "public #{@className}("
      paramString = ""

      @fields.each{ |number, var|
         paramString += "#{var.getParam(var.name)}, "
      }

      paramString.slice!(-2, 2)
      file.print paramString
      
      file.print ")\n#{@@tab}{\n"

      @fields.each{ |number, var|
         file.puts "#{@@tab + @@tab}this.#{var.name} = #{var.name};"
      }

      file.puts @@tab + "}\n\n"
   end

   def writeToString(file)
      file.puts @@tab + "public String toString()\n#{@@tab}{"
      rtn = "return (opcode +"
      @fields.each{ |number, var|
         rtn += " #{var.name} + \",\" +"
      }

      rtn.slice!(-8, 8)
      rtn += ");"
      file.puts @@tab + @@tab + rtn

      file.puts @@tab + "}\n\n"
   end

   def writeGetters(file)
      file.puts @@tab + "public String getOp()\n#{@@tab}{"
      file.puts @@tab + @@tab + "return opcode;\n#{@@tab}}\n\n"
      
      file.puts @@tab + "public String getOpcode()\n#{@@tab}{"
      file.puts @@tab + @@tab + "return opcode;\n#{@@tab}}\n\n"
      
      @fields.each{ |number, var|
         file.puts @@tab + "public #{var.type} getAddr#{number}()\n#{@@tab}{"
         file.puts @@tab + @@tab + "return #{var.name};\n#{@@tab}}\n\n"
      }

      @fields.each{ |number, var|
         file.puts @@tab + "public #{var.type} get#{var.name}()\n#{@@tab}{"
         file.puts @@tab + @@tab + "return #{var.name};\n#{@@tab}}\n\n"
      }
   end

   def writeSetters(file)
      @fields.each{ |number, var|
         file.puts @@tab + "public void setAddr#{number}(#{var.getParam("val")})\n#{@@tab}{"
         file.puts @@tab + @@tab + "this.#{var.name} = val;\n#{@@tab}}\n\n"
      }

      @fields.each{ |number, var|
         file.puts @@tab + "public void set#{var.name}(#{var.getParam("val")})\n#{@@tab}{"
         file.puts @@tab + @@tab + "this.#{var.name} = val;\n#{@@tab}}\n\n"
      }
   end

   def writeDecs(file)
      file.puts @@tab + "private static String opcode = \"#{@opcode}\";"
      @fields.each{ |number, var|
         file.puts @@tab + "private #{var.getDec(var.name)};"
      }
      file.puts
   end

   def writeHeader(file)
      file.puts "/**\n  * Eriq Augustine / Evan Ralston"
      file.puts "  * Automaticly generated Instruction file\n  */\n\n"
      file.puts "package EvilCFG;\n\n"
   end
end

class Field

   def initialize(name, type)
      @name = name
      @type = type
   end
   
   attr_accessor :name, :type

   def getDec(id)
      if @type == "int"
         return "int #{name}"
      else
         return "#{type} #{name}"
      end
   end

   def getParam(id)
      return "#{type} #{id}"
   end
      
end

comment = "#"
beginMark = "BEGIN"
endMark = "END"
instFileBase = "Inst_"
instFileEnd = ".java"
label = "@"
immediate = "&"

ARGV.each{ |fileName|
   inFile = File.open(fileName, "r")
   
   opcode = nil
   fields = Hash.new
   count = 0
   inInstruction = false

   inFile.each{ |line|
      line.strip!
      if line[0] != comment
         if inInstruction
            if line.upcase == endMark
               #Write instruction to file.
               className = instFileBase + opcode

               newInst = Inst.new(className, opcode, fields)
               outFile = File.open((className + instFileEnd), "w")

               newInst.toFile(outFile)
               outFile.close
               
               inInstruction = false
               opcode = nil
               fields = Hash.new
               count = 0
            elsif opcode == nil
               line.gsub!(/(.)(\s)(.)/, '\1\3')
               opcode = line.downcase
            else
               line.gsub!(/(.)(\s)(.)/, '\1\3')
               if line[0] == label #label
                  line.sub!(/^@(\W*)([a-zA-Z])(\w+)$/, '\2\3')
                  fields[count] = Field.new(line, "String");
               elsif line [0] == immediate #immeditate
                  line.sub!(/^&\W*(\w+)$/, '\1')
                  fields[count] = Field.new(line, "int");
               else
                  fields[count] = Field.new(line, "Register");
               end
               
               count += 1
            end
         elsif line.upcase == beginMark
            inInstruction = true
         end
      end
   }
   inFile.close
}
