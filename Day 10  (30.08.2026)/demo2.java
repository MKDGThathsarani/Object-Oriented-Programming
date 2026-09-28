class MyClass{
	long[] ar=new long[100000];
	public void finalize(){
		System.out.println("Deleted...");
	}
}
class Demo{	
	public static void main(String args[]){
		System.out.println("Start main");
		MyClass[] cr=new MyClass[100000];
		
		for(int i=0; i<100000; i++){
			new MyClass();
			System.out.println("i : "+i);
		}
		System.out.println("End main");
	}	
}
