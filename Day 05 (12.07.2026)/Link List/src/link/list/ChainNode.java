/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package link.list;

/**
 *
 * @author Thathsarani
 */
public class ChainNode {
    int size;
    ChainNode head;
    
    java(){
        this.size = 0;
        this.head = null;
    }
    
    //is Empty
    public boolean isEmpty(){
        return head == null;
    }
    
    //size
    public int size(){
        return size;
    }
    
    //add first
    public void addFirst(Object elt){
        if(isEmpty()){
           head = new LinkList(elt);
        }else{
           head = new LinkList(elt,head);
        }
    }
    
    //add last
    public void addLast(Object elt){
        if (isEmpty()){
            head = new LinkList(elt);
        }else{
            LinkList temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = new LinkList(elt);
        }
        size++;
    }
    
    //Remove First
    public Object removeFirst(){
        Object rmdata = null;
        if(isEmpty()){
            System.out.println("List is empty");
        }else{
            rmdata = head.data;
            head = head.next;
            size--;
        }
        return rmdata;
    }
    
    //Remove Last
    public Object removeLast(){
        Object rmdata = null;
        if (isEmpty()){
            System.out.println("List is empty");
        }
        else{
            if (size == 1){
                rmdata = head.data;
                head = null;
            }
            else{
                LinkList temp = head;
                while (temp.next.next != null){
                    temp = temp.next;
                } 
                rmdata = temp.next.data;
                temp.next = null;
            }
            size--;
        }
        return rmdata;
    }
    
    //insert node
    public void insertNode(int index, Object elt){
    if(index == 0 && index <= size){
        if (index == 0 && size == 0){
            head == new LinkList(elt);
            size++;
        }
        else if(index == 0 && size>0){
            head = new LinkList(elt,head);
            size ++;
        }
        
        else if(index == size);
            LinkList temp = head;
            for(int i=0; i<size; i++){
                temp = temp.next;
            }
            temp.next = new LinkList(elt);
            size++;
        else{
            LinkList temp = head;
            for(int i=0; i<index; i++){
                temp = temp.next;
            }
           temp.next = new ChainNode(elt,temp.next);
           size++;
        }
    }
    else{
        System.out.println ("Invalid Index");
    }
    }
    
    //remove node
    public Object remoNode(int index){
        Object rmdata = null;
        
        if (index == 0){
            rmdata = head.data;
            head = head.next;
            size--;
        }
        else if(index < size-1){
            LinkList temp = head;
            for (int i=0; i<index-1; i++){
                temp = temp.next;
            }
            rmdata = temp.next.data;
            temp.next = temp.next.next;
            size--;
        }
        else id(index == size-1){
        if (size == 1){
            rmdata = head.data;
            head = null;
        }
        else{
            LinkList temp = hhead;
            while(temp.next.next != null){
                temp = temp.next;
            }
            rmdata = temp.next.data;
            temp.next = null;
        }
        size--;
        }
        return rmdata;
    }
    
    public void display(){
        if(isEmpty()){
            System.out.println("Link list is empty")
        }
        else{
            LinkList temp = head;
            while(temp!=null){
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println("\n");
        }
    }
    
    public static void main(String arg []){
        ChainNode L1 = new ChainNode();
        
        L1.addFirst(10);
        L1.addFirst(20);
        L1.addFirst(30);
        
        L1.addLast(40);
        L1.addLast(50);
        
        L1.display();
        
        L1.removeFirst();
        L1.display();
        
        L1.removeLast();
        L1.display();
        
        L1.remoNode(2);
        L1.display();
    }
}
    

