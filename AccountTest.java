import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class AccountTest {
    private Account account;
    private Account recipientAccount;

    @Before
    public void setUp() {
        account = new Account("123456", 1000.0);
        recipientAccount = new Account("654321", 200.0);
    }

    @Test
    public void testDepositSuccessfully() {
        account.deposit(500.0);
        assertEquals(1500.0, account.getBalance(), 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDepositNegativeAmount() {
        account.deposit(-300.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDepositZeroAmount() {
        account.deposit(0);
    }

    @Test
    public void testWithdrawSuccessfully() {
        account.withdraw(300.0);
        assertEquals(700.0, account.getBalance(), 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithdrawInsufficientFunds() {
        account.withdraw(1200.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithdrawNegativeAmount() {
        account.withdraw(-200.0);
    }

    @Test
    public void testTransferSuccessfully() {
        account.transferTo(recipientAccount, 500.0);
        assertEquals(500.0, account.getBalance(), 0.001);
        assertEquals(700.0, recipientAccount.getBalance(), 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTransferInsufficientFunds() {
        account.transferTo(recipientAccount, 1500.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTransferNegativeAmount() {
        account.transferTo(recipientAccount, -500.0);
    }

    @Test
    public void testIsOverdrawnFalse() {
        assertFalse(account.isOverdrawn());
    }

    @Test
    public void testIsNotOverdrawnAfterDeposit() {
        account.deposit(100.0);
        assertFalse(account.isOverdrawn());
    }

    @Test
    public void testGetBalanceAfterDeposit() {
        double depositAmount = 100.0;
        account.deposit(depositAmount);
        assertEquals(1100.0, account.getBalance(), 0.001);
    }

    @Test
    public void testGetBalanceAfterWithdrawal() {
        double withdrawalAmount = 100.0;
        account.withdraw(withdrawalAmount);
        assertEquals(900.0, account.getBalance(), 0.001);
    }

    @Test
    public void testGetBalanceInitial() {
        assertEquals(1000.0, account.getBalance(), 0.001);
    }

    @Test
    public void testGetAccountNumber() {
        assertEquals("123456", account.getAccountNumber());
    }

    @Test
    public void testGetAccountNumberNotChangedAfterDeposit() {
        account.deposit(100.0);
        assertEquals("123456", account.getAccountNumber());
    }

    @Test
    public void testGetAccountNumberNotChangedAfterWithdrawal() {
        account.withdraw(100.0);
        assertEquals("123456", account.getAccountNumber());
    }

    @Test
    public void testBalanceAfterMultipleTransactions() {
        account.deposit(200.0);
        account.withdraw(500.0);
        account.transferTo(recipientAccount, 200.0);
        assertEquals(500.0, account.getBalance(), 0.001);
        assertEquals(400.0, recipientAccount.getBalance(), 0.001);
    }
}
