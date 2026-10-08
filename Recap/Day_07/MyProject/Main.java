import school.Student;
import school.Teacher;
import bank.BankAccount;

public class Main {
    public static void main(String[] args) {
        Student s = new Student("Kamal", 22);
        s.display();
        
        Teacher t = new Teacher("Dr. Silva", "Maths");
        t.display();
        
        BankAccount acc = new BankAccount("ACC001", 10000);
        acc.display();
    }
}
