**deckofcards-api**

Demo Test framework project for Deckofcardsapi.com website using Java, Junit5 and Rest Assured

**Pre-requisite(s):**

Will need to install Maven for running the tests from Command Line.

**Steps:**

1.) After cloning the project from github, launch the command interface (CMD) and change the directory to runenv folder. e.g. CD C:\Automation\deckofcards-api.

2.) Type the following command C:> mvn clean test

3.) You should see the following output:

C:\Automation\deckofcards-api>mvn clean test
[INFO] Scanning for projects...
[INFO]
[INFO] --------------------< org.example:deckofcards-api >---------------------
[INFO] Building deckofcards-api 1.0-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO]
[INFO] --- maven-clean-plugin:2.5:clean (default-clean) @ deckofcards-api ---
[INFO] Deleting D:\Java\deckofcards-api\target
[INFO]
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ deckofcards-api ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Copying 0 resource
[INFO]
[INFO] --- maven-compiler-plugin:3.8.1:compile (default-compile) @ deckofcards-api ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 1 source file to D:\Java\deckofcards-api\target\classes
[INFO]
[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ deckofcards-api ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory D:\Java\deckofcards-api\src\test\resources
[INFO]
[INFO] --- maven-compiler-plugin:3.8.1:testCompile (default-testCompile) @ deckofcards-api ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 2 source files to D:\Java\deckofcards-api\target\test-classes
[INFO]
[INFO] --- maven-surefire-plugin:3.0.0-M5:test (default-test) @ deckofcards-api ---
[INFO]
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running com.homepoint.deckofcards.apitests.TestCasesForDeckOfCardsAPI
[INFO] Tests run: 4, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 3.609 s - in com.homepoint.deckofcards.apitests.TestCasesForDeckOfCardsAPI
[INFO]
[INFO] Results:
[INFO]
[INFO] Tests run: 4, Failures: 0, Errors: 0, Skipped: 0
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  8.497 s
[INFO] Finished at: 2021-09-08T12:03:33-05:00
[INFO] ------------------------------------------------------------------------

N.B. We can use other libraries that can generate a much better report more pleasing to the eye. Also we can run the project on IntelliJ or Eclipse too to see thee actual tests run.
