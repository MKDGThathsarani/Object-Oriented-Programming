import java.util.*;
class A{
	int a;
	A(int a){this.a=a;}
}
class Demo{
	public static A[] ar={new A(50),new A(90),new A(40),new A(60),new A(80),new A(30),new A(20)};
	
	public static void printArray(){
		System.out.print("[");
		for (int i = 0; i < ar.length; i++){
			System.out.print(ar[i].a+", ");
		}
		System.out.println("\b\b]");
	}
	public static void sort(){
		
	}
	public static void main(String args[]){
		printArray(); //[50, 90, 40, 60, 80, 30, 20]
		sort();
		printArray(); //[20, 30, 40, 50, 60, 80, 90]
	}	
}
