cd AcceptanceTests

for currentTest in */; do
	# Run test
	./runTest.sh "$currentTest"
	# Get result
	echo "========$currentTest: TEST REPORT========"
	cat "$currentTest/TESTREPORT.txt"
	echo "========$currentTest: END TEST REPORT========"
done
