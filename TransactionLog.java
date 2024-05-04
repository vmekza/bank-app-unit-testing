import java.util.ArrayList;
import java.util.List;

/**
 * Manages a log of financial transactions, providing methods to add, retrieve, and analyze transaction data.
 */
public class TransactionLog {

    /**
     * A list of objects representing the financial transactions in the log.
     */
    private List<Transaction> transactions;

    /**
     * Constructs an empty TransactionLog.
     */
    public TransactionLog() {
        this.transactions = new ArrayList<>();
    }

    /**
     * Adds a transaction to the log.
     *
     * @param transaction transaction to add to the log
     * @throws IllegalArgumentException if the transaction is null or has an invalid type
     */
    public void addTransaction(Transaction transaction) {
        if (transaction == null || !transaction.isValidType()) {
            throw new IllegalArgumentException("Invalid or null transaction.");
        }
        transactions.add(transaction);
    }

    /**
     * Returns a new list containing copies of the transactions in the log.
     *
     * @return a list containing copies of the transactions
     */
    public List<Transaction> getTransactions() {
        return new ArrayList<>(transactions);
    }

    /**
     * Returns the number of transactions in the log.
     *
     * @return an int representing the number of transactions
     */
    public int getNumTransactions() {
        return transactions.size();
    }

    /**
     * Returns a string detailing all transactions in the log.
     *
     * @return a String containing details of all transactions
     */
    public String getTransactionDetails() {
        StringBuilder details = new StringBuilder();
        for (Transaction transaction : transactions) {
            details.append(transaction.getDetails()).append("\n");
        }
        return details.toString().trim();
    }

    /**
     * Calculates and returns the total amount of all transactions in the log.
     *
     * @return a double representing the total amount of the transactions
     */
    public double getTotalAmount() {
        double total = 0;
        for (Transaction transaction : transactions) {
            total += transaction.getAmount();
        }
        return total;
    }

    /**
     * Calculates and returns the total amount for transactions of a specific type.
     *
     * @param type the type of transactions to sum (e.g., "Deposit" or "Withdrawal")
     * @return a double representing the total amount of transactions of the specified type
     */
    public double getTotalAmountByType(String type) {
        double total = 0;
        for (Transaction transaction : transactions) {
            if (type.equalsIgnoreCase(transaction.getType())) {
                total += transaction.getAmount();
            }
        }
        return total;
    }

    /**
     * Searches for and returns a transaction with the specified ID.
     *
     * @param transactionId the ID of the transaction to find
     * @return a transaction with the specified ID, or null if no such transaction exists.
     */
    public Transaction findTransactionById(String transactionId) {
        for (Transaction transaction : transactions) {
            if (transactionId.equals(transaction.getTransactionId())) {
                return transaction;
            }
        }
        return null;
    }
}
