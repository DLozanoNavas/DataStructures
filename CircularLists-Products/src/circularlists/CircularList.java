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
public class CircularList{

    public int size = 0;
    public Node head = null;
    public Node tail = null;

    //add a new node at the start of the linked list
    public void addNodeAtStart(int data) {
        System.out.println("Adding node " + data + " at start");
        Node n = new Node(data);
        if (size == 0) {
            head = n;
            tail = n;
            n.next = head;
        } else {
            Node temp = head;
            n.next = temp;
            head = n;
            tail.next = head;
        }
        size++;
    }

    public void addNodeAtEnd(int data) {
        if (size == 0) {
            addNodeAtStart(data);
        } else {
            Node n = new Node(data);
            tail.next = n;
            tail = n;
            tail.next = head;
            size++;
        }
        System.out.println("\nNode " + data + " is added at the end of the list");
    }

    public void deleteNodeFromStart() {
        if (size == 0) {
            System.out.println("\nList is Empty");
        } else {
            System.out.println("\ndeleting node " + head.data + " from start");
            head = head.next;
            tail.next = head;
            size--;
        }
    }

    public int elementAt(int index) {
        if (index > size) {
            return -1;
        }
        Node n = head;
        while (index - 1 != 0) {
            n = n.next;
            index--;
        }
        return n.data;
    }

    //print the linked list
    public void print() {
        System.out.print("Circular Linked List:");
        Node temp = head;
        if (size <= 0) {
            System.out.print("List is empty");
        } else {
            do {
                System.out.print(" " + temp.data);
                temp = temp.next;
            } while (temp != head);
        }
        System.out.println();
    }

    //get Size
    public int getSize() {
        return size;
    }



}
