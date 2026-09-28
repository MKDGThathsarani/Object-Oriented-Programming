// Point.java - Class to represent coordinates
class Point {
    private double x, y;
    
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    public double getX() { return x; }
    public double getY() { return y; }
    public void setX(double x) { this.x = x; }
    public void setY(double y) { this.y = y; }
    
    @Override
    public String toString() { 
        return "(" + x + "," + y + ")"; 
    }
}

// Quadrilateral.java - Superclass
class Quadrilateral {
    private Point p1, p2, p3, p4;
    
    public Quadrilateral(Point p1, Point p2, Point p3, Point p4) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
    }
    
    public Point getP1() { return p1; }
    public Point getP2() { return p2; }
    public Point getP3() { return p3; }
    public Point getP4() { return p4; }
    
    public double area() { 
        return 0; // Not implemented for generic Quadrilateral
    }
    
    // Helper method to calculate distance between two points
    protected double distance(Point a, Point b) {
        return Math.sqrt(Math.pow(b.getX() - a.getX(), 2) + 
                        Math.pow(b.getY() - a.getY(), 2));
    }
}

// Trapezoid.java - Subclass of Quadrilateral
class Trapezoid extends Quadrilateral {
    public Trapezoid(Point p1, Point p2, Point p3, Point p4) { 
        super(p1, p2, p3, p4); 
    }
    
    @Override
    public double area() {
        // Area = (1/2) * (sum of parallel sides) * height
        // Assuming bases are p1-p2 and p4-p3 (parallel horizontal lines)
        double base1 = distance(getP1(), getP2());
        double base2 = distance(getP4(), getP3());
        double height = Math.abs(getP1().getY() - getP4().getY());
        return 0.5 * (base1 + base2) * height;
    }
}

// Parallelogram.java - Subclass of Quadrilateral
class Parallelogram extends Quadrilateral {
    public Parallelogram(Point p1, Point p2, Point p3, Point p4) { 
        super(p1, p2, p3, p4); 
    }
    
    @Override
    public double area() {
        // Area = base * height
        double base = distance(getP1(), getP2());
        double height = Math.abs(getP1().getY() - getP4().getY());
        return base * height;
    }
}

// Rectangle.java - Subclass of Parallelogram
class Rectangle extends Parallelogram {
    public Rectangle(Point p1, Point p2, Point p3, Point p4) { 
        super(p1, p2, p3, p4); 
    }
    
    @Override
    public double area() {
        double width = distance(getP1(), getP2());
        double height = distance(getP1(), getP4());
        return width * height;
    }
}

// Square.java - Subclass of Rectangle
class Square extends Rectangle {
    public Square(Point p1, Point p2, Point p3, Point p4) { 
        super(p1, p2, p3, p4); 
    }
    
    @Override
    public double area() {
        double side = distance(getP1(), getP2());
        return side * side;
    }
}

// Main.java - Public class with matching filename
public class Main {
    public static void main(String[] args) {
        System.out.println("=== Quadrilateral Area Calculator ===\n");
        
        // Create Trapezoid: Points (0,0), (4,0), (3,2), (1,2)
        Trapezoid t = new Trapezoid(
            new Point(0, 0), 
            new Point(4, 0), 
            new Point(3, 2), 
            new Point(1, 2)
        );
        System.out.println("Trapezoid Area: " + t.area());
        
        // Create Rectangle: Points (0,0), (4,0), (4,3), (0,3)
        Rectangle r = new Rectangle(
            new Point(0, 0), 
            new Point(4, 0), 
            new Point(4, 3), 
            new Point(0, 3)
        );
        System.out.println("Rectangle Area: " + r.area());
        
        // Create Square: Points (0,0), (2,0), (2,2), (0,2)
        Square s = new Square(
            new Point(0, 0), 
            new Point(2, 0), 
            new Point(2, 2), 
            new Point(0, 2)
        );
        System.out.println("Square Area: " + s.area());
        
        System.out.println("\n=== Demonstrating Polymorphism ===\n");
        // Array of Quadrilateral references
        Quadrilateral[] shapes = {t, r, s};
        for (Quadrilateral shape : shapes) {
            System.out.println(shape.getClass().getSimpleName() + 
                             " Area: " + shape.area());
        }
    }
}
