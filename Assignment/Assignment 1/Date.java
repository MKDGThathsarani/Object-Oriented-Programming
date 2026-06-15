class Date {
    // Constants for field types
    public static final int YEAR = 1;
    public static final int MONTH = 2;
    public static final int DAY = 3;
    
    // Private instance variables (encapsulation)
    private int year;
    private int month;
    private int day;
    
    // Default constructor
    public Date() {
        this.year = 1970;
        this.month = 1;
        this.day = 1;
    }
    
    // Parameterized constructor
    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }
    
    // Copy constructor
    public Date(Date other) {
        this.year = other.year;
        this.month = other.month;
        this.day = other.day;
    }
    
    // Static factory method - returns a Date instance with default values
    public static Date getDateInstance() {
        return new Date();  // Returns 1970-1-1
    }
    
    // Set method for specific field (using constants)
    public void set(int field, int value) {
        switch(field) {
            case YEAR:
                this.year = value;
                break;
            case MONTH:
                this.month = value;
                break;
            case DAY:
                this.day = value;
                break;
            default:
                System.out.println("Invalid field");
        }
    }
    
    // Set method that copies from another Date object
    public void set(Date other) {
        this.year = other.year;
        this.month = other.month;
        this.day = other.day;
    }
    
    // Print date in format: year-month-day
    public void printDate() {
        System.out.println(year + "-" + month + "-" + day);
    }
    
    // Getters (optional, for encapsulation)
    public int getYear() { return year; }
    public int getMonth() { return month; }
    public int getDay() { return day; }
    
    // Setters with validation (optional)
    public void setYear(int year) { this.year = year; }
    public void setMonth(int month) { this.month = month; }
    public void setDay(int day) { this.day = day; }
}
