# Bank App

This project is a Java-based application designed to simulate a banking system. Its primary purpose is to demonstrate the implementation and effectiveness of unit testing within a complex system.
Overall, the project includes 166 unit tests, ensuring comprehensive coverage and robustness of the banking functions simulated.
The app manages user accounts, processes financial transactions such as deposits and withdrawals,
and handles loans and payments.

The Main class of this application is designed with hardcoded values
to facilitate a quick demonstration of the banking system's core functionalities in a predictable manner.

## Compilation Instructions

1. Compile the main application by navigating to the project directory and running the following command:

    javac -cp . Main.java

2. Compile the test classes with the following command:

    For Windows (ensure this is entered as a single line):
    javac -cp .;junit-4.13.2.jar;hamcrest-core-1.3.jar AllTestsSuite.java AccountTest.java ATMTest.java BankTest.java BranchTest.java CustomerTest.java EmployeeTest.java LoanTest.java LoanAnalysisToolTest.java TransactionTest.java TransactionLogTest.java

    For macOS and Linux:
    javac -cp .:junit-4.13.2.jar:hamcrest-core-1.3.jar \
    AllTestsSuite.java AccountTest.java ATMTest.java BankTest.java \
    BranchTest.java CustomerTest.java EmployeeTest.java \
    LoanTest.java LoanAnalysisToolTest.java TransactionTest.java \
    TransactionLogTest.java

## Running the Application

- After compilation, you can run the application using the following command:

    java -cp . Main

## Running the Tests
- To run all tests, execute the following command:

    For Windows:
    java -cp .;junit-4.13.2.jar;hamcrest-core-1.3.jar org.junit.runner.JUnitCore AllTestsSuite

    For macOS and Linux:
    java -cp .:junit-4.13.2.jar:hamcrest-core-1.3.jar org.junit.runner.JUnitCore AllTestsSuite

- To execute a specific test, such as `AccountTest`, use the command:

    For Windows:
    java -cp .;junit-4.13.2.jar;hamcrest-core-1.3.jar org.junit.runner.JUnitCore AccountTest

    For macOS and Linux:
    java -cp .:junit-4.13.2.jar:hamcrest-core-1.3.jar org.junit.runner.JUnitCore AccountTest
