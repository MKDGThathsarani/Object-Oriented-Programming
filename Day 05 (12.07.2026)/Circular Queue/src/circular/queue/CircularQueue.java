/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package circular.queue;

/**
 *
 * @author Thathsarani
 */
public class CircularQueue {
    int capacity;
    int front;
    int rear;
    
    int cqarr[];
    
    CircularQueue(int size){
        front = -1;
        rear = -1;
        capacity = size;
        
        cqarr = new int[capacity];
    }
    
    
    
    boolean isEmpty(){
        if(front == -1){
            return true;
        }else{
            return false;
        }
    }
    
    
    
    boolean isFull(){
        if (front == 0 && rear == capacity -1){
            return true;
        }
        else if(front == rear + 1){
            return true;
        }
        else{
            return false;
        }
    }
    
    
    ///////////////enqueue///////////////
    public void enqueue(int element){
        if(isFull()){
            System.out.println("Queue is Full");
        }else{
            if (front == -1){
                front = 0;
            }
            rear = (rear + 1) % capacity;
            
            cqarr[rear] = element;
            
            System.out.println("Inserted : " + element);
        }
    }
    
    ///////////////dequeue///////////////
    public int dequeue(){
        int element =0;
        
        if(isEmpty()){
            System.out.println("Is Empty");
        }else{
            element = cqarr[front];
            if(front == rear){
                front = -1;
                rear = -1;
            }else{
                front = (front + 1)% capacity;
            }
            System.out.println("Deleteed : " + element);
            }
            return element;
    
        }
    
    public void display(){
        int i;
        if(isEmpty()){
            System.out.println("Queue is Empty");
        }
        else{
            System.out.println("Que Element");
            
            for (i = front; i != rear; i = (i+1)%capacity){
                System.out.print(cqarr[i] + " ");
            }
            System.out.print(cqarr[i]);
        }
    }
    
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CircularQueue q1 = new CircularQueue(5);

        q1.enqueue(10);
        q1.enqueue(10);
        q1.enqueue(10);
        q1.enqueue(10);
        q1.enqueue(10);
        q1.enqueue(10);

        q1.display();
        
        q1.dequeue();
        q1.dequeue();
        q1.dequeue();

        
    }
    
}
