/**
 * 	Assignment2, Question 1 COMP272
 * Class: OrderNumberBT.java
 * Purpose: To extend the BinaryTree.java class and add
 * methods to add the in-order, pre-order, and post-order
 * traversal positions to the node. 
 * 
 * @author Braiden Little
 * Student ID: 3364064
 * Date: March 7 2019
 * Version 1.0
 * 
 * Based on: Open Data Structures (in Java) By Pat Morin
 */
public class OrderNumberBT extends BinaryTree{
	
	/**
	 * Traverse through the tree in an in-order traversal
	 * and when arriving at a node for the first time,
	 * update it's field for it's position in a pre-order
	 * traversal of the tree.If the node has been visited
	 *  already do not update the field.
	 */
	public static void preOrderNumber() {
		Node u = r;
		Node prev = null;
		Node next;
		int position = 0;
		while (u != null) {
			if (prev == u.parent) {
				if (u.preOrderNumber == 0) { //Set u's position in a pre-order traversal if it has not been set.
					u.preOrderNumber = ++position;
				}
				if ( u.leftChild != null) {
					next = u.leftChild;
				}
				else if ( u.rightChild != null) {
					next = u.rightChild;
				}
				else {
					next = u.parent;
				}
			}
			else if (prev == u.leftChild) {
				if (u.rightChild != null) {
					next = u.rightChild;
				}
				else {
					next = u.parent;
				}
			}
			else {
				next = u.parent;
			}
			prev = u;
			u = next;
		}
	}
	
	/**
	 * Traverse through the tree in an in-order traversal
	 * and when arriving at a node from the left, u has no
	 * left child and is moving to the right, or u has no
	 * children whatsoever, update it's in-order traversal
	 * field. If the node has been visited already do not
	 * update the field.
	 */
	public static void inOrderNumber() {
		Node u = r;
		Node prev = null;
		Node next;
		int position = 0;
		while (u != null) {
			if (prev == u.parent) {
				if ( u.leftChild != null) {
					next = u.leftChild;
				}
				else if ( u.rightChild != null) {
					if (u.inOrderNumber == 0) { //No left child for the node, set the position of this node.
						u.inOrderNumber = ++position;
					}
					next = u.rightChild;
				}
				else {
					if (u.inOrderNumber == 0) { //No children for the node, set the position of this node.
						u.inOrderNumber = ++position;
					}
					next = u.parent;
				}
			}
			else if (prev == u.leftChild) {
				if (u.inOrderNumber == 0) { //Just visited left child, set position for u, before continuing traversal.
					u.inOrderNumber = ++position;
				}
				if (u.rightChild != null) {
					next = u.rightChild;
				}
				else {
					next = u.parent;
				}
			}
			else {
				next = u.parent;
			}
			prev = u;
			u = next;
		}
	}
	
	/**
	 * Traverse through the tree in an in-order traversal,
	 * when u has no children, has a left child but no right 
	 * child, or is moving towards it's parent, update the node's
	 * post-order traversal field. If the node has been visited 
	 * already do not update the field.
	 */
	public static void postOrderNumber() {
		Node u = r;
		Node prev = null;
		Node next;
		int position = 0;
		while (u != null) {
			if (prev == u.parent) {
				if ( u.leftChild != null) {
					next = u.leftChild;
				}
				else if ( u.rightChild != null) {
					next = u.rightChild;
				}
				else {
					if (u.postOrderNumber == 0) {
						u.postOrderNumber = ++position;
					}
					next = u.parent;
				}
			}
			else if (prev == u.leftChild) {
				if (u.rightChild != null) {
					next = u.rightChild;
				}
				else {
					if (u.postOrderNumber == 0) {
						u.postOrderNumber = ++position;
					}
					next = u.parent;
				}
			}
			else {
				if (u.postOrderNumber == 0) {
					u.postOrderNumber = ++position;
				}
				next = u.parent;
			}
			prev = u;
			u = next;
		}
	}
	/**
	 * Traverse the tree in an in-order traversal
	 * then set each node's inOrderNumber, preOrderNumber,
	 * and postOrderNumber fields to 0 to reset them.
	 * Should be used when the tree has been changed
	 * either by adding or removing nodes.
	 */
	public static void clearNodeOrders() {
		Node u = r;
		Node prev = null;
		Node next;
		while (u != null) {
			u.inOrderNumber = 0;
			u.preOrderNumber = 0;
			u.postOrderNumber = 0;
			if (prev == u.parent) {
				if ( u.leftChild != null) {
					next = u.leftChild;
				}
				else if ( u.rightChild != null) {
					next = u.rightChild;
				}
				else {
					next = u.parent;
				}
			}
			else if (prev == u.leftChild) {
				if (u.rightChild != null) {
					next = u.rightChild;
				}
				else {
					next = u.parent;
				}
			}
			else {
				next = u.parent;
			}
			prev = u;
			u = next;
		}
	}
	/**
	 * Use recursion to run through the tree rooted at
	 * node u, then print it's key, preOrderNumber,
	 * inOrderNumber, and postOrderNumber.
	 * @param u The root for the tree or subtree.
	 */
	public static void printNodeOrders(Node u) {
		if (u == null) {
			return;
		}
		printNodeOrders(u.leftChild);
		System.out.print("The node " + u.key + "'s next pre order ");
		System.out.print("node is " + u.preOrderNumber + ", it's in ");
		System.out.print("order number is " + u.inOrderNumber + " and it's ");
		System.out.println("post order number is " + u.postOrderNumber + ".");
		printNodeOrders(u.rightChild);
	}
}
