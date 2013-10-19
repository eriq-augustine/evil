#Eriq Augusine
# Build .java files for instructions.
# Will read all files given on command line.
# Format for instruction is (# denote comments):
# 'label' == label (String)
# 'immediate' == immediate (int)
# 'source' == source (Register)
# 'target' == target (Register)
# 
# BEGIN
# <opcode>
# <qualifier>:<field 1 name>
# <qualifier> : <field 2 name>?
# <qualifier>: <field 3 name>?
# END

labelRegEx = /^\s*label\s*:\s*(\w+)\s*$/
immediateRegEx = /^\s*immediate\s*:\s*(\w+)\s*$/
sourceRegEx = /^\s*source\s*:\s*(\w+)\s*$/
targetRegEx = /^\s*target\s*:\s*(\w+)\s*$/
extraRegEx = /^\s*extra\s*:\s*([\w\s]+)\s*$/
bothRegEx = /^\s*both\s*:\s*(\w+)\s*$/

class Inst
   @@tab = "   "
   @@package = "evil.instruction"

   def initialize(className, opcode, fields, extraInfo)
      @className = className
      @opcode = opcode
      @fields = fields
      @extraInfo = extraInfo
   end

   def toFile(file)
      writeHeader(file)
      file.puts "public class #{@className} extends Instruction"
      file.puts "{\n"
      writeDecs(file)
      writeConstructor(file)
      writeReplaceSource(file);
      writeGetters(file)
      writeSetters(file)
      writeToString(file)
      writeExtraInfo(file)
      file.puts "}"
   end

   def writeConstructor(file)
      file.print @@tab + "public #{@className}("
      paramString = ""

      @fields.each{ |number, var|
         paramString += "#{var.getParam(var.name)}, "
      }

      paramString.slice!(-2, 2)

      if @extraInfo.size > 0
         paramString += ", String #{@extraInfo}"
      end

      file.print paramString
      
      file.print ")\n#{@@tab}{\n"

      file.puts "#{@@tab + @@tab}super();"

      @fields.each{ |number, var|
         file.puts "#{@@tab + @@tab}this.#{var.name} = #{var.name};"
      }

      if @extraInfo.size > 0
         file.puts @@tab + @@tab + "this.#{@extraInfo} = #{@extraInfo};"
      end

      file.puts ""

      @fields.each{|number, var|
         if (var.useType == "source")
            file.puts "#{@@tab + @@tab}super.addSource(#{var.name});"
         elsif (var.useType == "target")
            file.puts "#{@@tab + @@tab}super.addTarget(#{var.name});"
         elsif (var.useType == "both")
            file.puts "#{@@tab + @@tab}super.addTarget(#{var.name});"
            file.puts "#{@@tab + @@tab}super.addSource(#{var.name});"
         end
      }

      file.puts @@tab + "}\n\n"
   end

   def writeReplaceSource(file)
      file.puts @@tab + "public void replaceSource(Register victim, Register toReplace)\n#{@@tab}{"
      @fields.each{|number, var|
         if (var.useType == "source")
            file.puts @@tab + @@tab + "if (victim == #{var.name})\n" + @@tab + @@tab + "{"
            file.puts @@tab + @@tab + @@tab + "super.removeSource(#{var.name});"
            file.puts @@tab + @@tab + @@tab + "super.addSource(toReplace);"
            file.puts @@tab + @@tab + @@tab + "#{var.name} = toReplace;"
            file.puts @@tab + @@tab + "}\n"
         elsif (var.useType == "both")
            file.puts @@tab + @@tab + "if (victim == #{var.name})\n" + @@tab + @@tab + "{"
            file.puts @@tab + @@tab + @@tab + "super.removeSource(#{var.name});"
            file.puts @@tab + @@tab + @@tab + "super.removeTarget(#{var.name});"
            file.puts @@tab + @@tab + @@tab + "super.addSource(toReplace);"
            file.puts @@tab + @@tab + @@tab + "super.addTarget(toReplace);"
            file.puts @@tab + @@tab + @@tab + "#{var.name} = toReplace;"
            file.puts @@tab + @@tab + "}\n"
         end
      }

      file.puts @@tab + "}\n\n"
   end
   
   def writeToString(file)
      file.puts @@tab + "public String toString()\n#{@@tab}{"
      rtn = "return (opcode + \" \" + "
      @fields.each{ |number, var|
         rtn += " #{var.name} + \", \" +"
      }

      rtn.slice!(-8, 8)
      rtn += ");"
      file.puts @@tab + @@tab + rtn

      file.puts @@tab + "}\n\n"
   end

   def writeExtraInfo(file)
      if @extraInfo.size > 0
         file.puts @@tab + "public String getExtraInfo()\n#{@@tab}{"
         file.puts @@tab + @@tab + "return #{@extraInfo};"
         file.puts @@tab + "}\n\n"
      
         file.puts @@tab + "public String get#{@extraInfo}()\n#{@@tab}{"
         file.puts @@tab + @@tab + "return #{@extraInfo};"
         file.puts @@tab + "}\n\n"
      end
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
      
      if @extraInfo.size > 0
         file.puts @@tab + "private String #{@extraInfo};"
      end

      file.puts
   end

   def writeHeader(file)
      file.puts "/**\n  * Eriq Augustine / Evan Ralston"
      file.puts "  * Automaticly generated Instruction file\n  */\n\n"
      file.puts "package #{@@package};\n\n"
   end
end

class Field

   def initialize(name, type, useType)
      @name = name
      @type = type
      @useType = useType
   end
   
   attr_accessor :name, :type, :useType

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
   extraInfo = ""
   inInstruction = false

   inFile.each{ |line|
      line.strip!
      if line[0] != comment
         if inInstruction
            if line.upcase == endMark
               #Write instruction to file.
               className = instFileBase + opcode

               newInst = Inst.new(className, opcode, fields, extraInfo)
               outFile = File.open((className + instFileEnd), "w")

               newInst.toFile(outFile)
               outFile.close
               
               inInstruction = false
               opcode = nil
               fields = Hash.new
               count = 0
               extraInfo = ""
            elsif opcode == nil
               line.gsub!(/(.)(\s)(.)/, '\1\3')
               opcode = line.downcase
            else

               if line.match labelRegEx
                  line.sub!(labelRegEx, '\1')
                  fields[count] = Field.new(line, "String", "label")
               elsif line.match immediateRegEx
                  line.sub!(immediateRegEx, '\1')
                  fields[count] = Field.new(line, "int", "immediate")
               elsif line.match sourceRegEx
                  line.sub!(sourceRegEx, '\1')
                  fields[count] = Field.new(line, "Register", "source")
               elsif line.match targetRegEx
                  line.sub!(targetRegEx, '\1')
                  fields[count] = Field.new(line, "Register", "target")
               elsif line.match bothRegEx
                  line.sub!(bothRegEx, '\1')
                  fields[count] = Field.new(line, "Register", "both")
               elsif line.match extraRegEx
                  extraInfo = line.sub!(extraRegEx, '\1')
               else
                  puts "Unrecognized classifier: #{line}"
               end

               #line.gsub!(/(.)(\s)(.)/, '\1\3')
               #if line[0] == label #label
               #   line.sub!(/^@(\W*)([a-zA-Z])(\w+)$/, '\2\3')
               #   fields[count] = Field.new(line, "String");
               #elsif line [0] == immediate #immeditate
               #   line.sub!(/^&\W*(\w+)$/, '\1')
               #   fields[count] = Field.new(line, "int");
               #else
               #   fields[count] = Field.new(line, "Register");
               #end
               
               count += 1
            end
         elsif line.upcase == beginMark
            inInstruction = true
         end
      end
   }
   inFile.close
}
