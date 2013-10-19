FILES=Evil.java EvilTreeParser.java

#treeParser : Evil.class

all : ${FILES} antlr.generated.evil
	java org.antlr.Tool Evil.g
	java org.antlr.Tool EvilTreeParser.g
	javac *.java

Evil.java:	Evil.g
	java org.antlr.Tool Evil.g

EvilTreeParser.java:	EvilTreeParser.g
	java org.antlr.Tool EvilTreeParser.g

antlr.generated: antlr.generated.evil
	touch antlr.generated

antlr.generated.evil : Evil.g EvilTreeParser.g
	java org.antlr.Tool EvilTreeParser.g
	java org.antlr.Tool Evil.g
#	java -cp /home/akeen/public/antlr3/antlr-3.1.3.jar org.antlr.Tool Evil.g
	touch antlr.generated.evil
clean:
	rm -f *.class

safe:
	\cp *.g *.java ~/.431
