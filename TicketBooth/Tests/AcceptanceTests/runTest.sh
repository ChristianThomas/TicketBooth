#!/bin/bash

# Each test runs as follows:
# .in files are copied into files without the .in extension
# Test is run with these copied files, with stdin as input, saving output to stdout
# Daily Transaction File is copied form the Files/ directory in the project root
# Comparisons are made and a test report is made

SUCCESS=true

# SCRIPTPATH is the path this is in PROJROOT is the project root
SCRIPT=$(readlink -f $0)
SCRIPTPATH=`dirname $SCRIPT`
TMP=`dirname $SCRIPTPATH`
PROJROOT=`dirname $TMP`

RUNSCRIPT="$PROJROOT/runProgram.sh"

# Check inputs
if [ ! $# -eq 1 ]; then
	echo "Please specify the test you wish to run."
	echo "Example: runTest login1"
fi

# In case this is being run from elsewhere
cd $SCRIPTPATH
cd $1

echo "Running test $1"

# Copying and creating files for use
cp AvailableTicketsFile.in AvailableTicketsFile
cp CurrentUserAccounts.in CurrentUserAccounts
touch stdout

# Getting absolute filepaths
CUA=$(readlink -f CurrentUserAccounts)
ATF=$(readlink -f AvailableTicketsFile)
STDIN=$(readlink -f stdin)
STDOUT=$(readlink -f stdout)

echo "Running test..."
bash -c "$RUNSCRIPT $CUA $ATF < $STDIN > $STDOUT"

# Getting the daily transaction file
cp ../../../Files/DailyTransactionFile .

# Compare the output with the expected inputs and create output
function testFile {
	diff "$1" "$2" > _tmp
	if [ -s _tmp ]; then
		SUCCESS=false
		echo "diff $1 $2 yielded the following differences:" >> TESTREPORT.txt
		cat _tmp >> TESTREPORT.txt
	else
		echo "diff $1 $2 yielded no differences" >> TESTREPORT.txt
	fi
	rm _tmp
}


rm TESTREPORT.txt

testFile "AvailableTicketsFile.eg" "AvailableTicketsFile"
testFile "CurrentUserAccounts.eg" "CurrentUserAccounts"
testFile "DailyTransactionFile.eg" "DailyTransactionFile"
testFile "egstdout" "stdout"
if [ $SUCCESS ]; then
	echo "Test successful: no differences found between expected and output." >> TESTREPORT.txt
else
	echo "Test Failed: Differences found between expected and output." >> TESTREPORT.txt
fi
