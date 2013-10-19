#FILES=Evil.java EvilTreeParser.java

#treeParser : Evil.class

#all : EvilTypeChecker.class EvilCFGBuilder.class Evil.java
#all : EvilTypeChecker.class EvilCFGBuilder.class
all : .EvilTypeCheckerExists .EvilCFGBuilderExists
	javac -cp antlr-3.1.3.jar:. *.java

.EvilTypeCheckerExists : EvilTypeChecker.class
	touch .EvilTypeCheckerExists	

.EvilCFGBuilderExists : EvilCFGBuilder.class
	touch .EvilCFGBuilderExists

EvilTypeChecker.class : EvilTypeChecker.java
	@echo "Building EvilTypeChecker.class... Will move into EvilTypeChecker" 
	$(shell cd EvilTypeChecker; javac -cp ../antlr-3.1.3.jar:. *.java) 

EvilTypeChecker.java : 
	@echo "Building EvilTypeChecker.java... Will move into EvilTypeChecker"
	$(shell cd EvilTypeChecker; java -cp ../antlr-3.1.3.jar:. org.antlr.Tool EvilTypeChecker.g)

EvilCFGBuilder.class : EvilCFGBuilder.java
	@echo "Building EvilCFGBuilder.class... Will move into EvilCFG"
	$(shell cd EvilCFG; javac -cp ../antlr-3.1.3.jar:. *.java)

EvilCFGBuilder.java : 
	@echo "Building EvilCFGBuilder.java... Will move into EvilCFG"
	$(shell cd EvilCFG; java -cp ../antlr-3.1.3.jar:. org.antlr.Tool EvilCFGBuilder.g)

clean:
	rm -f *.class
	rm -f EvilTypeChecker/*.class
	rm -f EvilTypeChecker/EvilTypeChecker.class
	rm -f EvilCFG/*.class
	rm -f EvilCFG/EvilCFGBuilder.class
	rm -f .EvilTypeCheckerExists
	rm -f .EvilCFGBuilderExists

#all : ${FILES} antlr.generated.evil
#	java org.antlr.Tool Evil.g
#	java org.antlr.Tool EvilTreeParser.g
#	javac *.java
#
#Evil.java:	Evil.g
#	java org.antlr.Tool Evil.g
#
#EvilTreeParser.java:	EvilTreeParser.g
#	java org.antlr.Tool EvilTreeParser.g
#
#antlr.generated: antlr.generated.evil
#	touch antlr.generated
#
#antlr.generated.evil : Evil.g EvilTreeParser.g
#	java org.antlr.Tool EvilTreeParser.g
#	java org.antlr.Tool Evil.g
#	java -cp /home/akeen/public/antlr3/antlr-3.1.3.jar org.antlr.Tool Evil.g
#	touch antlr.generated.evil
#clean:
#	rm -f *.class
#
