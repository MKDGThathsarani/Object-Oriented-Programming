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
    if(top == null){
        System.out.println("[empty]");
        return;
    }
    System.out.print("[");
    Node temp = top;
    while(temp != null){
        System.out.print(temp.data);
        if(temp.next != null){
            System.out.print(", ");
        }
        temp = temp.next;
    }
    System.out.println("]");
}
	
	public void clear(){
		top = null;
		}
		
	public int count(){
		int count = 0;
		Node temp = top;
		
		while(temp != null){
			count++;
			temp = temp.next;
			}
			
			return count;
		}
		
	public int size(){
		return count();
		}
		
	public boolean isEmpty(){
		return top == null;
		}
}
class Demo{
	public static void main(String args[]){
		Stack s1=new Stack();
		s1.printStack();//[empty]
		System.out.println("Size of the stack : "+s1.size()); //0
		System.out.println("Stack is empty    : "+s1.isEmpty());//true
		s1.push(100);
		s1.push(200);
		s1.push(300);
		s1.push(400);
		s1.push(500);
		s1.printStack(); //[500, 400, 300, 200, 100]
		System.out.println("Size of the stack : "+s1.size()); //5
		System.out.println("Stack is empty    : "+s1.isEmpty());//false
		
		s1.clear();
		s1.printStack();//[empty]
		System.out.println("Size of the stack : "+s1.size()); //0
		System.out.println("Stack is empty    : "+s1.isEmpty());//true
	}
}

