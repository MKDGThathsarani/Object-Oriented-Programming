class Box {
    private int length;
    private int width;
    private int height;
    
    // Default constructor
    public Box() {
        this.length = 0;
        this.width = 0;
        this.height = 0;
    }
    
    // Parameterized constructor (length, width, height)
    public Box(int length, int width, int height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }
    
    // Constructor for square cube (same length for all dimensions)
    public Box(int side) {
        this.length = side;
        this.width = side;
        this.height = side;
    }
    
    // Copy constructor
    public Box(Box other) {
        this.length = other.length;
        this.width = other.width;
        this.height = other.height;
    }
    
    // Setters for individual dimensions
    public void setLength(int length) {
        this.length = length;
    }
    
    public void setWidth(int width) {
        this.width = width;
    }
    
    public void setHeight(int height) {
        this.height = height;
    }
    
    // Set all three dimensions at once
    public void setDimension(int length, int width, int height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }
    
    // Set dimension for square cube (all sides same)
    public void setDimension(int side) {
        this.length = side;
        this.width = side;
        this.height = side;
    }
    
    // Copy dimensions from another Box object
    public void setDimension(Box other) {
        this.length = other.length;
        this.width = other.width;
        this.height = other.height;
    }
    
    // Calculate volume
    public int getVolume() {
        return length * width * height;
    }
    
    // Print volume
    public void printVolume() {
        System.out.println("Volume : " + getVolume());
    }
    
    // Return a copy of the current Box object
    public Box getCopy() {
        return new Box(this);
    }
}

// Demo class
class Demo {
    public static void main(String args[]) {
        Box b1 = new Box();
        b1.setLength(12);
        b1.setWidth(5);
        b1.setHeight(3);
        b1.printVolume();  // Volume : 180
        
        b1.setDimension(120, 50, 30);
        System.out.println("Volume " + b1.getVolume());  // Volume 180000
        
        Box b2 = new Box(4, 2, 3);
        b2.printVolume();  // Volume : 24
        
        Box b3 = new Box(b2);  // copy dimensions of b2 into b3
        b3.printVolume();  // Volume : 24
        
        Box b4 = new Box(10);  // length for a square cube
        b4.printVolume();  // Volume : 1000
        
        Box b5 = new Box();
        b5.setDimension(12);  // length for a square cube
        b5.printVolume();  // Volume : 1728
        
        Box b6 = new Box();
        b6.printVolume();  // Volume : 0
        b6.setDimension(b1);  // copy dimensions of b1 into b6
        b6.printVolume();  // Volume : 180000
        
        Box b7 = b3.getCopy();
        b7.printVolume();  // Volume : 24
    }
}
