#!/bin/bash

#Script to run all benchmarks and report the results.

gcc="/usr/sfw/bin/gcc"
results=".results"
outputFile=".testOutput"
timeBin="/home/eaugusti/bin/sparcTime -a -o $outputFile"

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

failTests=$failDir/*        
passTests=$passDir/*      

echo "RESULTS!" > $results;
echo "RESULTS!" > $outputFile;
echo "Previously Failed Results:" >> $results;
echo "Previously Failed Results:" >> $outputFile;

#for DIR in $(find $benchDir -maxdepth 1 -type d)
for DIR in $failTests
do
   if [ -d $DIR ] && [ $DIR != $passDir ] && [ $DIR != $benchDir ]; then
      #echo $DIR
   
      for testFile in $(ls "$DIR"/*.s)
      do
         failed=$passed;
         echo Testing... $testFile
         echo $testFile >> $outputFile
         
         compileName=$DIR/"$scriptAssembly"
         #echo $compileName;
   
         binName=$DIR/"$scriptBin"
         #echo $binName
         #echo "$gcc -mcpu=v9 -o $binName $compileName"
         $gcc -mcpu=v9 -o $binName $compileName >> $outputFile

         if [ $? != 0 ]; then
            echo "Error assembling $compileName" >> $outputFile
            #echo
            failed=$assembleFail
         else
            myIn=$DIR/"$input"
            #echo $myIn
             
            myOut=$DIR/"$outScriptName"
            #echo $myOut
               
            $timeBin $binName < $myIn > $myOut
               
            if [ $? != 0 ]; then
               echo "Error runing (non-zero return from main) $binName" >> $outputFile;
               #echo
               failed=$runFail
            else
               goodOut=$DIR/"$output"
               #echo $goodOut
                  
               diff -s $goodOut $myOut > /dev/null

               if [ $? != 0 ]; then
                  echo "Error in diff for $testFile" >> $outputFile
                  #echo
                  failed=$diffFail
               fi
            fi
         fi

         if [ $failed -eq $assembleFail ]; then
            echo "$testFile failed in assembling" >> $results
         elif [ $failed -eq $runFail ]; then
            echo "$testFile failed in running (non-zero return)" >> $results
         elif [ $failed -eq $diffFail ]; then
            echo "$testFile failed in diff" >> $results
         else
            echo  "$testFile passed!" >> $results
         fi

         #rm -f $compileName
         #rm -f $binName
         #rm -f $myOut

         echo "" >> $outputFile

         if [ $failed -eq $passed ]; then
            mv $DIR "$passDir""/"
         fi

      done
   fi
done

echo "Previously Passed Results:" >> $results;
echo "Previously Passed Files:" >> $outputFile;
for DIR in $passTests
do
   if [ -d $DIR ] && [ $DIR != $passDir ] && [ $DIR != $benchDir ]; then
      #echo $DIR
   
      for testFile in $(ls "$DIR"/*.s)
      do
         failed=$passed;
         echo Testing... $testFile
         echo $testFile >> $outputFile
         
         compileName=$DIR/"$scriptAssembly"
         #echo $compileName;
   
         binName=$DIR/"$scriptBin"
         #echo $binName
         $gcc -mcpu=v9 -o $binName $compileName >> $outputFile
         #echo "$gcc -mcpu=v9 -o $binName $compileName"

         if [ $? != 0 ]; then
            #echo "Error assembling $compileName"
            #echo
            failed=$assembleFail
         else
            myIn=$DIR/"$input"
            #echo $myIn
             
            myOut=$DIR/"$outScriptName"
            #echo $myOut
               
            $timeBin $binName < $myIn > $myOut
               
            if [ $? != 0 ]; then
               echo "Error runing (non-zero return from main) $binName" >> $outputFile;
               #echo
               failed=$runFail
            else
               goodOut=$DIR/"$output"
               #echo $goodOut
                  
               diff -s $goodOut $myOut > /dev/null

               if [ $? != 0 ]; then
                  echo "Error in diff for $testFile" >> $outputFile
                  #echo
                  failed=$diffFail
               fi
            fi
         fi
         
         if [ $failed == $assembleFail ]; then
            echo "$testFile failed in assembling" >> $results
         elif [ $failed == $runFail ]; then
            echo "$testFile failed in running (non-zero return)" >> $results
         elif [ $failed == $diffFail ]; then
            echo "$testFile failed in diff" >> $results
         else
            echo  "$testFile passed!" >> $results
         fi

         #rm -f $compileName
         #rm -f $binName
         #rm -f $myOut

         echo "" >> $outputFile

         if [ $failed != $passed ]; then
            mv $DIR "$failDir""/"
         fi

      done
   fi
done

exit;
