// Point.java
class Point {
    private double x, y;
    public Point(double x, double y) { this.x = x; this.y = y; }
    public double getX() { return x; }
    public double getY() { return y; }
    public void setX(double x) { this.x = x; }
    public void setY(double y) { this.y = y; }
    @Override
    public String toString() { return "(" + x + "," + y + ")"; }
}

// Quadrilateral.java
class Quadrilateral {
    private Point p1, p2, p3, p4;
    public Quadrilateral(Point p1, Point p2, Point p3, Point p4) {
        this.p1 = p1; this.p2 = p2; this.p3 = p3; this.p4 = p4;
    }
    public Point getP1() { return p1; }
    public Point getP2() { return p2; }
    public Point getP3() { return p3; }
    public Point getP4() { return p4; }
    public double area() { return 0; } // Not implemented for generic Quadrilateral
}

// Trapezoid.java
class Trapezoid extends Quadrilateral {
    public Trapezoid(Point p1, Point p2, Point p3, Point p4) { super(p1, p2, p3, p4); }
    @Override
    public double area() {
        // Area = (1/2) * (sum of parallel sides) * height
        // Simplified: assuming bases are p1-p2 and p4-p3
        double base1 = distance(getP1(), getP2());
        double base2 = distance(getP4(), getP3());
        double height = Math.abs(getP1().getY() - getP4().getY()); // Assuming horizontal bases
        return 0.5 * (base1 + base2) * height;
    }
    private double distance(Point a, Point b) {
        return Math.sqrt(Math.pow(b.getX() - a.getX(), 2) + Math.pow(b.getY() - a.getY(), 2));
    }
}

// Parallelogram.java
class Parallelogram extends Quadrilateral {
    public Parallelogram(Point p1, Point p2, Point p3, Point p4) { super(p1, p2, p3, p4); }
    @Override
    public double area() {
        // Area = base * height
        double base = distance(getP1(), getP2());
        double height = Math.abs(getP1().getY() - getP4().getY()); // Assuming horizontal base
        return base * height;
    }
    private double distance(Point a, Point b) {
        return Math.sqrt(Math.pow(b.getX() - a.getX(), 2) + Math.pow(b.getY() - a.getY(), 2));
    }
}

// Rectangle.java
class Rectangle extends Parallelogram {
    public Rectangle(Point p1, Point p2, Point p3, Point p4) { super(p1, p2, p3, p4); }
    @Override
    public double area() {
        return distance(getP1(), getP2()) * distance(getP1(), getP4());
    }
    private double distance(Point a, Point b) {
        return Math.sqrt(Math.pow(b.getX() - a.getX(), 2) + Math.pow(b.getY() - a.getY(), 2));
    }
}

// Square.java
class Square extends Rectangle {
    public Square(Point p1, Point p2, Point p3, Point p4) { super(p1, p2, p3, p4); }
    @Override
    public double area() {
        double side = distance(getP1(), getP2());
        return side * side;
    }
    private double distance(Point a, Point b) {
        return Math.sqrt(Math.pow(b.getX() - a.getX(), 2) + Math.pow(b.getY() - a.getY(), 2));
    }
}

// Main.java to test
public class Main {
    public static void main(String[] args) {
        // Create points for a Trapezoid, Rectangle, Square etc.
        Trapezoid t = new Trapezoid(new Point(0,0), new Point(4,0), new Point(3,2), new Point(1,2));
        Rectangle r = new Rectangle(new Point(0,0), new Point(4,0), new Point(4,3), new Point(0,3));
        Square s = new Square(new Point(0,0), new Point(2,0), new Point(2,2), new Point(0,2));

        System.out.println("Trapezoid Area: " + t.area());
        System.out.println("Rectangle Area: " + r.area());
        System.out.println("Square Area: " + s.area());
    }
}
