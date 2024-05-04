import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class EmployeeTest {

    private Employee employee;

    @Before
    public void setUp() {
        employee = new Employee("John Doe", 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructor_InvalidEmployeeId_ThrowsException() {
        new Employee("Invalid ID", 0);
    }

    @Test
    public void getName_InitialName_ReturnsCorrectName() {
        assertEquals("John Doe", employee.getName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void setName_NullName_ThrowsException() {
        employee.setName(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setName_EmptyName_ThrowsException() {
        employee.setName("");
    }

    @Test
    public void setName_ValidName_SetsNameCorrectly() {
        employee.setName("Jane Doe");
        assertEquals("Jane Doe", employee.getName());
    }

    @Test
    public void getEmployeeId_InitialId_ReturnsCorrectId() {
        assertEquals(1, employee.getEmployeeId());
    }

    @Test
    public void getDetails_ValidEmployee_ReturnsCorrectDetails() {
        String expected = "Employee Name: John Doe, Employee ID: 1";
        assertEquals(expected, employee.getDetails());
    }

    @Test
    public void isValidEmployee_ValidId_ReturnsTrue() {
        assertTrue(employee.isValidEmployee());
    }

    @Test
    public void promote_IncreasesEmployeeId() {
        employee.promote();
        assertEquals(2, employee.getEmployeeId());
    }

    @Test(expected = IllegalArgumentException.class)
    public void isEligibleForRetirement_NegativeAge_ThrowsException() {
        employee.isEligibleForRetirement(-1);
    }

    @Test
    public void isEligibleForRetirement_AgeUnder65_ReturnsFalse() {
        assertFalse(employee.isEligibleForRetirement(64));
    }

    @Test
    public void isEligibleForRetirement_Age65_ReturnsTrue() {
        assertTrue(employee.isEligibleForRetirement(65));
    }

    @Test
    public void isEligibleForRetirement_AgeOver65_ReturnsTrue() {
        assertTrue(employee.isEligibleForRetirement(66));
    }

    @Test
    public void constructor_ValidEmployee_CreatesEmployee() {
        assertNotNull(new Employee("Valid Employee", 1));
    }

    @Test
    public void setName_TrimmableName_SetsTrimmedName() {
        employee.setName(" Jane Doe ");
        assertEquals("Jane Doe", employee.getName());
    }

    @Test
    public void promote_MultiplePromotions_CorrectlyIncreasesId() {
        for (int i = 0; i < 5; i++) {
            employee.promote();
        }
        assertEquals(6, employee.getEmployeeId());
    }
}
