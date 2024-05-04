/**
 * Represents a customer with basic personal information and provides methods to access and modify their details.
 */
public class Customer {

    /**
     * The name of the customer.
     */
    private String name;

    /**
     * The age of the customer.
     */
    private int age;

    /**
     * Constructs a new Customer instance with the specified name and age.
     *
     * @param name the name of the customer
     * @param age the age of the customer; must not be negative
     * @throws IllegalArgumentException if the age is negative
     */
    public Customer(String name, int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative.");
        }
        this.name = name;
        this.age = age;
    }

    /**
     * Returns the name of the customer.
     *
     * @return the customer's name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the age of the customer.
     *
     * @return the customer's age
     */
    public int getAge() {
        return age;
    }

    /**
     * Returns a string containing the details of the customer, including name and age.
     *
     * @return a detailed string representation of the customer
     */
    public String getDetails() {
        return "Customer Name: " + name + "\nCustomer Age: " + age;
    }

    /**
     * Checks if the customer is considered an adult (18 years or older).
     *
     * @return true if the customer is 18 or older, otherwise false
     */
    public boolean isAdult() {
        return age >= 18;
    }

    /**
     * Updates the customer's name to the specified new name.
     *
     * @param newName the new name for the customer; must not be null or empty
     * @throws IllegalArgumentException if the new name is null or empty
     */
    public void updateName(String newName) {
        if (newName == null || newName.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty.");
        }
        this.name = newName;
    }

    /**
     * Increases the customer's age by one, simulating a birthday celebration.
     */
    public void celebrateBirthday() {
        this.age += 1;
    }

    /**
     * Checks if the customer is considered a senior (65 years or older).
     *
     * @return true if the customer is 65 or older, otherwise false
     */
    public boolean isSenior() {
        return age >= 65;
    }

    /**
     * Checks if the customer is eligible for a youth discount (under 25 years).
     *
     * @return true if the customer is younger than 25, otherwise false
     */
    public boolean isEligibleForYouthDiscount() {
        return age < 25;
    }
}
