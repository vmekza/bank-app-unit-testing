import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BranchTest {

    private Branch branch;

    @Before
    public void setUp() {
        branch = new Branch("B001", "New York", 10);
    }

    @Test
    public void testConstructorWithValidParameters() {
        assertNotNull(branch);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorWithNegativeEmployees() {
        new Branch("B002", "Los Angeles", -1);
    }

    @Test
    public void testGetBranchCode() {
        assertEquals("B001", branch.getBranchCode());
    }

    @Test
    public void testGetLocation() {
        assertEquals("New York", branch.getLocation());
    }

    @Test
    public void testGetNumberOfEmployees() {
        assertEquals(10, branch.getNumberOfEmployees());
    }

    @Test
    public void testUpdateLocationWithValidLocation() {
        branch.updateLocation("Chicago");
        assertEquals("Chicago", branch.getLocation());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUpdateLocationWithNull() {
        branch.updateLocation(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUpdateLocationWithEmptyString() {
        branch.updateLocation("");
    }

    @Test
    public void testHireEmployeesWithValidNumber() {
        branch.hireEmployees(1);
        assertEquals(11, branch.getNumberOfEmployees());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testHireEmployeesWithZero() {
        branch.hireEmployees(0);
    }

    @Test
    public void testReleaseEmployeesWithValidNumber() {
        branch.releaseEmployees(1);
        assertEquals(9, branch.getNumberOfEmployees());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testReleaseEmployeesWithZero() {
        branch.releaseEmployees(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testReleaseEmployeesMoreThanExist() {
        branch.releaseEmployees(11);
    }

    @Test
    public void testNeedsMoreEmployeesTrue() {
        Branch smallBranch = new Branch("B003", "Boston", 4);
        assertTrue(smallBranch.needsMoreEmployees());
    }

    @Test
    public void testNeedsMoreEmployeesFalse() {
        assertFalse(branch.needsMoreEmployees());
    }

    @Test
    public void testIsLargeBranchTrue() {
        Branch largeBranch = new Branch("B004", "San Francisco", 15);
        assertTrue(largeBranch.isLargeBranch());
    }

    @Test
    public void testIsLargeBranchFalse() {
        assertFalse(branch.isLargeBranch());
    }

    @Test
    public void testGetDetails() {
        String expectedDetails = "Branch Code: B001, Location: New York, Number of Employees: 10";
        assertEquals(expectedDetails, branch.getDetails());
    }
}
