# TicketBooth

## Running the Program
If you're running this on eclipse, great! Simply run Main.java

If you're running this on Unix/Linux, run the compileProgram.sh and runProgram.sh scripts in the project directory!

For both of these methods, you may specify the following two command-line arguments.  
```bash
bash> ./runProgram <Path to users file> <Path to tickets file>
```


## Organization

The file tree is as follows:

	<Project Directory: "TicketBooth">  
	|_	src/		// Where all the source files are  
	|	|_	<Packages>/  
	|		|_	<Source Files>  
	|_	Files/		// All of the input and output files will be here.  
	|	|_	<All files>  
	|_	Tests/		// All tests and scripts to run individual tests are here  
		|_	<TestType>/  
			|_	<TestName#>/  
				|_ <InputFiles>  
				|_ <ExpectedOutputFiles>  
				|_ <Output from last run>  
				|_ TESTREPORT		// The report of the last test run  

### Tests
Tests are organized as follows:  
Types of tests:  
	- Acceptance Tests*  
	- System Tests 
	- Integration Tests  
	- Unit Tests  
*This is what we're currently working on this iteration.  

## Test Specification

For each test:  
	- Name each test descriptively  
	- For the sake of simplicity of our testing suite, we will follow this naming convention:  
		- Input Stream: stdin  
		- Expected Output Stream: egstdout
		- Output Stream from Test: stdout  
		- Input files: .in  extension:
			- AvailableTicketsFile.in
			- CurrentUserAccounts.in
		- Expected files: .eg  extension
			- AvailableTicketsFile.eg
			- CurrentUserAccounts.eg
			- DailyTransactionFile.eg
	- Output files from the test run are stored in the same directory, without any special extensions.  
	- Test report will be named: TESTREPORT.txt  
