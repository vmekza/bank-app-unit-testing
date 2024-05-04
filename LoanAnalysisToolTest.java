import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class LoanAnalysisToolTest {
    private LoanAnalysisTool calculator;

    @Before
    public void setUp() {
        calculator = new LoanAnalysisTool(10000, 5, 5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructorNegativePrincipalThrowsException() {
        new LoanAnalysisTool(-10000, 5, 5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructorZeroInterestRateThrowsException() {
        new LoanAnalysisTool(10000, 0, 5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructorNegativeDurationThrowsException() {
        new LoanAnalysisTool(10000, 5, -5);
    }

    @Test
    public void calculateMonthlyPaymentCorrectValue() {
        assertEquals(188.71, calculator.calculateMonthlyPayment(), 0.01);
    }

    @Test
    public void calculateTotalPaymentCorrectValue() {
        assertEquals(11322.74, calculator.calculateTotalPayment(), 0.01);
    }

    @Test
    public void getTotalInterestCorrectValue() {
        assertEquals(1322.74, calculator.getTotalInterest(), 0.01);
    }

    @Test
    public void adjustPrincipalToHigherValue() {
        calculator.adjustPrincipal(15000);
        assertEquals(15000, calculator.calculateTotalPayment() - calculator.getTotalInterest(), 0.01);
    }

    @Test(expected = IllegalArgumentException.class)
    public void adjustPrincipalToNegativeValueThrowsException() {
        calculator.adjustPrincipal(-10000);
    }

    @Test
    public void isLongTermReturnsTrueForLongTermLoan() {
        LoanAnalysisTool longTermCalculator = new LoanAnalysisTool(10000, 5, 15);
        assertTrue(longTermCalculator.isLongTerm());
    }

    @Test
    public void isLongTermReturnsFalseForShortTermLoan() {
        assertFalse(calculator.isLongTerm());
    }

    @Test
    public void calculateMonthlyPaymentWithHighInterestRate() {
        LoanAnalysisTool highInterestCalculator = new LoanAnalysisTool(10000, 20, 5);
        assertTrue(highInterestCalculator.calculateMonthlyPayment() > calculator.calculateMonthlyPayment());
    }

    @Test
    public void calculateTotalPaymentDecreasesWithShorterDuration() {
        LoanAnalysisTool shorterDurationCalculator = new LoanAnalysisTool(10000, 5, 3);
        assertTrue(shorterDurationCalculator.calculateTotalPayment() < calculator.calculateTotalPayment());
    }

    @Test
    public void getLoanDetailsReturnsExpectedString() {
    String expectedDetails = String.format("Principal: %.2f, Annual Interest Rate: %.2f%%, Years: %d", 10000.0, 5.0, 5);
    assertEquals("The loan details string should match the expected format and values.", expectedDetails, calculator.getLoanDetails());
    }

    @Test
    public void isAffordableReturnsFalseForExpensiveLoan() {
    LoanAnalysisTool expensiveLoanCalculator = new LoanAnalysisTool(10000, 5, 1);
    assertFalse("The loan should not be considered affordable if the monthly payment exceeds the affordability threshold.", expensiveLoanCalculator.isAffordable());
    }

   @Test
    public void isAffordableReturnsTrueUnderDefinedCriteria() {
    LoanAnalysisTool calculatorForAffordableLoan = new LoanAnalysisTool(5000, 1, 20);
    assertTrue("The loan should be considered affordable under the defined criteria.", calculatorForAffordableLoan.isAffordable());
}







}


