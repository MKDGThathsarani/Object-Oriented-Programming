/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package array;

/**
 *
 * @author Thathsarani
 */
import java.util.Scanner;
public class Array {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int[] arr = new int[10];
        int size = 5;
        
        System.out.print("Enter array size: ");
        for (int j = 0; j <= size; j++) {
            arr[j] = scanner.nextInt();
        }
        
        System.out.println("You entered:");
        for (int i = 0; i <= size; i++) {
            System.out.println(arr[i]);
        }
        
        
        //System.out.print("Enter the index: ");
        //int ind = scanner.nextInt();
        
        //System.out.print("Enter the Element: ");
        //int ele = scanner.nextInt();
            
        //size++;
        
        //for (int k=size; k>=size; k--){
        //arr[k] = arr[k-1];
        //}
        
        //arr[ind] = ele;
        
        //for (int i = 0; i < size; i++) {
            //System.out.println(arr[i]);
        //}
        
        //System.out.print("Enter the delet of index: ");
        //int in = scanner.nextInt(); 
        
        //for(int j=in; j<size; j++){
            //arr[j]=arr[j+1];
        //}
        
        //size --;

        //for (int i = 0; i < size; i++) {
            //System.out.println(arr[i]);
        //}
        
        System.out.print("Enter the search element: ");
        int ser = scanner.nextInt();
        
        int j;
        for( j=0; j<size; j++){
            if(arr[j] == ser){
                break;
            }
            
        }
        System.out.print(j);
        
        
        scanner.close();
    }
        // TODO code application logic here
    }
    

