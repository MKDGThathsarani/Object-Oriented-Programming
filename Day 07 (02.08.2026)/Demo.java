class A{
	int a;
	public void printA(){
		System.out.println("print a : "+a);
	}
}
class B extend A{ 
	int b;
	public void printB(){
		System.out.println("print b : "+b);
	}
	public void printAB(){
		System.out.println("print a : "+a);
		System.out.println("print b : "+b);
	}
	public void callPrints(){
		printA();
		printB();
	}
}
