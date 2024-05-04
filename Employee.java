/**
 * Represents an employee with a name and an employee ID.
 *
 * <p> Provides methods to manipulate and retrieve employee information,
 * such as promotion and retirement eligibility.
 */
public class Employee {

    /**
     * The name of the employee.
     */
    private String name;

    /**
     * The unique identifier for the employee.
     */
    private int employeeId;

    /**
     * Constructs a new Employee instance with a specified name and employee ID.
     *
     * @param name the name of the employee
     * @param employeeId the unique identifier for the employee; must be greater than 0
     * @throws IllegalArgumentException if the employee ID is not greater than 0
     */
    public Employee(String name, int employeeId) {
        if (employeeId <= 0) {
            throw new IllegalArgumentException("Employee ID must be greater than 0.");
        }
        this.name = name;
        this.employeeId = employeeId;
    }

    /**
     * Returns the name of the employee.
     *
     * @return the employee's name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the employee's name to a new value, ensuring it is not null or empty.
     *
     * @param newName the new name for the employee
     * @throws IllegalArgumentException if the new name is null or empty
     */
    public void setName(String newName) {
        if (newName == null || newName.trim().isEmpty()) {
        throw new IllegalArgumentException("Name cannot be null or empty.");
    }
    this.name = newName.trim();
}

    /**
     * Returns the unique identifier for the employee.
     *
     * @return the employee's ID
     */
    public int getEmployeeId() {
        return employeeId;
    }

    /**
     * Provides a string containing the details of the employee, including their name and ID.
     *
     * @return a detailed string representation of the employee
     */
    public String getDetails() {
        return "Employee Name: " + name + ", Employee ID: " + employeeId;
    }

    /**
     * Checks if the current employee ID is valid (greater than 0).
     *
     * @return true if the employee ID is valid, otherwise false
     */
    public boolean isValidEmployee() {
        return employeeId > 0;
    }

    /**
     * Simulates promoting the employee, affecting their employee ID.
     */
    public void promote() {
        this.employeeId += 1;
    }

    /**
     * Determines if the employee is eligible for retirement based on the provided age.
     *
     * @param age the age of the employee
     * @return true if the age is 65 or older, otherwise false
     * @throws IllegalArgumentException if the provided age is negative
     */
    public boolean isEligibleForRetirement(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative.");
        }
        return age >= 65;
    }
}
