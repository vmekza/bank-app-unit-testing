/**
 * Demonstrates the use of the bank application.
 *
 */
public class Main {

    /**
     * Demonstrates main bank app operations.
     *
     * @param args Command line arguments. Not used.
     */
    public static void main(String[] args) {
        Account account1 = new Account("123456789", 1000);
        Account account2 = new Account("987654321", 500);
        ATM atm = new ATM("Main Street", 5000);
        Bank bank = new Bank();
        Branch branch = new Branch("B001", "New York", 20);
        Customer customer = new Customer("John Doe", 30);
        Employee employee = new Employee("Samantha", 101);
        Loan loan = new Loan(10000, 5, 5);
        LoanAnalysisTool loanAnalysisTool = new LoanAnalysisTool(20000, 5, 5);
        TransactionLog transactionLog = new TransactionLog();
        System.out.println("\nInitial Customer Details:");
        System.out.println(customer.getDetails());

        customer.updateName("John Smith");
        customer.celebrateBirthday();
        System.out.println("\nUpdated Customer Details:");
        System.out.println(customer.getDetails());

        System.out.println("\nInitial Employee Details:");
        System.out.println(employee.getDetails());
        employee.setName("Alice Wonderland");
        employee.promote();
        System.out.println("\nUpdated Employee Details after name change and promotion:");
        System.out.println(employee.getDetails());

        System.out.println("\nBefore deposit, Account1 Balance: " + account1.getBalance());
        account1.deposit(200);
        System.out.println("\nAfter deposit, Account1 Balance: " + account1.getBalance());

        System.out.println("\nBefore transfer, Account2 Balance: " + account2.getBalance());
        account1.transferTo(account2, 200);
        System.out.println("After transfer, Account1 Balance: " + account1.getBalance());
        System.out.println("After transfer, Account2 Balance: " + account2.getBalance());
        System.out.println("\nATM Operations:");
        try {
            atm.depositCash(1000);
            System.out.println("Deposited 1000 to ATM. New ATM Balance: " + atm.getCashBalance());
            atm.withdrawCash(7000);
        }
        catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println("ATM Message: " + e.getMessage());
        }
        try {
            bank.createAccount(account1.getAccountNumber(), account1.getBalance());
            bank.createAccount(account2.getAccountNumber(), account2.getBalance());
            System.out.println("Accounts created successfully.");
        } catch (IllegalArgumentException e) {
            System.out.println("Failed to create account: " + e.getMessage());
        }
        System.out.println("\nBranch Operations:");
        branch.updateLocation("Los Angeles");
        branch.hireEmployees(5);
        try {
            branch.releaseEmployees(30);
        } catch (IllegalArgumentException e) {
            System.out.println("Warning: " + e.getMessage());
        }
        System.out.println(branch.getDetails());

        System.out.println("\nInitial Loan Details:");
        System.out.println("Loan Interest: " + loan.calculateInterest());
        System.out.println("Total Loan Amount: " + loan.getTotalAmount());
        loan.adjustAmount(12000);
        loan.modifyInterestRate(6);
        System.out.println("\nAdjusted Loan Details:");
        System.out.println("Adjusted Loan Interest: " + loan.calculateInterest());
        System.out.println("Adjusted Total Loan Amount: " + loan.getTotalAmount());
        System.out.println("Is the loan short term? " + loan.isShortTerm());
        System.out.println("Is the loan long term? " + loan.isLongTerm());
        System.out.println();
        System.out.println("Adjusted Monthly Loan Payment: " + loanAnalysisTool.calculateMonthlyPayment());
        System.out.println("Is the loan considered affordable? " + loanAnalysisTool.isAffordable());

        Transaction depositTransaction = new Transaction("TXN123", 500, "Deposit");
        Transaction withdrawalTransaction = new Transaction("TXN124", 200, "Withdrawal");
        transactionLog.addTransaction(depositTransaction);
        transactionLog.addTransaction(withdrawalTransaction);
        System.out.println("\nTransaction Log Details:");
        System.out.println(transactionLog.getTransactionDetails());
        System.out.println("Total Amount: " + transactionLog.getTotalAmount());
    }
}
