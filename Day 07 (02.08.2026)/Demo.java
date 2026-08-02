class A{
	int a;
	A(){
		System.out.println("A()");
	}
	A(int i){
		System.out.println("A(int)");
	}
	A(int i, int j){
		System.out.println("A(int,int)");
	}
}
class B extends A{ 
	int b;
	B(){
		System.out.println("B()");
	}
	B(int i){
		System.out.println("B(int)");
	}
	B(int i, int j){
		System.out.println("B(int,int)");
	}
}
class Demo{
	public static void main(String args[]){
		B b1=new B();
		System.out.println("--------------");
		B b2=new B(100);
		System.out.println("--------------");
		B b3=new B(100,200);
	}
}
