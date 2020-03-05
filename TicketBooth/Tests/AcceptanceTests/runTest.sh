#!/bin/bash

# Each test runs as follows:
# .in files are copied into files without the .in extension
# Test is run with these copied files, with stdin as input, saving output to stdout
# Daily Transaction File is copied form the Files/ directory in the project root
# Comparisons are made and a test report is made

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

# Compare the output with the expected inputs and add results to report file
if !diff STDIN STDOUT
then
	echo "Passed test $1 > TESTREPORT.txt
else
	echo "Failed test $1 > TESTREPORT.txt
fi
# Create report for this test

