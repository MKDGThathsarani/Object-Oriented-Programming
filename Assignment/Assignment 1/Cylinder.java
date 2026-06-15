public class Cylinder {
    private double length;
    private double radius;
    
    // Default constructor
    public Cylinder() {
        length = 1.0;
        radius = 1.0;
    }
    
    // Parameterized constructor
    public Cylinder(double length, double radius) {
        setLength(length);
        setRadius(radius);
    }
    
    // Volume method
    public double calculateVolume() {
        return Math.PI * radius * radius * length;
    }
    
    // Area method
    public double calculateArea() {
        return (2 * Math.PI * radius * radius) + (2 * Math.PI * radius * length);
    }
    
    // Getters & Setters
    public double getLength() {
        return length;
    }
    
    public void setLength(double length) {
        if (length > 0) {
            this.length = length;
        } else {
            this.length = 1.0;
        }
    }
    
    public double getRadius() {
        return radius;
    }
    
    public void setRadius(double radius) {
        if (radius > 0) {
            this.radius = radius;
        } else {
            this.radius = 1.0;
        }
    }
    
    public void displayDetails() {
        System.out.println("Length: " + length);
        System.out.println("Radius: " + radius);
        System.out.printf("Volume: %.2f\n", calculateVolume());
        System.out.printf("Area: %.2f\n", calculateArea());
    }
}
