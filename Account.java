/**
 * Represents a bank account with basic operations such as deposit, withdraw, and transfer.
 *
 */
public class Account {

    /**
     * Holds the unique identifier for the account.
     */
    private String accountNumber;

    /**
     * Maintains the current balance of the account.
     */
    private double balance;

    /**
     * Initializes a new Account instance with a specified account number and initial balance.
     *
     * @param accountNumber the unique identifier for the account
     * @param initialBalance the initial balance of the account
     */
    public Account(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    /**
     * Deposits the specified amount into the account.
     *
     * Increases the account balance by the given deposit amount if the amount is positive.
     *
     * @param amount the amount to be deposited
     * @throws IllegalArgumentException if the deposit amount is not positive
     */
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive.");
        }
        balance += amount;
        }

    /**
     * Withdraws the specified amount from the account.
     *
     * Decreases the account balance by the withdrawal amount if there are sufficient funds and the amount is positive.
     *
     * @param amount the amount to be withdrawn
     * @throws IllegalArgumentException if the withdrawal amount is not positive or if insufficient funds are available
     */
    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive.");
        }
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient funds.");
        }
        balance -= amount;
    }

    /**
     * Transfers the specified amount from this account to another account.
     *
     * @param otherAccount the recipient account of the transfer
     * @param amount the amount to be transferred
     * @throws IllegalArgumentException if the transfer amount is not positive or if insufficient funds are available for transfer
     */
    public void transferTo(Account otherAccount, double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Transfer amount must be positive.");
        }
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient funds for transfer.");
        }
        this.balance -= amount;
        otherAccount.balance += amount;
    }

    /**
     * Returns the current balance of the account.
     *
     *  @return the current balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Retrieves the account number.
     *
     * @return the account number
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * Checks if the account balance is negative, indicating an overdrawn account.
     *
     * @return true if the account is overdrawn, otherwise false
     */
    public boolean isOverdrawn() {
        return balance < 0;
    }
}
