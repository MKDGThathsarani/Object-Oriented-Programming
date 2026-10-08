package school;

public class Teacher {
    private String name;
    private String subject;
    
    public Teacher(String name, String subject) {
        this.name = name;
        this.subject = subject;
    }
    
    public void display() {
        System.out.println("Teacher: " + name + ", Subject: " + subject);
    }
}
