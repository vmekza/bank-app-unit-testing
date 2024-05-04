/**
 * Represents a loan with a principal amount, an interest rate, and a duration.
 *
 * <p> Provides methods to calculate the interest, total amount due,
 * monthly payment, and checks for the term length of the loan.
 */
public class Loan {

    /**
     * The principal amount of the loan.
     */
    private double amount;

    /**
     * The annual interest rate of the loan.
     */
    private double interestRate;

    /**
     * The duration of the loan in years.
     */
    private int duration;

    /**
     * Constructs a new Loan instance.
     *
     * @param amount the principal amount of the loan; must be greater than 0
     * @param interestRate the annual interest rate of the loan; must be greater than 0
     * @param duration the duration of the loan in years; must be greater than 0
     * @throws IllegalArgumentException if the amount, interest rate, or duration is not greater than 0
     */
    public Loan(double amount, double interestRate, int duration) {
        if (amount <= 0 || interestRate <= 0 || duration <= 0) {
            throw new IllegalArgumentException("Amount, interest rate, and duration must be greater than 0.");
        }
        this.amount = amount;
        this.interestRate = interestRate;
        this.duration = duration;
    }

    /**
     * Calculates the total interest to be paid on the loan.
     *
     * @return the total interest for the entire duration of the loan
     */
    public double calculateInterest() {
        return amount * interestRate * duration / 100;
    }

    /**
     * Calculates the total amount to be repaid for the loan (principal + interest).
     *
     * @return the total amount due
     */
    public double getTotalAmount() {
        return amount + calculateInterest();
    }

    /**
     * Returns the duration of the loan in years.
     *
     * @return the duration of the loan
     */
    public int getDuration() {
        return duration;
    }

    /**
     * Checks if the loan is short-term, defined as 5 years or less.
     *
     * @return true if the loan is short-term, false otherwise
     */
    public boolean isShortTerm() {
        return duration <= 5;
    }

    /**
     * Adjusts the loan amount to a new value.
     *
     * @param newAmount the new amount of the loan. Must be greater than 0
     * @throws IllegalArgumentException if the new amount is not greater than 0
     */
    public void adjustAmount(double newAmount) {
        if (newAmount <= 0) {
            throw new IllegalArgumentException("New amount must be greater than 0.");
        }
        this.amount = newAmount;
    }

    /**
     * Modifies the loan's interest rate to a new value.
     *
     * @param newRate the new interest rate of the loan. Must be greater than 0
     * @throws IllegalArgumentException if the new interest rate is not greater than 0
     */
    public void modifyInterestRate(double newRate) {
        if (newRate <= 0) {
            throw new IllegalArgumentException("New interest rate must be greater than 0.");
        }
        this.interestRate = newRate;
    }

    /**
     * Checks if the loan is considered long-term, defined as more than 10 years.
     *
     * @return true if the loan is long-term, false otherwise
     */
    public boolean isLongTerm() {
        return duration > 10;
    }

    /**
     * Calculates the monthly payment amount for the loan.
     *
     * @return the monthly payment amount
     */
    public double calculateMonthlyPayment() {
        double monthlyRate = interestRate / 12 / 100;
        double numberOfPayments = duration * 12;
        return (amount * monthlyRate) / (1 - Math.pow(1 + monthlyRate, -numberOfPayments));
    }
}
