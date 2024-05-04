import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BankTest {

    private Bank bank;

    @Before
    public void setUp() {
        bank = new Bank();
    }

    @Test
    public void testCreateAccountSuccess() {
        bank.createAccount("123", 500.0);
        assertTrue(bank.hasAccount("123"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateAccountDuplicate() {
        bank.createAccount("123", 500.0);
        bank.createAccount("123", 600.0);
    }

    @Test
    public void testCreateAccountInitialDeposit() {
        bank.createAccount("124", 0.0);
        assertTrue(bank.hasAccount("124"));
    }

    @Test
    public void testCloseAccountSuccess() {
        bank.createAccount("125", 500.0);
        bank.closeAccount("125");
        assertFalse(bank.hasAccount("125"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCloseAccountNonExistent() {
        bank.closeAccount("999");
    }

    @Test
    public void testCloseAccountAndReopen() {
        bank.createAccount("126", 500.0);
        bank.closeAccount("126");
        bank.createAccount("126", 300.0);
        assertTrue(bank.hasAccount("126"));
    }

    @Test
    public void testGetNumAccountsEmpty() {
        assertEquals(0, bank.getNumAccounts());
    }

    @Test
    public void testGetNumAccountsAfterAdding() {
        bank.createAccount("127", 500.0);
        assertEquals(1, bank.getNumAccounts());
    }

    @Test
    public void testGetNumAccountsAfterAddingAndRemoving() {
        bank.createAccount("128", 500.0);
        bank.closeAccount("128");
        assertEquals(0, bank.getNumAccounts());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPrintAccountDetailsNonExistent() {
        bank.printAccountDetails("999");
    }

    @Test
    public void testPrintAccountDetailsExist() {
        bank.createAccount("129", 500.0);
        bank.printAccountDetails("129");
        assertTrue(true);
    }

    @Test
    public void testHasAccountTrue() {
        bank.createAccount("130", 500.0);
        assertTrue(bank.hasAccount("130"));
    }

    @Test
    public void testHasAccountFalse() {
        assertFalse(bank.hasAccount("131"));
    }

    @Test
    public void testHasAccountAfterClosing() {
        bank.createAccount("132", 500.0);
        bank.closeAccount("132");
        assertFalse(bank.hasAccount("132"));
    }

    @Test
    public void testCreateAccountNegativeDeposit() {
        bank.createAccount("133", -100.0);
        assertTrue(bank.hasAccount("133"));
        assertEquals(-100.0, bank.getAccountBalance("133"), 0.01);
    }
}

