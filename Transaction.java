/**
 * Represents a financial transaction with a unique ID, amount, and type.
 *
 */
public class Transaction {

    /**
     * The unique identifier for this transaction.
     */
    private String transactionId;

    /**
     * The amount of money involved in the transaction.
     */
    private double amount;

    /**
     * The type of the transaction, e.g., "Deposit" or "Withdrawal".
     */
    private String type;

    /**
     * Constructs a new Transaction with the specified ID, amount, and type.
     *
     * @param transactionId the unique identifier for the transaction
     * @param amount the financial amount of the transaction
     * @param type the type of the transaction (e.g., "Deposit" or "Withdrawal")
     * @throws IllegalArgumentException if the amount is less than or equal to 0
     */
    public Transaction(String transactionId, double amount, String type) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Transaction amount must be greater than 0.");
        }
        this.transactionId = transactionId;
        this.amount = amount;
        this.type = type;
    }

    /**
     * Returns the transaction ID.
     *
     * @return the transaction ID
     */
    public String getTransactionId() {
        return transactionId;
    }

    /**
     * Returns the transaction amount.
     *
     * @return the transaction amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Returns the transaction type.
     *
     * @return the transaction type
     */
    public String getType() {
        return type;
    }

    /**
     * Returns a string representation of the transaction details, including transaction ID, type, and amount.
     *
     * @return a detailed string of the transaction
     */
    public String getDetails() {
        return "Transaction ID: " + transactionId + ", Transaction Type: " + type + ", Amount: " + amount;
    }

    /**
     * Checks if the transaction is a deposit.
     *
     * @return true if the transaction type is "Deposit", false otherwise
     */
    public boolean isDeposit() {
        return "Deposit".equalsIgnoreCase(type);
    }

    /**
     * Checks if the transaction is a withdrawal.
     *
     * @return true if the transaction type is "Withdrawal", false otherwise
     */
    public boolean isWithdrawal() {
        return "Withdrawal".equalsIgnoreCase(type);
    }

    /**
     * Validates the transaction type.
     *
     * @return true if the transaction type is either "Deposit" or "Withdrawal", false otherwise
     */
    public boolean isValidType() {
        return "Deposit".equalsIgnoreCase(type) || "Withdrawal".equalsIgnoreCase(type);
    }

    /**
     * Reverses the transaction effect by returning the negative amount.
     *
     * @return the negated transaction amount
     */
    public double reverseTransaction() {
        return -amount;
    }

    /**
     * Checks if this transaction is equal to another based on their IDs.
     *
     * @param other the other transaction to compare with
     * @return true if both transactions have the same ID, false otherwise
     */
    public boolean equals(Transaction other) {
        return this.transactionId.equals(other.transactionId);
    }
}
