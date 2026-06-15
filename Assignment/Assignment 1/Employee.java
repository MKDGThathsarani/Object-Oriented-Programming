public class Employee {
    // Instance variables
    private String firstName;
    private String lastName;
    private double monthlySalary;
    
    // Constructor
    public Employee(String firstName, String lastName, double monthlySalary) {
        this.firstName = firstName;
        this.lastName = lastName;
        
        // If monthly salary is not positive, do not set its value (set to 0.0)
        if (monthlySalary > 0) {
            this.monthlySalary = monthlySalary;
        } else {
            this.monthlySalary = 0.0;
        }
    }
    
    // Getter for firstName
    public String getFirstName() {
        return firstName;
    }
    
    // Setter for firstName
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    // Getter for lastName
    public String getLastName() {
        return lastName;
    }
    
    // Setter for lastName
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    // Getter for monthlySalary
    public double getMonthlySalary() {
        return monthlySalary;
    }
    
    // Setter for monthlySalary (with validation)
    public void setMonthlySalary(double monthlySalary) {
        if (monthlySalary > 0) {
            this.monthlySalary = monthlySalary;
        }
        // If not positive, do not set (ignore)
    }
    
    // Method to calculate yearly salary
    public double getYearlySalary() {
        return monthlySalary * 12;
    }
    
    // Method to give a raise (percentage)
    public void giveRaise(double percentage) {
        double raiseAmount = monthlySalary * (percentage / 100);
        monthlySalary = monthlySalary + raiseAmount;
    }
}
