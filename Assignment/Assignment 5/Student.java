// Student.java
class Student {
    int id;
    String name;
    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public void study() { System.out.println(name + " is studying."); }
    @Override
    public String toString() {
        return "Student ID: " + id + ", Name: " + name;
    }
}

// UndergraduateStudent.java
class UndergraduateStudent extends Student {
    int year;
    String major;
    public UndergraduateStudent(int id, String name, int year, String major) {
        super(id, name);
        this.year = year;
        this.major = major;
    }
    @Override
    public String toString() {
        return super.toString() + ", Year: " + year + ", Major: " + major;
    }
}

// GraduateStudent.java
class GraduateStudent extends Student {
    String advisor;
    String thesis;
    public GraduateStudent(int id, String name, String advisor, String thesis) {
        super(id, name);
        this.advisor = advisor;
        this.thesis = thesis;
    }
    @Override
    public String toString() {
        return super.toString() + ", Advisor: " + advisor + ", Thesis: " + thesis;
    }
}

// Freshman.java
class Freshman extends UndergraduateStudent {
    public Freshman(int id, String name, String major) {
        super(id, name, 1, major); // Year is always 1 for Freshman
    }
}

// Sophomore.java
class Sophomore extends UndergraduateStudent {
    public Sophomore(int id, String name, String major) {
        super(id, name, 2, major);
    }
}

// Junior.java
class Junior extends UndergraduateStudent {
    public Junior(int id, String name, String major) {
        super(id, name, 3, major);
    }
}

// Senior.java
class Senior extends UndergraduateStudent {
    public Senior(int id, String name, String major) {
        super(id, name, 4, major);
    }
}

// MastersStudent.java
class MastersStudent extends GraduateStudent {
    public MastersStudent(int id, String name, String advisor, String thesis) {
        super(id, name, advisor, thesis);
    }
}

// DoctoralStudent.java
class DoctoralStudent extends GraduateStudent {
    public DoctoralStudent(int id, String name, String advisor, String thesis) {
        super(id, name, advisor, thesis);
    }
}

// Main.java to test
public class Main {
    public static void main(String[] args) {
        Freshman f = new Freshman(101, "Kasun", "CS");
        Senior s = new Senior(102, "Nimal", "IT");
        MastersStudent m = new MastersStudent(103, "Amara", "Dr. Perera", "AI in Education");
        DoctoralStudent d = new DoctoralStudent(104, "Saman", "Prof. Silva", "Quantum Computing");
        System.out.println(f);
        System.out.println(s);
        System.out.println(m);
        System.out.println(d);
    }
}
