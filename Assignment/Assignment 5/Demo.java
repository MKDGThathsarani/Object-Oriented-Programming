// Person.java - Superclass
class Person {
    String name;
    int age;
    
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public void displayInfo() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

// Student.java - Subclass of Person
class Student extends Person {
    int studentId;
    
    public Student(String name, int age, int studentId) {
        super(name, age);
        this.studentId = studentId;
    }
}

// UndergraduateStudent.java - Subclass of Student
class UndergraduateStudent extends Student {
    String major;
    
    public UndergraduateStudent(String name, int age, int studentId, String major) {
        super(name, age, studentId);
        this.major = major;
    }
}

// GraduateStudent.java - Subclass of Student
class GraduateStudent extends Student {
    String researchTopic;
    
    public GraduateStudent(String name, int age, int studentId, String researchTopic) {
        super(name, age, studentId);
        this.researchTopic = researchTopic;
    }
}

// Employee.java - Subclass of Person
class Employee extends Person {
    int employeeId;
    
    public Employee(String name, int age, int employeeId) {
        super(name, age);
        this.employeeId = employeeId;
    }
}

// Manager.java - Subclass of Employee
class Manager extends Employee {
    String department;
    
    public Manager(String name, int age, int employeeId, String department) {
        super(name, age, employeeId);
        this.department = department;
    }
}

// Worker.java - Subclass of Employee
class Worker extends Employee {
    String shift;
    
    public Worker(String name, int age, int employeeId, String shift) {
        super(name, age, employeeId);
        this.shift = shift;
    }
}

// Account.java - Superclass
class Account {
    int accountNumber;
    double balance;
    
    public Account(int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
}

// SavingsAccount.java - Subclass of Account
class SavingsAccount extends Account {
    double interestRate;
    
    public SavingsAccount(int accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }
}

// CheckingAccount.java - Subclass of Account
class CheckingAccount extends Account {
    double overdraftLimit;
    
    public CheckingAccount(int accountNumber, double balance, double overdraftLimit) {
        super(accountNumber, balance);
        this.overdraftLimit = overdraftLimit;
    }
}

// Bank.java - Superclass
class Bank {
    String bankName;
    
    public Bank(String bankName) {
        this.bankName = bankName;
    }
}

// SBI.java - Subclass of Bank
class SBI extends Bank {
    String branch;
    
    public SBI(String bankName, String branch) {
        super(bankName);
        this.branch = branch;
    }
}

// HNB.java - Subclass of Bank
class HNB extends Bank {
    String branch;
    
    public HNB(String bankName, String branch) {
        super(bankName);
        this.branch = branch;
    }
}

// BOC.java - Subclass of Bank
class BOC extends Bank {
    String branch;
    
    public BOC(String bankName, String branch) {
        super(bankName);
        this.branch = branch;
    }
}

// Demo.java - Main class (public class with matching filename)
public class Demo {
    public static void main(String[] args) {
        // Creating objects of all subclasses
        UndergraduateStudent ug = new UndergraduateStudent("Kasun", 22, 1001, "Computer Science");
        GraduateStudent g = new GraduateStudent("Nimal", 25, 1002, "Machine Learning");
        Manager m = new Manager("Amal", 35, 101, "IT");
        Worker w = new Worker("Saman", 28, 102, "Night");
        SavingsAccount sa = new SavingsAccount(12345, 5000.0, 2.5);
        CheckingAccount ca = new CheckingAccount(67890, 1000.0, 500.0);
        SBI sbi = new SBI("SBI", "Colombo");
        HNB hnb = new HNB("HNB", "Kandy");
        BOC boc = new BOC("BOC", "Matara");

        System.out.println("--- University System ---");
        ug.displayInfo();
        System.out.println("Student ID: " + ug.studentId + ", Major: " + ug.major);
        g.displayInfo();
        System.out.println("Student ID: " + g.studentId + ", Research Topic: " + g.researchTopic);

        System.out.println("\n--- Employee System ---");
        m.displayInfo();
        System.out.println("Employee ID: " + m.employeeId + ", Department: " + m.department);
        w.displayInfo();
        System.out.println("Employee ID: " + w.employeeId + ", Shift: " + w.shift);

        System.out.println("\n--- Bank System ---");
        System.out.println("Savings Account " + sa.accountNumber + " Balance: " + sa.balance + " Rate: " + sa.interestRate + "%");
        System.out.println("Checking Account " + ca.accountNumber + " Balance: " + ca.balance + " Overdraft Limit: " + ca.overdraftLimit);
        System.out.println("Bank: " + sbi.bankName + ", Branch: " + sbi.branch);
        System.out.println("Bank: " + hnb.bankName + ", Branch: " + hnb.branch);
        System.out.println("Bank: " + boc.bankName + ", Branch: " + boc.branch);
    }
}
