// Java Program - Inheritance Practice

// Parent Class (Super Class)
class Person {
    protected String name;
    protected int age;
    
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

// Child Class (Sub Class)
class Student extends Person {
    private String studentId;
    private String course;
    
    public Student(String name, int age, String studentId, String course) {
        super(name, age);  // Parent constructor call
        this.studentId = studentId;
        this.course = course;
    }
    
    @Override
    public void display() {
        super.display();  // Parent method call
        System.out.println("Student ID: " + studentId);
        System.out.println("Course: " + course);
    }
}

// Another Child Class
class Lecturer extends Person {
    private String employeeId;
    private double salary;
    
    public Lecturer(String name, int age, String employeeId, double salary) {
        super(name, age);
        this.employeeId = employeeId;
        this.salary = salary;
    }
    
    @Override
    public void display() {
        super.display();
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Salary: " + salary);
    }
}

public class Main {
    public static void main(String[] args) {
        // Student Object
        Student s1 = new Student("Kamal", 22, "S001", "Computer Science");
        System.out.println("--- Student ---");
        s1.display();
        
        // Lecturer Object
        Lecturer l1 = new Lecturer("Dr. Silva", 45, "L001", 120000);
        System.out.println("\n--- Lecturer ---");
        l1.display();
    }
}
