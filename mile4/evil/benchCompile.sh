#!/bin/bash

#Script to run all benchmarks and report the results.

outputFile=".compileOutput"
timeBin="/usr/bin/time -a -o $outputFile"

antlr="antlr-3.1.3.jar"
cp=".:..:$antlr"

benchDir="benchmarks"
passDir="$benchDir/pass"
failDir="$benchDir/fail"
input="input"
output="output"
outScriptName=".script_output"
scriptBin="._script_bin"
scriptAssembly="_script_ass.s"

passed=0
compileFail=1
assembleFail=2
runFail=3
diffFail=4

optFlag="-oA"
if [ $# = "1" ]; then
   if [ $1 = "-NO-OPT" ] || [ $1 = "-no-opt" ]; then
      optFlag=""
   else
      optFlag=$1
   fi
elif [ $# != 0 ]; then
   echo "Too many arguments, only 1 optimization plz."
   exit;
fi

#cd $benchDir;

echo "COMPILE OUTPUT:" > $outputFile
echo "Previously Failed Files:" >> $outputFile
for DIR in $failDir/*
do
   if [ -d $DIR ] && [ $DIR != $passDir ] && [ $DIR != $benchDir ]; then
      #echo $DIR
      
      for testFile in $(ls $DIR/*.ev)
      do
         failed=$passed;
         echo "Compiling... $testFile";
         
         echo "$testFile" >> $outputFile;
            
         compileName=$DIR/"$scriptAssembly"
         #echo $compileName;
         
         $timeBin java -cp $cp evil.Evil $optFlag $testFile -c $compileName >> $outputFile

         if [ $? != 0 ]; then
            echo "Error compiling $testFile";
            failed=$compileFail;
            #Don't move tests that compile, they have not passed yet!
         fi
         
         echo "" >> $outputFile;

      done
   fi
done

echo "Previously Passed Files:" >> $outputFile
for DIR in $passDir/*
do
   if [ -d $DIR ] && [ $DIR != $passDir ] && [ $DIR != $benchDir ]; then
      #echo $DIR
      
      for testFile in $(ls $DIR/*.ev)
      do
         failed=$passed;
         echo "Compiling... $testFile";
         
         echo "$testFile" >> $outputFile;
         
         compileName=$DIR/"$scriptAssembly"
         #echo $compileName;
         
         $timeBin java -cp $cp evil.Evil $optFlag $testFile -c $compileName >> $outputFile

         if [ $? != 0 ]; then
            echo "Error compiling $testFile";
            failed=$compileFail;

            mv $DIR "$failDir""/"
         fi
         
         echo "" >> $outputFile;

      done
   fi
done

exit;
