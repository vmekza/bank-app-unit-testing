import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CustomerTest {

    private Customer customer;

    @Before
    public void setUp() {
        customer = new Customer("Alice Johnson", 30);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructor_NegativeAge_ThrowsException() {
        new Customer("Bob Smith", -1);
    }

    @Test
    public void getName_ReturnsCorrectName() {
        assertEquals("Alice Johnson", customer.getName());
    }

    @Test
    public void getAge_ReturnsCorrectAge() {
        assertEquals(30, customer.getAge());
    }

    @Test
    public void getDetails_ReturnsCorrectDetails() {
        assertEquals("Customer Name: Alice Johnson\nCustomer Age: 30", customer.getDetails());
    }

    @Test
    public void isAdult_Over18_ReturnsTrue() {
        assertTrue(customer.isAdult());
    }

    @Test
    public void isAdult_Under18_ReturnsFalse() {
        Customer youngCustomer = new Customer("Charlie Brown", 17);
        assertFalse(youngCustomer.isAdult());
    }

    @Test(expected = IllegalArgumentException.class)
    public void updateName_NullName_ThrowsException() {
        customer.updateName(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void updateName_EmptyName_ThrowsException() {
        customer.updateName("");
    }

    @Test
    public void updateName_ValidName_UpdatesName() {
        customer.updateName("Diana Crisp");
        assertEquals("Diana Crisp", customer.getName());
    }

    @Test
    public void celebrateBirthday_IncreasesAge() {
        customer.celebrateBirthday();
        assertEquals(31, customer.getAge());
    }

    @Test
    public void isSenior_Over65_ReturnsTrue() {
        Customer seniorCustomer = new Customer("Evan Wallace", 65);
        assertTrue(seniorCustomer.isSenior());
    }

    @Test
    public void isSenior_Under65_ReturnsFalse() {
        assertFalse(customer.isSenior());
    }

    @Test
    public void isEligibleForYouthDiscount_Under25_ReturnsTrue() {
        Customer youngCustomer = new Customer("Fiona Gallagher", 24);
        assertTrue(youngCustomer.isEligibleForYouthDiscount());
    }

    @Test
    public void isEligibleForYouthDiscount_Over25_ReturnsFalse() {
        assertFalse(customer.isEligibleForYouthDiscount());
    }

    @Test
    public void isEligibleForYouthDiscount_Exactly25_ReturnsFalse() {
        Customer borderlineCustomer = new Customer("George Harris", 25);
        assertFalse(borderlineCustomer.isEligibleForYouthDiscount());
    }
}
