/**
 * 	Assignment1, Question 5 COMP272
 * Class: Bag.java
 * Purpose: To implement a doubly linked list
 * that supports the reverse() method
 * which will reverse the order of elements in the list.
 * 
 * @author Braiden Little
 * Student ID: 3364064
 * Date: January 27 2019
 * Version 1.0
 * 
 * Based on: Open Data Structures (in Java) By Pat Morin
 */
public class DLLReverse {
	/**
	 * Used to make additional nodes for the list.
	 */
	static class Node {
		int x; //Data stored in the node
		Node next; //Pointer to the next node.
		Node prev; //Pointer to the previous node.
	}
	
	static int n; //Used to track the number of nodes in the list.
	
	protected static Node dummy = new Node(); //Dummy node pointer to each end of the list.
	protected static Node revDummy = new Node(); //Dummy for the reversed list
	
	/**
	 * The doubly linked list to be made
	 * Create a dummy node to point to 
	 * the front and end of the list
	 */
	public void DLList() {
		dummy = new Node();
		dummy.next = dummy;
		dummy.prev = dummy;
		n = 0;
	}	
	/**
	 * Add a new node containing x
	 * to the position before the specified node.
	 * @Param w place the new node previous to this one.
	 * @Param x data for the new node to be added
	 */
	public static Node addBefore(Node w, int x) {
		Node u = new Node();
		u.x = x;
		if (n == 0) {
			dummy.next = u;
			dummy.prev = u;
			u.next = dummy;
			u.prev = dummy;
			n++;
			return u;
		}
		u.prev = w.prev;
		u.next = w;
		u.next.prev = u;
		u.prev.next = u;
		n++;
		return u;
	}
	
	/**
	 * Remove the specified node
	 * @param w The node to be removed.
	 */
	public static void remove(Node w) {
		w.prev.next = w.next;
		w.next.prev = w.prev;
		n--;
	}
	
	static Node getNode(int i) {
        Node p = null;
        if (i < n / 2) { /*
        				  *The node is in the first half of the list
        				  *start at the front of the list and move
        				  *to the node at position i
        				  */
            p = dummy.next;
            for (int j = 0; j < i; j++)
                p = p.next;
        } 	/*
			*The node is in the back half of the list
			*start at the end of the list and move backwards
			*to the node at position i
			*/
        else { 
	            p = dummy;
            for (int j = n; j > i; j--)
                p = p.prev;
        }
        return p;
    }
	/*
	 * Return the size of the list.
	 */
	public static int size() {
		return n;
	}
	/**
	 * Add a node at the end of the list
	 * @param x Data for the new node
	 */
	public static void addAtEnd(int x) {
		addBefore(dummy, x);
	}
	/**
	 * Will take a list and reverse the list
	 * by removing each node in the original list
	 * backwards
	 * @param list The list to be reversed.
	 * @return The new reversed list.
	 */
	public static Node reverse(Node list) {
		if (n == 0) {
			throw new IllegalArgumentException("Cannot reverse an empty list.");
		}
		int y = n; //Used to temporarily remember the number of nodes.
		n = 0; //Set n to 0 to avoid errors while creating the new list.
		do {
			int x = dummy.prev.x;
			revAddBefore(revDummy, x); /* Add the last
													node of the previous
													list to the end of the
													new reversed list. */			
			remove(dummy.prev); //Remove the last node in the original list.
			n++; //Used to keep n from reaching 0 and creating issues in the new list.
		} while ( dummy.prev != dummy);
		n = y; //Set n back to it's original value.
		/*
		 * Adjust the new reversed lists pointers
		 * to point to dummy and have that be the new list.
		 */
		dummy = revDummy;
		revDummy.next.prev = dummy;
		revDummy.prev.next = dummy;
		return dummy;
	}
	/**
	 * Add a new node containing x
	 * to the position before the specified node.
	 * This should be used when reversing the list
	 * as the case for empty lists will use the
	 * revDummy node.
	 * @Param w place the new node previous to this one.
	 * @Param x data for the new node to be added
	 */
	public static Node revAddBefore(Node w, int x) {
		Node u = new Node();
		u.x = x;
		if (n == 0) {
			revDummy.next = u;
			revDummy.prev = u;
			u.next = revDummy;
			u.prev = revDummy;
			n++;
			return u;
		}
		u.prev = w.prev;
		u.next = w;
		u.next.prev = u;
		u.prev.next = u;
		n++;
		return u;
	}
	/**
	 * Run through the entire list 
	 * and print off the contents
	 * of each node.
	 */
	public static void printList() {
		if (n == 0) {
			System.out.println("List is empty cannot print.");
			return;
		}
		Node runner = dummy.next;
		System.out.println();
		while (runner != dummy) {
			System.out.print("{ " + runner.x + " } ");
			runner = runner.next;
		}
	}
	
}
