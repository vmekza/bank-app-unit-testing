/**
 * Represents a tool for analysis and calculations across potentially various loan scenarios.
 *
 * <p> Supports adjusting the
 * principal amount and evaluating loan affordability and term length.
 */
public class LoanAnalysisTool {

    /**
     * The principal amount of the loan.
     */
    private double principal;

    /**
     * The annual interest rate of the loan.
     */
    private double annualInterestRate;

    /**
     * The duration of the loan in years.
     */
    private int years;

    /**
     * Constructs a new instance.
     *
     * @param principal the principal amount of the loan; must be greater than 0
     * @param annualInterestRate the annual interest rate of the loan; must be greater than 0
     * @param years the duration of the loan in years; must be greater than 0
     * @throws IllegalArgumentException if the principal, interest rate, or years are not greater than 0
     */
    public LoanAnalysisTool(double principal, double annualInterestRate, int years) {
        if (principal <= 0 || annualInterestRate <= 0 || years <= 0) {
            throw new IllegalArgumentException("Principal, interest rate, and years must be greater than 0.");
        }
        this.principal = principal;
        this.annualInterestRate = annualInterestRate;
        this.years = years;
    }

    /**
     * Calculates the monthly payment amount for the loan.
     *
     * @return the monthly payment amount
     */
    public double calculateMonthlyPayment() {
        double monthlyInterestRate = annualInterestRate / 12 / 100;
        int numberOfPayments = years * 12;
        return principal * monthlyInterestRate / (1 - Math.pow(1 + monthlyInterestRate, -numberOfPayments));
    }

    /**
     * Calculates the total payment over the life of the loan.
     *
     * @return the total payment amount
     */
    public double calculateTotalPayment() {
        return calculateMonthlyPayment() * years * 12;
    }

    /**
     * Calculates the total interest paid over the life of the loan.
     *
     * @return the total interest amount
     */
    public double getTotalInterest() {
        return calculateTotalPayment() - principal;
    }

    /**
     * Returns a string detailing the principal, annual interest rate, and duration of the loan.
     *
     * @return a formatted string containing loan details
     */
    public String getLoanDetails() {
        return String.format("Principal: %.2f, Annual Interest Rate: %.2f%%, Years: %d", principal, annualInterestRate, years);
    }

    /**
     * Determines if the loan is affordable based on a predefined affordability threshold.
     *
     * @return true if the loan is considered affordable, false otherwise
     */
    public boolean isAffordable() {
        double affordabilityThreshold = principal / 12 * 0.1;
        return calculateMonthlyPayment() < affordabilityThreshold;
    }

    /**
     * Adjusts the loan's principal to a new value.
     *
     * @param newPrincipal the new principal amount of the loan; must be greater than 0
     * @throws IllegalArgumentException if the new principal is not greater than 0
     */
    public void adjustPrincipal(double newPrincipal) {
        if (newPrincipal <= 0) {
            throw new IllegalArgumentException("New principal must be greater than 0.");
        }
        this.principal = newPrincipal;
    }

    /**
     * Checks if the duration of the loan exceeds a predefined threshold for being considered long-term.
     *
     * @return true if the loan is considered long-term, false otherwise
     */
    public boolean isLongTerm() {
        return years > 10;
    }
}
