/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlistbasedqueue;

import java.util.NoSuchElementException;

/**
 *
 * @author dlozanonavas
 */
public class LinkedListBasedQueue {

    /**
     * Since in queue, we have to keep track of both the ends We need access to
     * both head and tail node
     */
    private Node head = null;
    private Node tail = null;
    int AttendedClients =0;


    /**
     * Method to insert a item in the queue
     *
     * @param customer
     * 
     */
    public void enqueue(Customer customer) {
        Node newNode = new Node(customer, null);
        
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
    }

    /**
     * Method to remove the item from the queue
     *
     * @return {@link object}
     */
    public Customer dequeue() {
        if (isEmpty()) {
            try{
            throw new NoSuchElementException("Cannot dequeue from empty Queue");
            }catch(NoSuchElementException e){
                e.getMessage();
            }
        }
        
        Customer customer = head.customer;
        if (tail == head) {
            tail = null;
        }
        head = head.next;
        
        AttendedClients++;
        return customer;
    }

    /**
     * Method to check the first item from the queue
     *
     * @return {@link object}
     */
    public Customer peek() {
        if (head == null) {
            try{
            throw new NoSuchElementException("Cannot peek from empty Queue");
            }catch(Exception e){
                e.getMessage();
            }
        }
        return head.customer;
    }

    /**
     * Method to check the size of the queue
     *
     * @return {@link int}
     */
    public int size() {
        int count = 0;
        for (Node node = head; node != null; node = node.next) {
            count++;
        }
        return count;
    }

    /**
     * Method to check if queue is empty
     *
     * @return {@link boolean}
     */
    public boolean isEmpty() {
        return head == null;
    }

    public void printList(LinkedListBasedQueue Queue) {
        for (Node node = head; node != null; node = node.next) {
            
        }
    }
    
    

    /**
     * Node class for LinkedList based queue
     *
     * @author dlozanonavas
     */
    class Node {

        /**
         * Item in the node
         */
        private Customer customer;

        /**
         * Pointer to next node
         */
        private Node next;

        /**
         * Constructor to create a new node
         *
         * @param item
         * @param next
         */
        public Node(Customer item, Node next) {
            this.customer = item;
            this.next = next;
        }

        public Customer getCustomer() {
            return customer;
        }

        public void setCustomer(Customer customer) {
            this.customer = customer;
        }

    }

}
