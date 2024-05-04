/**
 * Represents a branch of a company or organization, holding information about its location, branch code, and the number of employees working in that branch.
 */
public class Branch {

    /**
     * The unique code identifying the branch.
     */
    private String branchCode;

    /**
     * The geographical location of the branch.
     */
    private String location;

    /**
     * The current number of employees working at the branch.
     */
    private int numberOfEmployees;

    /**
     * Constructs a new Branch instance with the specified details.
     *
     * @param branchCode        the unique code identifying the branch
     * @param location          the geographical location of the branch
     * @param numberOfEmployees the initial number of employees in the branch
     * @throws IllegalArgumentException if the number of employees is set to a negative value
     */
    public Branch(String branchCode, String location, int numberOfEmployees) {
        if (numberOfEmployees < 0) {
            throw new IllegalArgumentException("Number of employees cannot be negative.");
        }
        this.branchCode = branchCode;
        this.location = location;
        this.numberOfEmployees = numberOfEmployees;
    }

    /**
     * Returns the branch code.
     *
     * @return the unique code of the branch
     */
    public String getBranchCode() {
        return branchCode;
    }

    /**
     * Returns the location of the branch.
     *
     * @return the geographical location of the branch
     */
    public String getLocation() {
        return location;
    }

    /**
     * Returns the number of employees in the branch.
     *
     * @return the current number of employees
     */
    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    /**
     * Updates the location of the branch.
     *
     * @param newLocation the new geographical location of the branch
     * @throws IllegalArgumentException if the new location is null or an empty string
     */
    public void updateLocation(String newLocation) {
        if (newLocation == null || newLocation.trim().isEmpty()) {
            throw new IllegalArgumentException("Location cannot be null or empty.");
        }
        this.location = newLocation;
    }

    /**
     * Increases the number of employees in the branch by the specified number.
     *
     * @param number the number of employees to hire
     * @throws IllegalArgumentException if the number is less than 1
     */
    public void hireEmployees(int number) {
        if (number < 1) {
            throw new IllegalArgumentException("Must hire at least one employee.");
        }
        this.numberOfEmployees += number;
    }

    /**
     * Decreases the number of employees in the branch by the specified number.
     *
     * @param number the number of employees to release
     * @throws IllegalArgumentException if the number is less than 1 or greater than the current number of employees
     */
    public void releaseEmployees(int number) {
        if (number < 1 || number > this.numberOfEmployees) {
            throw new IllegalArgumentException("Invalid number of employees to release.");
        }
        this.numberOfEmployees -= number;
    }

    /**
     * Checks if the branch needs more employees.
     *
     * @return true if the number of employees is less than 5, otherwise false
     */
    public boolean needsMoreEmployees() {
        return this.numberOfEmployees < 5;
    }

    /**
     * Returns a string representation of the branch details.
     *
     * @return the branch code, location, and number of employees as a formatted string
     */
    public String getDetails() {
        return "Branch Code: " + branchCode + ", Location: " + location + ", Number of Employees: " + numberOfEmployees;
    }

    /**
     * Checks if the branch is considered a large branch based on the number of employees.
     *
     * @return true if the number of employees is greater than 10, otherwise false
     */
    public boolean isLargeBranch() {
        return numberOfEmployees > 10;
    }
}
