/**
 * 	Assignment1, Question 2 b) COMP272
 * Class: DLLSwap.java
 * Purpose: To swap two nodes in a doubly linked list
 * by adjusting their links.
 * 
 * @author Braiden Little
 * Student ID: 3364064
 * Date: January 21 2019
 * Version 1.0
 * 
 * Based on: Open Data Structures (in Java) By Pat Morin
 */
public class DLLSwap {
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
	public void remove(Node w) {
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
	/**
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
	 * Swaps the nodes position
	 * with the it's previous node.
	 * @param w the node to be
	 * swapped.
	 */
	public static void swapPrev(Node w) {
		w.next.prev = w.prev;
		w.prev.prev.next = w.prev.prev.next.next;
		w.prev.next = w.next;
		w.next = w.prev;
		w.prev = w.prev.prev;
		w.next.prev = w.next.prev.next;
	}
	/**
	 * Swaps the nodes position
	 * with the it's next node.
	 * @param w the node to be
	 * swapped.
	 */
	public static void swapNext(Node w) {
		w.next.prev = w.prev;
		w.next = w.next.next;
		w.prev.next = w.prev.next.next.prev;
		w.next.prev.next = w;
		w.next.prev = w.next.prev.next;
		w.prev = w.prev.next;
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
