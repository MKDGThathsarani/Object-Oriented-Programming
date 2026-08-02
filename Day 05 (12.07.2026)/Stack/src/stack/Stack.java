/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package stack;

/**
 *
 * @author Thathsarani
 */

public class Stack {
    int arr[];
    int top;
    int capacity;
    
    //Constructer Method/class
    Stack(int size){
        arr = new int[size];
        capacity = size;
        top = -1;
    }
    /**
     * @param args the command line arguments
     */
    
    ///////////////push////////////
    //check the full
    public boolean isFull(){
        return top+1 == capacity;
    }
    
    //push element
    public void push(int x){
        if(isFull()){
            System.out.println("Full");
        }else{
            top++;
            arr[top] = x;
            System.out.println("Pushed " + x);
        }
    }
    
    ///////////////pop////////////
    
    //Check the empty
    public boolean isEmpty(){
        return top == -1;
        }
    
    //pop element
    public void pop(){
        if(isEmpty()){
            System.out.println("Empty");
        }else{
            System.out.println("Removing" + arr[top]);
            top--;
        }
    }
    
    ////////print the stack////////////////////////
    public void printStack(){
        System.out.println("Print the stack: ");
        for(int i=0; i<=top; i++){
        System.out.println(arr[i]);
        }
    }
    
    
    //////////Size/////////////////////////
    public void size(){
        System.out.println(top+1);
    }
    
    
    public static void main(String[] args) {
        Stack mystack = new Stack(5);
        
        mystack.push(10);
        mystack.push(20);
        mystack.push(30);
        mystack.push(40);
        mystack.push(50);
        mystack.pop();
        mystack.pop();
        mystack.pop();
        mystack.pop();
        
        mystack.printStack();
        mystack.size();
    } 
}
