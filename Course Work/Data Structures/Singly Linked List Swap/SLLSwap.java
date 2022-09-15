
/**
 * 	Assignment1, Question 2 a) COMP272
 * Class: SLLSwap.java
 * Purpose: To swap two nodes in a singly linked list
 * by adjusting their links.
 * 
 * @author Braiden Little
 * Student ID: 3364064
 * Date: January 16 2019
 * Version 1.0
 * 
 * Based on: Open Data Structures (in Java) By Pat Morin
 */
public class SLLSwap {
	/**
	 * Used to make additional nodes for the list.
	 */
	static class Node {
		int x; //Data stored in the node
		Node next; //Pointer to the next node
	}

	static Node head;// Front of the queue.
	
	static Node tail; // Back of the queue.
	
	static int n = 0; //Variable to track number of nodes in the list.
	
	/**
	 * Add a new node with the integer x to the end of the list.
	 * @param the number to be added to the new node as data.
	 */
	public static void add(int x) {
		Node u = new Node(); //Create new node to be added.
		u.x = x; //Add the data to the node
		if (n == 0) //If list is empty new node is the head of the list.
			head = u;
		else //Add the new node to the end of the list
			tail.next = u;
		tail = u; //New node is now the tail.
		n++; //Increase the number of nodes in the list	
	}
	
	/**
	 * Swaps a node with the next node in the list by adjusting their pointers.
	 * @param position Position of the node in the list to be swapped with the next node
	 * cannot be negative, outside the length of the list, or the tail of the list.
	 */
	public static void swapWithNext(int position) {
		if (position >= n || position < 0 || n <= 1) {
			System.out.println("Cannot swap with the next node as");
			System.out.print(" the position is at the end of the list");
			System.out.print(" ,beyond the list or there is not");
			System.out.print(" enough nodes in the list to swap.");
			return;
		}
		Node runner = new Node(); //Create a node to run through the list.
		Node temp1 = new Node(); //Node to save the first node to be swapped
		Node temp2 = new Node(); //Node to save the second node to be swapped
		Node temp3 = new Node();
		if (position == 1) {
			temp1.next = head.next; //Save the position of the node after head
			head.next = head.next.next;
			temp1.next.next = head; //Point the node at position 1 to the former head
			if (n == 2) { /*only two nodes in the list update the tail to point
								   to the old head */
				tail = head; 
			}
			head = temp1.next; //Update the head to the former position 1 node.
			temp1 = null;
			return;
		}
		/*
		 * Run through the list until we reach the node two nodes
		 * before the specified position. Then update the pointers
		 * to swap the node at the specified position
		 * with its next node.
		 */
		else {
			runner = head;
			for (int i = 0; i < position - 2; i++) {
				runner = runner.next;
			}
			temp1.next = runner;
			temp2.next = runner.next;
			temp3.next = runner.next.next;
			temp1.next.next = temp3.next; 
			if (position == n) { //New tail to the list update the tail pointer.
				tail = temp2.next;
				temp2.next.next = null;
			}
			else {
				temp2.next.next = temp3.next.next;
			}
			temp3.next.next = temp2.next;
			temp1 = null;
			temp2 = null;
			temp3 = null;
		}
		
	}
	
	/**
	 * Swaps a node with the previous node in the list by adjusting their pointers.
	 * @param position Position of the node in the list to be swapped with it's previous
	 * cannot be negative, outside the length of the list, or the head of the list.
	 */
	public static void swapWithPrev(int position) {
		if (position <= 0 || position > n || n <= 1) {
			System.out.println("Cannot swap with the previous node as");
			System.out.print(" the position is out of the lists range");
			System.out.print(", is the first node in the list ");
			System.out.print("or there is not enough nodes in the list to swap.");
			return;
		}
		Node runner = new Node(); //Create a node to run through the list.
		Node temp1 = new Node(); //Node to save the node two previous from the one to be swapped
		Node temp2 = new Node(); //Node to save the previous node to be swapped
		Node temp3 = new Node(); //Node to save the node at the position to be swapped
		if (position == 2) {
			temp1.next = head.next; //Save the position of the node after head
			head.next = head.next.next;
			temp1.next.next = head; //Point the node at position 1 to the former head
			if (position == n) { /*only two nodes in the list update the tail to point
								   to the old head */
				tail = head; 
			}
			head = temp1.next; //Update the head to the former position 1 node.
			temp1 = null;
		}
		/*
		 * Run through the list until we reach the node 
		 * before the specified position. Then update the pointers
		 * to swap the node at the specified position
		 * with its previous node.
		 */
		else if (position == n) { //the requested position is the tail of the list.
			runner = head;
			for (int i = 0; i < position - 2; i++) {
				runner = runner.next;
				}
			temp1.next = runner;
			temp2.next = runner.next;
			temp3.next = runner.next.next;
			temp1.next.next = temp3.next;
			temp2.next.next = temp3.next.next;
			temp3.next.next = temp2.next;
			tail = temp2.next; //The former previous node is now the tail.
			/* Delete the three
			   temporary nodes as
			   we are done with them*/
			temp1 = null;
			temp2 = null;
			temp3 = null;
		}
		/*
		 * Run through the list until we reach the node 
		 * before the specified position. Then update the pointers
		 * to swap the node at the specified position
		 * with its previous node.
		 */
		else {
			runner = head;
			for (int i = 0; i < position - 2; i++) {
				runner = runner.next;
				}
			temp1.next = runner;
			temp2.next = runner.next;
			temp3.next = runner.next.next;
			temp1.next.next = temp3.next;
			temp2.next.next = temp3.next.next;
			temp3.next.next = temp2.next;
			/* Delete the three
			   temporary nodes as
			   we are done with them*/
			temp1 = null;
			temp2 = null;
			temp3 = null;
		}
	}
	/**
	 * Method to print all the values in the list. 
	 */
	public static void printList() {
		if (n == 0) {
			System.out.println("The list is empty.");
			return;
		}
		Node runner = head;
		while (runner.next != null) {
			System.out.print("(" + runner.x + ")");
			runner = runner.next;
		}
		System.out.print("(" + runner.x + ")");
		System.out.println();
	}
}
