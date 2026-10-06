// ==========================================
// 1. Interface - Animal
// ==========================================
interface Animal {
    void sound();       // හඬන්න පුළුවන්
}

// ==========================================
// 2. Interface - Swimmable
// ==========================================
interface Swimmable {
    void swim();        // පිහිනන්න පුළුවන්
}

// ==========================================
// 3. Interface - Flyable
// ==========================================
interface Flyable {
    void fly();         // ඉගිල්ලෙන්න පුළුවන්
}

// ==========================================
// 4. Dog - Animal විතරයි
// ==========================================
class Dog implements Animal {
    @Override
    public void sound() {
        System.out.println("Bark! 🐕");
    }
}

// ==========================================
// 5. Cat - Animal විතරයි
// ==========================================
class Cat implements Animal {
    @Override
    public void sound() {
        System.out.println("Meow! 🐈");
    }
}

// ==========================================
// 6. Fish - Animal + Swimmable
// ==========================================
class Fish implements Animal, Swimmable {
    @Override
    public void sound() {
        System.out.println("Blub! 🐟");
    }
    
    @Override
    public void swim() {
        System.out.println("Fish swimming 💧");
    }
}

// ==========================================
// 7. Duck - හැම එකක්ම! (Animal + Swimmable + Flyable)
// ==========================================
class Duck implements Animal, Swimmable, Flyable {
    @Override
    public void sound() {
        System.out.println("Quack! 🦆");
    }
    
    @Override
    public void swim() {
        System.out.println("Duck swimming 💧");
    }
    
    @Override
    public void fly() {
        System.out.println("Duck flying ✈️");
    }
}

// ==========================================
// 8. Main Class
// ==========================================
public class Main {
    public static void main(String[] args) {
        
        System.out.println("=== 1. Dog ===");
        Animal a1 = new Dog();
        a1.sound();                     // ✅ Bark! 🐕
        // a1.swim();                   // ❌ Dog ට swim() නැහැ
        
        System.out.println("\n=== 2. Cat ===");
        Animal a2 = new Cat();
        a2.sound();                     // ✅ Meow! 🐈
        
        System.out.println("\n=== 3. Fish ===");
        Animal a3 = new Fish();
        a3.sound();                     // ✅ Blub! 🐟
        ((Swimmable)a3).swim();         // ✅ Cast කරලා swim()
        
        System.out.println("\n=== 4. Duck ===");
        Animal a4 = new Duck();
        a4.sound();                     // ✅ Quack! 🦆
        ((Swimmable)a4).swim();         // ✅ Cast කරලා swim()
        ((Flyable)a4).fly();            // ✅ Cast කරලා fly()
        
        System.out.println("\n=== 5. Duck - හැම reference එකකින්ම ===");
        Duck d = new Duck();            // ← Duck reference
        d.sound();                      // ✅
        d.swim();                       // ✅
        d.fly();                        // ✅ (Cast ඕන නැහැ!)
    }
}
