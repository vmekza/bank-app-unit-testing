import static org.junit.Assert.*;
import org.junit.Test;

public class TransactionTest {

    @Test
    public void testConstructorWithValidData() {
        Transaction transaction = new Transaction("TX123", 100.0, "Deposit");
        assertNotNull(transaction);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorWithZeroAmount() {
        new Transaction("TX123", 0.0, "Deposit");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorWithNegativeAmount() {
        new Transaction("TX123", -1.0, "Deposit");
    }

    @Test
    public void testGetTransactionId() {
        Transaction transaction = new Transaction("TX123", 100.0, "Deposit");
        assertEquals("TX123", transaction.getTransactionId());
    }

    @Test
    public void testGetAmount() {
        Transaction transaction = new Transaction("TX123", 100.0, "Deposit");
        assertEquals(100.0, transaction.getAmount(), 0.001);
    }

    @Test
    public void testGetType() {
        Transaction transaction = new Transaction("TX123", 100.0, "Deposit");
        assertEquals("Deposit", transaction.getType());
    }

    @Test
    public void testGetDetails() {
        Transaction transaction = new Transaction("TX123", 100.0, "Deposit");
        String expected = "Transaction ID: TX123, Transaction Type: Deposit, Amount: 100.0";
        assertEquals(expected, transaction.getDetails());
    }

    @Test
    public void testIsDepositTrue() {
        Transaction transaction = new Transaction("TX123", 100.0, "Deposit");
        assertTrue(transaction.isDeposit());
    }

    @Test
    public void testIsDepositFalse() {
        Transaction transaction = new Transaction("TX123", 100.0, "Withdrawal");
        assertFalse(transaction.isDeposit());
    }

    @Test
    public void testIsWithdrawalTrue() {
        Transaction transaction = new Transaction("TX123", 100.0, "Withdrawal");
        assertTrue(transaction.isWithdrawal());
    }

    @Test
    public void testIsWithdrawalFalse() {
        Transaction transaction = new Transaction("TX123", 100.0, "Deposit");
        assertFalse(transaction.isWithdrawal());
    }

    @Test
    public void testIsValidTypeWithDeposit() {
        Transaction transaction = new Transaction("TX123", 100.0, "Deposit");
        assertTrue(transaction.isValidType());
    }

    @Test
    public void testIsValidTypeWithWithdrawal() {
        Transaction transaction = new Transaction("TX123", 100.0, "Withdrawal");
        assertTrue(transaction.isValidType());
    }

    @Test
    public void testIsValidTypeWithInvalidType() {
        Transaction transaction = new Transaction("TX123", 100.0, "InvalidType");
        assertFalse(transaction.isValidType());
    }

    @Test
    public void testReverseTransaction() {
        Transaction transaction = new Transaction("TX123", 100.0, "Deposit");
        assertEquals(-100.0, transaction.reverseTransaction(), 0.001);
    }

    @Test
    public void testEqualsWithSameId() {
        Transaction transaction1 = new Transaction("TX123", 100.0, "Deposit");
        Transaction transaction2 = new Transaction("TX123", 200.0, "Withdrawal");
        assertTrue(transaction1.equals(transaction2));
    }

    @Test
    public void testEqualsWithDifferentId() {
        Transaction transaction1 = new Transaction("TX123", 100.0, "Deposit");
        Transaction transaction2 = new Transaction("TX124", 100.0, "Deposit");
        assertFalse(transaction1.equals(transaction2));
    }
}
