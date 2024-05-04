import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class TransactionLogTest {

    private TransactionLog log;
    private Transaction deposit;
    private Transaction withdrawal;

    @Before
    public void setUp() {
        log = new TransactionLog();
        deposit = new Transaction("TX100", 100.0, "Deposit");
        withdrawal = new Transaction("TX200", 50.0, "Withdrawal");
    }

    @Test
    public void testAddTransactionWithValidDeposit() {
        log.addTransaction(deposit);
        assertEquals(1, log.getNumTransactions());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddTransactionWithNullTransaction() {
        log.addTransaction(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddTransactionWithInvalidType() {
        Transaction invalid = new Transaction("TX300", 25.0, "InvalidType");
        log.addTransaction(invalid);
    }

    @Test
    public void testGetTransactionsNotEmpty() {
        log.addTransaction(deposit);
        assertFalse(log.getTransactions().isEmpty());
    }

    @Test
    public void testGetTransactionDetails() {
        log.addTransaction(deposit);
        String expectedDetails = "Transaction ID: TX100, Transaction Type: Deposit, Amount: 100.0";
        assertEquals(expectedDetails, log.getTransactionDetails().trim());
    }

    @Test
    public void testGetTotalAmount() {
        log.addTransaction(deposit);
        log.addTransaction(withdrawal);
        assertEquals(150.0, log.getTotalAmount(), 0.001);
    }

    @Test
    public void testGetTotalAmountByTypeDeposit() {
        log.addTransaction(deposit);
        assertEquals(100.0, log.getTotalAmountByType("Deposit"), 0.001);
    }

    @Test
    public void testGetTotalAmountByTypeWithdrawal() {
        log.addTransaction(withdrawal);
        assertEquals(50.0, log.getTotalAmountByType("Withdrawal"), 0.001);
    }

    @Test
    public void testFindTransactionByIdExists() {
        log.addTransaction(deposit);
        assertNotNull(log.findTransactionById("TX100"));
    }

    @Test
    public void testFindTransactionByIdNotExists() {
        log.addTransaction(deposit);
        assertNull(log.findTransactionById("TX999"));
    }

    @Test
    public void testNumTransactionsAfterAddingMultiple() {
        log.addTransaction(deposit);
        log.addTransaction(withdrawal);
        assertEquals(2, log.getNumTransactions());
    }

    @Test
    public void testTransactionsListIsACopy() {
        log.addTransaction(deposit);
        List<Transaction> transactions = log.getTransactions();
        transactions.remove(0);
        assertEquals(1, log.getNumTransactions());
    }

    @Test
    public void testGetTransactionsEmptyLog() {
        assertTrue(log.getTransactions().isEmpty());
    }

    @Test
    public void testGetTransactionDetailsEmptyLog() {
        assertEquals("", log.getTransactionDetails().trim());
    }

    @Test
    public void testGetTotalAmountEmptyLog() {
        assertEquals(0.0, log.getTotalAmount(), 0.001);
    }

    @Test
    public void testGetTotalAmountByTypeEmptyLog() {
        assertEquals(0.0, log.getTotalAmountByType("Deposit"), 0.001);
    }
}
