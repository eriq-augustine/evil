#!/bin/bash

runTotal=0
testDir="superTestResults"
testOut=".testOutput"

for i in {1..10}
do
   ./benchTest.sh
   cp $testOut $testDir"/test"$i
   #echo $testDir"/test"$i
done

exit

