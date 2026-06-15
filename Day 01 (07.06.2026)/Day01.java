class Day01{
	public static void main(String args[]){
	/*	int[] ar=new int[3];
		ar[0]=100;
		ar[1]=200;
		ar[2]=300;
		//-----------------
		System.out.println("ar[0] : "+ar[0]); //prints 100
		System.out.println("ar[1] : "+ar[1]);
		System.out.println("ar[2] : "+ar[2]);
		//-----------------------------------
		
		*/
		
		Students s1=new Students();
		s1.studentId="S0001";
		s1.name="Nimal";
		s1.prfMarks=85;
		s1.dbmsMarks=78;
		
		System.out.println("Student Id   : "+s1.studentId); //S001
		System.out.println("Student Name : "+s1.name); //Nimal
		System.out.println("PRF Marks    : "+s1.prfMarks);
		System.out.println("DBMS Marks   : "+s1.dbmsMarks);
	}
}
