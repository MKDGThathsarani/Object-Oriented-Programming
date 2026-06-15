public class EmployeeTest {
    public static void main(String[] args) {
        
        // Create two Employee objects
        Employee emp1 = new Employee("John", "Doe", 5000.0);
        Employee emp2 = new Employee("Jane", "Smith", 6000.0);
        
        // Display each object's yearly salary
        System.out.println("=== BEFORE 10% RAISE ===");
        System.out.println(emp1.getFirstName() + " " + emp1.getLastName() + 
                           "'s Yearly Salary: $" + emp1.getYearlySalary());
        System.out.println(emp2.getFirstName() + " " + emp2.getLastName() + 
                           "'s Yearly Salary: $" + emp2.getYearlySalary());
        
        // Give each Employee a 10% raise
        emp1.giveRaise(10);
        emp2.giveRaise(10);
        
        // Display each object's yearly salary again
        System.out.println("\n=== AFTER 10% RAISE ===");
        System.out.println(emp1.getFirstName() + " " + emp1.getLastName() + 
                           "'s Yearly Salary: $" + emp1.getYearlySalary());
        System.out.println(emp2.getFirstName() + " " + emp2.getLastName() + 
                           "'s Yearly Salary: $" + emp2.getYearlySalary());
        
        // Test validation (monthly salary not positive)
        System.out.println("\n=== TESTING VALIDATION ===");
        Employee emp3 = new Employee("Test", "User", -1000.0);
        System.out.println("Salary for negative input: $" + emp3.getMonthlySalary()); // Should be 0.0
        
        emp3.setMonthlySalary(-500.0); // Should not change
        System.out.println("After trying to set negative salary: $" + emp3.getMonthlySalary()); // Still 0.0
        
        emp3.setMonthlySalary(3000.0); // Valid input
        System.out.println("After setting valid salary: $" + emp3.getMonthlySalary()); // 3000.0
    }
}
