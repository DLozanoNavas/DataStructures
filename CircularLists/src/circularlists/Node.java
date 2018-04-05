/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package circularlists;

/**
 *
 * @author dlozanonavas
 */
public class Node {
    int data;
    Node next;
    
    public Node(int data){
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node Sig) {
        this.next = Sig;
    }
    
    public void PrintNode(){
        System.out.println(this.data);
    }
    
}
