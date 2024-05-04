import org.junit.Test;
import static org.junit.Assert.*;

public class LoanTest {

    @Test
    public void testConstructorValidInput() {
        new Loan(10000, 5, 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorNegativeAmount() {
        new Loan(-10000, 5, 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorZeroInterestRate() {
        new Loan(10000, 0, 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorNegativeDuration() {
        new Loan(10000, 5, -10);
    }

    @Test
    public void testCalculateInterestNormal() {
        Loan loan = new Loan(10000, 5, 10);
        assertEquals(5000, loan.calculateInterest(), 0.001);
    }

    @Test
    public void testGetTotalAmountNormal() {
        Loan loan = new Loan(10000, 5, 10);
        assertEquals(15000, loan.getTotalAmount(), 0.001);
    }

    @Test
    public void testGetTotalAmountWithLowInterest() {
    Loan loan = new Loan(10000, 0.01, 10);
    double totalAmount = loan.getTotalAmount();
    assertTrue("The total amount should be slightly above the principal amount.", totalAmount > 10000);
}

    @Test
    public void testGetDuration() {
        Loan loan = new Loan(10000, 5, 10);
        assertEquals(10, loan.getDuration());
    }

    @Test
    public void testIsShortTermTrue() {
        Loan loan = new Loan(10000, 5, 5);
        assertTrue(loan.isShortTerm());
    }

    @Test
    public void testIsShortTermFalse() {
        Loan loan = new Loan(10000, 5, 6);
        assertFalse(loan.isShortTerm());
    }

    @Test
    public void testAdjustAmountValid() {
        Loan loan = new Loan(10000, 5, 10);
        loan.adjustAmount(15000);
        assertEquals(15000, loan.getTotalAmount() - loan.calculateInterest(), 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAdjustAmountNegative() {
        Loan loan = new Loan(10000, 5, 10);
        loan.adjustAmount(-15000);
    }

    @Test
    public void testModifyInterestRateValid() {
        Loan loan = new Loan(10000, 5, 10);
        loan.modifyInterestRate(10);
        assertEquals(10000, loan.calculateInterest(), 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testModifyInterestRateNegative() {
        Loan loan = new Loan(10000, 5, 10);
        loan.modifyInterestRate(-10);
    }

    @Test
    public void testIsLongTermTrue() {
        Loan loan = new Loan(10000, 5, 11);
        assertTrue(loan.isLongTerm());
    }

    @Test
    public void testIsLongTermFalse() {
        Loan loan = new Loan(10000, 5, 10);
        assertFalse(loan.isLongTerm());
    }

    @Test
    public void testCalculateMonthlyPaymentNormal() {
        Loan loan = new Loan(1200, 12, 1);
        double monthlyPayment = loan.calculateMonthlyPayment();
        assertTrue(monthlyPayment > 0);
    }

}
