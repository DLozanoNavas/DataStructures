/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dlcircularlist;

/**
 *
 * @author dlozanonavas
 */
public class DoublyLinkedCircularList {

    private Node cursor;
    private int size = 0;


    public DoublyLinkedCircularList() {
        cursor = null;
        size = 0;
    }


    public void add(Node tmp) {
        if (size == 0) 
        {
            cursor = tmp;
            tmp.setNext(cursor);	           
            tmp.setPrevious(cursor);          
        }

        if (size == 1) 
        {
            cursor.setNext(tmp);       
            cursor.setPrevious(tmp);     
            tmp.setNext(cursor);            
            tmp.setPrevious(cursor);         
            cursor = tmp;
        } else 
        {
            tmp.setNext(cursor.getNext());     
            tmp.setPrevious(cursor);            
            cursor.getNext().setPrevious(tmp);  
            cursor.setNext(tmp);                
            cursor = tmp;
        }
        size++;
    }


    public Node remove() {
        if (size == 1) 
        {
            cursor.setNext(null);                        
            cursor.setPrevious(null);                     
            size--;								
            return cursor;                                 
        } else 
        {
            cursor.getNext().setPrevious(cursor.getPrevious()); 
            cursor.getPrevious().setNext(cursor.getNext());     
            size--;                                             
            return cursor;                                      
        }
    }


    public Node search(int data) {
        for (int i = 0; i < size; i++) {
            if (cursor.getData() == data) 
            {
                return cursor;                   
            } else {
                cursor = cursor.getNext();       
            }
        }
        return null;                          
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Node setCursor(Node current) {
        cursor = current.getNext();
        return current;
    }

    public String toString() {
        String list = "";

        for (int i = 0; i < size; i++) {
            list += cursor.toString() + "\n";
            cursor = cursor.getNext();
        }
        return list;
    }
}

class Node {


    private int data;
    private Node next;
    private Node previous;

    public Node(int d) {
        data = d;
    }


    public int getData() {
        return data;
    }


    public void setData(int newData) {
        data = newData;
    }


    public Node getNext() {
        return next;
    }


    public void setNext(Node newNext) {
        next = newNext;
    }


    public Node getPrevious() {
        return previous;
    }


    public void setPrevious(Node newPrevious) {
        previous = newPrevious;
    }

    public String toString() {
        return Integer.toString(getData());
    }
}

