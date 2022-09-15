
/**
 * 	Assignment1, Question 1 b) COMP272
 * Class: StackTwoQueues.java
 * Purpose: To implement the stack interface using
 * two queue interfaces containing singly linked lists.
 * 
 * @author Braiden Little
 * Student ID: 3364064
 * Date: January 16 2019
 * Version 1.0
 * 
 * Based on: Open Data Structures (in Java) By Pat Morin
 */
public class StackTwoQueues {
	/**
	 * Used to make additional nodes for the list.
	 */
	static class Node {
		int x; //Data stored in the node
		Node next; //Pointer to the next node
	}

	static int n = 0; //Variable to track number of nodes in the list.
	
	/**
	 * The first queue needed to implement the stack. 
	 */
	public static class q1 {
		static Node head;// Front of the queue.
		
		static Node tail; // Back of the queue.
		
		static int y; //Used to track the number of nodes in this queue.
		/*
		 * Remove the head of the node from the queue.
		 */
		public static int remove() {
			if (y == 0) { //List is empty.
				throw new IllegalArgumentException("Cannot delete from an empty list.");
			}
			int x = head.x; //The number to be deleted
			
			if (y == 1) { //Last node is both the tail and head.
				head = null; //Delete the head.
				tail = null; //Delete the tail.
				y--; //Decrement the number of nodes
				return x;
			}
			head = head.next; /*Set the head to the next node
								deleting the head. */
			y--;
			return x;
		}
		/*
		 * Add a new node with data, x to the end of the queue.
		 */
		public static void add(int x) {
			Node u = new Node();
			u.x = x;
			if (y == 0) {
				head = u;
			}
			else {
				tail.next = u;
			}
			tail = u;
			y++;
		}
		/*
		 * Method to determine if the queue is empty.
		 */
		public static boolean isEmpty() {
			if (y == 0) //list is empty.
				return true;
			else //list contains nodes.
				return false;
		}
		/*
		 * Method to print all the values in the list. 
		 */
		public static void printList() {
			if (y == 0) {
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
	/**
	 * The second queue needed to implement the stack. 
	 */
	public static class q2 {
		static Node head;// Front of the queue.
		
		static Node tail; // Back of the queue.
		
		static int y; //Used to track the number of nodes in this queue.
		   /*
			* Remove the head of the node from the queue.
		 	*/
		public static int remove() {
			if (y == 0) { //List is empty.
				throw new IllegalArgumentException("Cannot delete from an empty list.");
			}
			int x = head.x; //The number to be deleted
			
			if (y == 1) { //Last node is both the tail and head.
				head = null; //Delete the head.
				tail = null; //Delete the tail.
				y--; //Decrement the number of nodes
				return x;
			}
			head = head.next; /*Set the head to the next node
								deleting the head. */
			y--;
			return x;
		}
			/*
			 * Add a new node with data, x to the end of the queue.
			 */
		public static void add(int x) {
			Node u = new Node();
			u.x = x;
			if (y == 0) {
				head = u;
			}
			else {
				tail.next = u;
			}
			tail = u;
			y++;
		}
	/**
	 * Method to print all the values in the list. 
	 */
	public static void printList() {
		if (y == 0) {
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
	
	/**
	 * Push the new data x, to the top of the stack.
	 * If queue 1 is empty add to queue two, otherwise
	 * add to queue 1.
	 */
	public static void push(int x) {
		if (q1.isEmpty()) {
			q2.add(x);
			n++;
		}
		else {
			q1.add(x);
			n++;
		}	
	}
	
	/**
	 * Pop the most recent data from the top
	 * of the stack. If the first queue is 
	 * empty then move the nodes from queue
	 * 2 to queue 1 then remove and return 
	 * the last value store in queue 2.
	 * Otherwise move the nodes from queue
	 * 1 to queue 2 then remove and return 
	 * the last value store in queue 1.
	 */
	public static int pop() {
		if (q1.isEmpty()) {
			for (int i = 0; i < n - 1; i++) {
				q1.add(q2.remove());
			}
			n--;
			return q2.remove();
		}
		else {
			for (int i = 0; i < n - 1; i++) {
				q2.add(q1.remove());
			}
			n--;
			return q1.remove();
		}
	}
}
