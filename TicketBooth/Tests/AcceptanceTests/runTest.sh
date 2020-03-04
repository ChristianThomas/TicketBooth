#!/bin/bash

# Each test runs as follows:
# .in files are copied into files without the .in extension
# Test is run with these copied files, with stdin as input, saving output to stdout
# Daily Transaction File is copied form the Files/ directory in the project root
# Comparisons are made and a test report is made

RUNSCRIPT=../../runProgram.sh

if [ ! $# -eq 1 ]; then
	echo "Please specify the test you wish to run."
	echo "Example: runTest login1"
fi

cd $1
echo "Running test $1"

cp AvailableTicketsFile.in AvailableTicketsFile
cp CurrentUserAccounts.in CurrentUserAccounts

bash -c 'echo stdin | "$RUNSCRIPT" CurrentUserAccounts AvailableTicketsFile > stdout'

cp ../../Files/DailyTransactionFile .
