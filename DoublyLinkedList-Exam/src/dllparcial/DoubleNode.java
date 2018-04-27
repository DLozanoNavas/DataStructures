/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dllparcial;

/**
 *
 * @author dlozanonavas
 */

class DoubleNode {
	protected Car data;
	protected DoubleNode next, prev;

	// Constructor
	public DoubleNode(Car C) {
		next = null;
		prev = null;
		data = C;
	}

	// Declarative constructor
	public DoubleNode(Car d, DoubleNode p, DoubleNode n) {
		data = d;
		next = n;
		prev = p;
	}

	// Function to set link to next node

	public void setLinkNext(DoubleNode n) {
		next = n;
	}

	// Function to set link to previous node

	public void setLinkPrev(DoubleNode p) {
		prev = p;
	}

	// Funtion to get link to next node

	public DoubleNode getLinkNext() {
		return next;
	}

	// Function to get link to previous node 

	public DoubleNode getLinkPrev() {
		return prev;
	}

	// Function to set data to node 

	public void setData(Car d) {
		data = d;
	}

	// Function to get data from node
	public Car getData() {
		return data;
	}

}
