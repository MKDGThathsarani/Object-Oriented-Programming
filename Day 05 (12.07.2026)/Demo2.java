import java.util.*;
class Node{
	int data;
	Node next;
	Node(int data){this.data=data;}
}
class Stack{
	private Node top;
	public void push(int data){
		Node n1=new Node(data);
		n1.next=top;
		top=n1;
		
	}
	public void pop(){
		if(top!=null){
			top=top.next;
		}
	}
	public void printStack(){
		System.out.print("[");
		Node temp=top;
		while(temp!=null){
			System.out.print(temp.data+", ");
			temp=temp.next;
		}
		System.out.println(isEmpty() ?"empty]":"\b\b]");
	}
	public int size(){
		Node temp=top;
		int count=0;
		while(temp!=null){
			count++;
			temp=temp.next;
		}
		return count;
	}
	public boolean isEmpty(){
		return top==null;
	}
	public void clear(){
		top=null;
	}
	public int search(int data){
		Node temp=top;
		int index=0;
		while(temp!=null){
			if(temp.data==data){
				return index;
			}
			index++;
			temp=temp.next;
		}
		return -1;
	}
	public int[] toArray(){
		int[] tempDataArray=new int[size()];
		Node temp=top;
		for (int i = 0; i < tempDataArray.length; i++)	{
			tempDataArray[i]=temp.data;
			temp=temp.next;
		}
		return tempDataArray;
	}
}
class Demo2{
	public static void main(String args[]){
		Stack s1=new Stack();
		s1.push(100);
		s1.push(200);
		s1.push(300);
		s1.push(400);
		s1.push(500);
		s1.printStack(); //[500, 400, 300, 200, 100]
		
		int[] dataArray=s1.toArray();
		System.out.println(Arrays.toString(dataArray));//[500, 400, 300, 200, 100]
	}
}

