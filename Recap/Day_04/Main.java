// Method Overloading
class Calculator {
    public int add(int a, int b) {
        return a + b;
    }
    
    public double add(double a, double b) {
        return a + b;
    }
    
    public int add(int a, int b, int c) {
        return a + b + c;
    }
}

// Method Overriding
class Animal {
    public void sound() {
        System.out.println("Animal makes sound");
    }
}

class Dog extends Animal {
    @Override
    public void sound() {
        System.out.println("Dog barks");
    }
}

class Cat extends Animal {
    @Override
    public void sound() {
        System.out.println("Cat meows");
    }
}

public class Main {
    public static void main(String[] args) {
        // Overloading
        Calculator c = new Calculator();
        System.out.println(c.add(5, 3));
        System.out.println(c.add(5.5, 3.2));
        System.out.println(c.add(1, 2, 3));
        
        // Overriding + Dynamic Dispatch
        Animal a = new Dog();
        a.sound();  // Dog barks
        
        a = new Cat();
        a.sound();  // Cat meows
    }
}
