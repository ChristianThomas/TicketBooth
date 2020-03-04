# TicketBooth

If you're running this on eclipse, great! Simply run Main.java

If you're running this on Unix/Linux, run the compileProgram.sh and runProgram.sh scripts in the project directory!

The organization is as follows:
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

Tests are organized as follows:
Types of tests:
	- Acceptance Tests*
	- System Tests
	- Integration Tests
	- Unit Tests
*This is what we're currently working on this iteration.

For each test:
	- Name each test descriptively
	- For the sake of simplicity of our testing suite, we will follow this naming convention:
		- Input Stream: .stdin
		- Expected Output Stream: .stdout
		- Input files: .inf
		- Expected files: .eg
