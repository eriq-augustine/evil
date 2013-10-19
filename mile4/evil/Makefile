#FILES=Evil.java EvilTreeParser.java

#treeParser : Evil.class

#all : EvilTypeChecker.class EvilCFGBuilder.class Evil.java
#all : EvilTypeChecker.class EvilCFGBuilder.class
all : .EvilTypeCheckerExists .InstructionsExists .EvilCFGBuilderExists .EvilSparcGenExists .EvilOptimizationsExists
	javac -cp antlr-3.1.3.jar:..:. *.java

.EvilTypeCheckerExists : EvilTypeChecker.class
	touch .EvilTypeCheckerExists	

.EvilCFGBuilderExists : EvilCFGBuilder.class
	touch .EvilCFGBuilderExists

.InstructionsExists : Instructions
	touch .InstructionsExists

.EvilSparcGenExists : SparcGenerator.class
	touch .EvilSparcGenExists

.EvilOptimizationsExists : Optimizations.class
	touch .EvilOptimizationsExists

SparcGenerator.class : 
	@echo "Building SparcGenerator.class... Will move into sparc" 
	$(shell cd sparc; javac -cp ../antlr-3.1.3.jar:../..:. *.java) 

Optimizations.class : 
	@echo "Building Optimizations.class... Will move into optimizations" 
	$(shell cd optimizations; javac -cp ../antlr-3.1.3.jar:../..:. *.java) 

EvilTypeChecker.class : EvilTypeChecker.java
	@echo "Building EvilTypeChecker.class... Will move into EvilTypeChecker" 
	$(shell cd evilTypeChecker; javac -cp ../antlr-3.1.3.jar:../..:. *.java) 

EvilTypeChecker.java : 
	@echo "Building EvilTypeChecker.java... Will move into EvilTypeChecker"
	$(shell cd evilTypeChecker; java -cp ../antlr-3.1.3.jar:. org.antlr.Tool EvilTypeChecker.g)

EvilCFGBuilder.class : EvilCFGBuilder.java
	@echo "Building EvilCFGBuilder.class... Will move into EvilCFG"
	$(shell cd evilCFG; javac -cp ../antlr-3.1.3.jar:../..:. *.java)

EvilCFGBuilder.java : 
	@echo "Building EvilCFGBuilder.java... Will move into EvilCFG"
	$(shell cd evilCFG; java -cp ../antlr-3.1.3.jar:. org.antlr.Tool EvilCFGBuilder.g)

Instructions : 
	@echo "Building all instructions... Will move into Instruction"
	$(shell cd instruction; ruby build_instructions.rb *.ins)
	$(shell cd instruction; javac -cp ../antlr-3.1.3.jar:../..:. *.java)

clean:
	rm -f *.class
	rm -f evilTypeChecker/*.class
	rm -f evilTypeChecker/EvilTypeChecker.class
	rm -f evilCFG/*.class
	rm -f evilCFG/EvilCFGBuilder.class
	rm -f instruction/Inst_*.class
	rm -f instruction/Inst_*.java
	rm -f .EvilTypeCheckerExists
	rm -f .EvilCFGBuilderExists
	rm -f .InstructionsExists
	rm -f sparc/*.class
	rm -f .EvilSparcGenExists
	rm -f optimizations/*.class
	rm -f .EvilOptimizationsExists
