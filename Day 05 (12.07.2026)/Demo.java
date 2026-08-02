class Node{
    int data;
    Node next;
    Node(int data){this.data=data;}
}

class Demo{
    public static void main(String args[]){
        Node n1 = new Node(100);
        n1.next = new Node(200);
        n1.next.next = new Node(300);
        n1.next.next.next = new Node(400);
        n1.next.next.next.next = new Node(500);
        
        // Method 1: Using a separate reference variable
        System.out.print("[");
        Node current = n1;  // Use a different variable
        while(current != null){
            System.out.print(current.data);
            if(current.next != null) {
                System.out.print(", ");
            }
            current = current.next;
        }
        System.out.println("]");
        
        // Method 2: Using StringBuilder (better approach)
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node temp = n1;
        while(temp != null){
            sb.append(temp.data);
            if(temp.next != null) {
                sb.append(", ");
            }
            temp = temp.next;
        }
        sb.append("]");
        System.out.println(sb.toString());
    }
}
