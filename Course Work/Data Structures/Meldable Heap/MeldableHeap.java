import java.util.Random;
import java.util.LinkedList;
import java.util.Queue;
public class MeldableHeap{
/**
 * 	Assignment3, Question 7 COMP272
 * Class: MeldableHeap.java
 * Purpose: Create a meldable heap that supports
 * the merge, add(key), remove() and remove(u) 
 * functions.
 * 
 * 
 * @author Braiden Little
 * Student ID: 3364064
 * Date: April 11 2019
 * Version 1.0
 * 
 * Based on: Open Data Structures (in Java) By Pat Morin
 */	
	
	/**
	 * Nodes in the Meldable Heap
	 * Contains a constructor with the nodes key
	 */
	class Node {
		public Node(int key) {
			this.key = key; //Store key for the new node
		}
		Node parent;
		Node leftChild;
		Node rightChild;
		int key;
	}
	
	protected Random rand = new Random(); //used to generate random boolean for merge.
	int n; //number of elements in the array.
	Node r; //Root of the heap
	
	/**
	 * Use recursion to merge heap 1 and heap 2 into one node
	 * @param h1 The first heap
	 * @param h2 The second heap
	 * @return h1 to become the left or right child of parent
	 * or merge to continue down the heap and merging
	 */
	Node merge(Node h1, Node h2) {
		if (h1 == null) { //no heap 1 return h2
			return h2;
		}
		if (h2 == null) { //no heap 2 return h1
			return h1;
		}
		if (h2.key < h1.key) { //h1 > h2 reverse the roles of the heaps
			return merge(h2, h1);
		}
		if (rand.nextBoolean()) { /*Simulate flipping a coin to determine
									if h2 should merge with h1.leftchild or
									h1.rightchild.*/
			h1.leftChild = merge(h1.leftChild, h2);
			h1.leftChild.parent = h1;
		}
		else {
			h1.rightChild = merge(h1.rightChild, h2);
			h1.rightChild.parent = h1;
		}
		return h1;
	}
	/**
	 * Add a new node to the heap by merging the new node
	 * with the root.
	 * @param key The key of the new node
	 * @return true if the node has been added
	 */
	public boolean add(int key) {
		Node u = new Node(key);
		r = merge(u, r);
		r.parent = null;
		n++; //Update the number of nodes in the heap.
		return true;
	}
	/**
	 * Remove the root of the tree by merging the 
	 * left and right children of the root.
	 * @return The node that was removed
	 */
	public void remove() {
		r = merge(r.leftChild, r.rightChild);
		if (r != null) {
			r.parent = null;
		}
		n--; //Update the number of nodes in the heap.
	}
	
	/**
	 * Search through the heap to find the node
	 * with the given key.
	 * @param key The key of the node we are looking for
	 * @return The node found, null if not found.
	 */
	public Node find(int key) {
		Node foundNode = null;
		Node u = r;
		Node prev = null;
		Node next = null;
		while (u != null) { /*Traverse the tree until the node is found or
							we finish the traversal.*/
			if (u.key == key) { //Node is found break from the loop
				foundNode = u;
				break;
			}
			if (prev == u.parent) {
                if (u.leftChild != null) next = u.leftChild;
                else if (u.rightChild != null) next = u.rightChild;
                else next = u.parent;
            } else if (prev == u.leftChild) {
                if (u.rightChild != null) next = u.rightChild;
                else next = u.parent;
            } else {
                next = u.parent;
            }
            prev = u;
            u = next;
		}
		return foundNode;
	}
	
	/**
	 * Remove the specified node from the heap
	 * by merging its left and right children.
	 * @param u The node to be removed.
	 * @return The node that was removed.
	 */
	public void remove(Node u) {
		if (u == null) {
			System.out.println("Specified node does not exist, cannot delete.");
			return;
		}
		if (u == r) {
			remove();
		}
		else {
			if (u == u.parent.leftChild) { /* The node being removed is 
											the left child of u's parent.*/
				u.parent.leftChild = null;
			}
			else { //The node being removed is the right child of u's parent.
				u.parent.rightChild = null;
			}
			u.parent = null; //Remove the parent pointer of u
			r = merge(r, u.leftChild); //Merge u's left child back into the heap.
			r = merge(r, u.rightChild); //Merge u's right child back into the heap.
			r.parent = null; //r does not have a parent as it is the root
			n--; //Update the number of nodes in the heap.
		}
	}
	
	/**
	 * Print the nodes of the heap in a breadth first traversal,
	 * using a queue to store the nodes and remove them, printing
	 * as they are removed.
	 */
	public void printList() {
		Queue<Node> q = new LinkedList<Node>();
		if (r != null) {
			q.add(r);
		}
		while (!q.isEmpty()) {
			Node u = q.remove();
			System.out.print("{" + u.key + "}");
			if (u.leftChild != null) {
				q.add(u.leftChild);
			}
			if (u.rightChild != null) {
				q.add(u.rightChild);
			}
		}
	}
}
