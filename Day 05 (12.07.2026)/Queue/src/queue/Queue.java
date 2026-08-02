/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package queue;

/**
 *
 * @author Thathsarani
 */
public class Queue {
    int front;
    int rear;
    int capacity;
    int item;
    
    int queuearr[];
    
    Queue(int size){
        capacity = size;
        front = 0;
        rear = -1;
        
        queuearr = new int[size];
    }
    
    /////////////EnQueue//////////////
    boolean isFull(){
        return rear+1 == capacity;
    }
    
    public void enQueue(int x){
        if(isFull()){
            System.out.println("Queue is Full ");
        }else{
            rear ++;
            queuearr[rear] = x;
            System.out.println("Inserting " + x);
        }
    }
    
    ///////////DeQueue//////////////////////
    boolean isEmpty(){
        return front > rear;
    }
    
    public void deQueue(){
        if(isEmpty()){
        System.out.println("The Queue is empty");
        }else{
            System.out.println("Removing" + queuearr[front]);
            front++;
        }
    }
    
    public void print(){
        for (int i = front; i<=rear; i++){
            System.out.println(queuearr[i] + ' ');
        }
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Queue myQueue = new Queue(5);
        
        myQueue.enQueue(10);
        myQueue.enQueue(20);
        myQueue.enQueue(30);
        myQueue.enQueue(40);
        myQueue.enQueue(50);
        
        
        myQueue.deQueue();
        myQueue.deQueue();
        
        myQueue.print();
        
    }
    
}
