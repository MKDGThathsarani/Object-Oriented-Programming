/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package link.list;

/**
 *
 * @author Thathsarani
 */
public class LinkList {
    LinkList next;
    Object data;
    
    LinkList(Object d){
        this.data = d;
        this.next = null;
    }
    
    LinkList(Object d, LinkList n){
        this.data = d;
        this.next = n;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
