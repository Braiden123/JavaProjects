/**
 * 	Assignment1, Question 1 a) COMP272
 * Class: PriorityQueueSLL.java
 * Purpose: To implement the priority queue interface in a singly linked list, 
 * the add(x) method, and the deletMin() operations.
 * 
 * @author Braiden Little
 * Student ID: 3364064
 * Date: January 10 2019
 * Version 1.0
 * 
 * Based on: Open Data Structures (in Java) By Pat Morin
 */
public class PriorityQueueSLL {
	
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
	 * @param x The number to be added to the new node.
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
	 * Method will go through the list, finding the smallest value
	 * and record it, then go through the list again and deleting
	 * the smallest value when it is found again.
	 * @return The number that was deleted.
	 */
	public static int deleteMin() {
		if (n == 0) { //List is empty cannot delete from an empty list.
			System.out.println("List is empty cannot delete from an empty list.");
			return -1;
		}
		if (n == 1) { //List has 1 element delete the head of the list.
			int x = head.x;
			head = null;
			n--;
			return x;
		}
		Node runner = head; //Used to run through the list.
		int smallestFound = head.x; //First item is the smallest thus far.
		while (runner.next != null) { //Run through to the end of the list.
			if (runner.next.x < smallestFound) { /*Smaller number found, update
												 the smallest number found */	
				smallestFound = runner.next.x;
			}
			runner = runner.next; //Go to the next node in the list.
		}
		/*
		 * The head of the list is the smallest found delete the head
		of the list and update the new head to be the next in the list and return
		the smallestFound																				
		 */								
		if (head.x == smallestFound) { 
			head = head.next;
			n--;
			return smallestFound;
		}
		else {
			runner = head; //Start the runner at the beginning of the list.
			while (runner.next != null) {
				/*
				 * Smallest number in the list is found
				 * update the node pointer the node after
				 * the one containing the smallest number
				 * to delete it. Return smallest found.
				 */
				if (runner.next.x == smallestFound) {
					/*
					 * Smallest number is at the tail 
					 * update the tail to runners 
					 * position and set the old
					 * tail to null to delete.
					 */
					if (runner.next == tail) {
						tail = runner;
						runner.next = null;
						n--;
						return smallestFound;
					}
					runner.next = runner.next.next;
					n--;
					return smallestFound;
				}
				runner = runner.next;
			}
		}
		return smallestFound;
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
	}
	
	/**
	 * Return the number of elements in the list.
	 */
	public static int size() {
		return n;
	}
}
