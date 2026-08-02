import java.util.*;
class Node{
	int data;
	Node next;
	Node(int data){this.data=data;}
}
class Queue{
	private Node front;
	private Node rear;
	public void add(int data){
		Node n1=new Node(data);
		
		if (isEmpty()){
			front = n1;
			rear = n1;
			}else{
				rear.next = n1;
				rear = n1;
				}
	}
	public void remove(){
		if(front!=null){
			front=front.next;
		}
	}
	public void printQueue(){
		System.out.print("[");
		Node temp=front;
		while(temp!=null){
			System.out.print(temp.data+", ");
			temp=temp.next;
		}
		System.out.println(isEmpty() ?"empty]":"\b\b]");
	}

	public int size(){
		Node temp=front;
		int count=0;
		while(temp!=null){
			count++;
			temp=temp.next;
		}
		return count;
	}
	public boolean isEmpty(){
		return front==null;
	}
	public void clear(){
		front=null;
	}
	public int search(int data){
		Node temp=front;
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
		Node temp=front;
		for (int i = 0; i < tempDataArray.length; i++)	{
			tempDataArray[i]=temp.data;
			temp=temp.next;
		}
		return tempDataArray;
	}
}
class Demo3{
	public static void main(String args[]){
		Queue q1=new Queue();
		q1.add(100);
		q1.add(200);
		q1.add(300);
		q1.add(400);
		q1.add(500);
		q1.printQueue();//[100, 200, 300, 400, 500]
		
		q1.remove();
		q1.printQueue();//[200, 300, 400, 500]
	}
}

