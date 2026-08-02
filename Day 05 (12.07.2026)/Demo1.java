class Node{
    int data;
    Node next;
    Node(int data){this.data=data;}
}

class Stack{
    private Node top;
    
    public void push(int data){
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
    }
    
    public void pop(){
        if (top != null){
            top = top.next;
        }
        else{
            System.out.println("Stack is empty!");
        }
    }
    
    public void printStack(){
        Node current = top;          
        System.out.print("[");
        while(current != null){
            System.out.print(current.data);
            if(current.next != null){ // 
                System.out.print(","); // 
            }
            current = current.next;
        }
        System.out.println("]");      // 
    }
}

class Demo1{
    public static void main(String args[]){
        Stack s1 = new Stack();
        s1.push(100);
        s1.push(200);
        s1.push(300);
        s1.push(400);
        s1.push(500);
        s1.printStack(); // [500, 400, 300, 200, 100]
        
        s1.pop();
        s1.printStack(); // [400, 300, 200, 100]
    }
}
