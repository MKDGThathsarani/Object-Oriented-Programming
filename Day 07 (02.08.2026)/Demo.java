class A{
	int a;
	public void print(){
		System.out.println("print of A ");
	}
}
class B extends A{ 
	int b;
	public void print(){
		System.out.println("print of B ");
	}
}
class C extends B{ 
	int c;
	public void print(){
		System.out.println("print of C ");
	}
}
class D extends B{ 
	int d;
	public void print(){
		System.out.println("print of D ");
	}
}
class Demo{
	public static void main(String args[]){
		A a1=new A();
		A a2=new B();
		A a3=new C();
		A a4=new D();
		
		B b1=new B();
		B b2=new C();
		B b3=new D();
		
		C c1=new C();
		D d1=new D();
		
		a1.print(); //
		a2.print();	//
		a3.print();
		a4.print();
		b1.print();
		b2.print();
		b3.print();
		c1.print();
		d1.print(); 
		
		
	}
}
