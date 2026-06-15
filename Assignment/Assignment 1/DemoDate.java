class DemoDate {
    public static void main(String args[]) {
        Date d1 = new Date();
        d1.set(Date.YEAR, 2016);
        d1.set(Date.MONTH, 5);
        d1.set(Date.DAY, 30);
        d1.printDate(); // 2016-5-30
        
        Date d2 = new Date(2016, 1, 31);
        d2.printDate(); // 2016-1-31
        
        Date d3 = new Date(d2);
        d3.printDate(); // 2016-1-31
        
        Date d4 = new Date();
        d4.set(d1);
        d4.printDate(); // 2016-5-30
        
        Date d5 = Date.getDateInstance();
        d5.printDate(); // 1970-1-1
    }
}
