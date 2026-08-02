class Stack{
	private int[] dataArray;
	private int nextIndex;
	private double loadFact;
	private int initSize;
	
	Stack(int initSize, double loadFact){
		dataArray=new int[initSize];
		nextIndex=0;
		this.loadFact=loadFact;
		this.initSize=initSize;
	}
	private void extendsArray(){
		int tempDataArray[]=new int[dataArray.length+(int)(loadFact*dataArray.length)];
		for (int i = 0; i < dataArray.length; i++){
			tempDataArray[i]=dataArray[i];
		}
		dataArray=tempDataArray; 
	}
	private boolean isFull(){
		return nextIndex>=dataArray.length;
	}
	public void push(int data){
		if(isFull()){
			extendsArray();
		}
		dataArray[nextIndex++]=data;
	}
	public void trimToSize(){
		int[] tempDataArray=new int[size()];
		for (int i = 0; i < dataArray.length; i++){
			tempDataArray[i]=dataArray[i];
		}
		dataArray=tempDataArray;
	}
	public int size(){
		return nextIndex;
	}
	public void trim(){
		//
		//
	}
	public void clear(){
		dataArray=new int[initSize];
		nextIndex=0;
	}
	public void pop(){
		if(!isEmpty()){
			nextIndex--;
		}
	}
	public int search(int data){
		//Insert code here
		return -1;
	}
	public void display(){
		System.out.print("[");
		for (int i =nextIndex-1; i>=0 ; i--){
			System.out.print(dataArray[i]+", ");
		}
		System.out.println(isEmpty()? "empty]":"\b\b]");
	}
	public boolean isEmpty(){
		return nextIndex<=0;
	}
	public int capacity(){
		return dataArray.length;
	}
}
class Demo{
	public static void main(String args[]){
		Stack s1=new Stack(12,0.25);
		s1.push(10);
		s1.push(20);
		s1.push(30);
		s1.push(40);
		s1.push(50);
		s1.push(60);
		s1.push(70);
		s1.push(80);
		s1.push(90);
		s1.push(100);
		s1.push(110);
		s1.push(120);
		s1.display(); //[120,110,100,90...50,40,30,20,10]
		System.out.println("Size      : "+s1.size()); //12
		
		int topData;
		topData=s1.peek();
		System.out.println("Top Data : "+topData); //120
		System.out.println("After calling peek()...");
		s1.display(); //[120,110,100,90...50,40,30,20,10]
		
		topData=s1.poll();
		System.out.println("Top Data : "+topData); //120
		System.out.println("After calling poll()...");
		s1.display(); //[110,100,90...50,40,30,20,10]
		
	}
}
