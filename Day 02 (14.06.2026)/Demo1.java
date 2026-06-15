class Date{
	private static int year;
	private static int month;
	private static int day; //day of month
	
	public void setDate(int year, int month, int day){
		this.year=year;
		this.month=month;
		this.day=day;
	}
	public void printDate(){
		System.out.println(year+"-"+month+"-"+day);	
	}
}
class Demo1{
	public static void main(String args[]){
		Date d1=new Date();
		d1.setDate(2026,6,7);
		
		Date d2=new Date();
		d2.setDate(1999,12,31);
		
		Date d3=new Date();
		d3.setDate(2025,12,8);
		
		d1.printDate();
		d2.printDate();
		d3.printDate();
	}
}

