import java.util.HashMap;

/**
 * Represents a simple banking system for account management.
 *
 * <p> Provides methods to create, close, and manage bank accounts using
 * a HashMap. Accounts can be accessed using their unique account numbers.
 */
public class Bank {

    /**
     * A map storing the bank accounts, where each account number (a String) is associated with an Account object.
     */
    private HashMap<String, Account> accounts;

    /**
     * Initializes a new bank instance with no accounts.
     *
     * <p> Sets up the bank with an empty accounts HashMap,
     * ready to store Account instances.
     */
    public Bank() {
        this.accounts = new HashMap<>();
    }

    /**
     * Creates a new account with the specified account number and initial deposit.
     *
     * <p> If an account with the specified account number already exists, an IllegalArgumentException
     * is thrown to prevent duplicate accounts.
     *
     * @param accountNumber  The unique identifier for the new account.
     * @param initialDeposit The initial amount to deposit into the account.
     * @throws IllegalArgumentException If an account with the specified account number already exists.
     */
    public void createAccount(String accountNumber, double initialDeposit) throws IllegalArgumentException {
        if (accounts.containsKey(accountNumber)) {
            throw new IllegalArgumentException("Account already exists.");
        }
        accounts.put(accountNumber, new Account(accountNumber, initialDeposit));
    }

    /**
     * Closes an account identified by the specified account number.
     *
     * <p> If no account with the specified account number exists, an IllegalArgumentException
     * is thrown.
     *
     * @param accountNumber The account number of the account to be closed.
     * @throws IllegalArgumentException If no account with the specified account number exists.
     */
    public void closeAccount(String accountNumber) throws IllegalArgumentException {
        if (!accounts.containsKey(accountNumber)) {
            throw new IllegalArgumentException("Account not found.");
        }
        accounts.remove(accountNumber);
    }

    /**
     * Deposits a specified amount into an account identified by the account number.
     *
     * @param accountNumber The account number of the account to deposit into.
     * @param amount The amount to deposit.
     * @throws IllegalArgumentException If the specified account does not exist or the deposit amount is not positive.
     */
    public void depositToAccount(String accountNumber, double amount) {
        Account account = accounts.get(accountNumber);
        if (account == null) {
            throw new IllegalArgumentException("Account not found.");
        }
        account.deposit(amount);
    }

    /**
     * Returns the total number of accounts in the bank.
     *
     * <p> Counts and returns the number of accounts currently managed by the bank.
     *
     * @return The total number of accounts.
     */
    public int getNumAccounts() {
        return accounts.size();
    }

    /**
     * Prints the details of an account identified by the specified account number.
     *
     * <p> Includes the account number and the current balance. If no account with the
     * specified account number exists, an IllegalArgumentException is thrown.
     *
     * @param accountNumber The account number of the account whose details are to be printed.
     * @throws IllegalArgumentException If no account with the specified account number exists.
     */
    public void printAccountDetails(String accountNumber) throws IllegalArgumentException {
        if (!accounts.containsKey(accountNumber)) {
            throw new IllegalArgumentException("Account not found.");
        }
        Account account = accounts.get(accountNumber);
    }

    /**
     * Checks whether an account exists in the bank for the specified account number.
     *
     * <p> Verifies the existence of an account without revealing
     * any account details.
     *
     * @param accountNumber The account number to check.
     * @return true if the account exists, false otherwise.
     */
    public boolean hasAccount(String accountNumber) {
        return accounts.containsKey(accountNumber);
    }

    /**
     * Retrieves the balance for the account identified by the specified account number.
     *
     * @param accountNumber The account number of the account whose balance is to be retrieved.
     * @return The balance of the account.
     * @throws IllegalArgumentException If no account with the specified account number exists.
     */
    public double getAccountBalance(String accountNumber) {
        if (!accounts.containsKey(accountNumber)) {
            throw new IllegalArgumentException("Account not found.");
        }
        return accounts.get(accountNumber).getBalance();
    }
}
