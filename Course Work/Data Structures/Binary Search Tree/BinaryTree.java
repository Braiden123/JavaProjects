/**
 * 	Assignment2, Question 1 COMP272
 * Class: BinaryTree.java
 * Purpose: Create a binary tree and use methods
 * that can return the next node from the requested
 * node for in order, post order, and pre order
 * traversals of the tree.
 * 
 * 
 * @author Braiden Little
 * Student ID: 3364064
 * Date: February 26 2019
 * Version 1.0
 * 
 * Based on: Open Data Structures (in Java) By Pat Morin
 */
public class BinaryTree {
	
	static Node r; //The root of the tree.
	
	static int n; //The number of elements in the tree.
	
	/**
	 * Nodes in the binary tree
	 * Contains a constructor with the nodes key
	 */
	static class Node {
		public Node(int key) {
			this.key = key; //Store key for the new node
		}
		Node parent;
		Node leftChild;
		Node rightChild;
		int key;
	}
	
	/**
	 * Call the find last function to find the 
	 * node to attach the new node too.
	 * Then call the addChild function
	 * to add the new node as the child
	 * of the lastNode found
	 * @param key the key for 
	 * the new node to be added.
	 * @return True if the node was
	 * added, false otherwise.
	 */
	public static boolean add(int key) {
		Node p = findLast(key);
		Node newNode = new Node(key);
		return addChild(p, newNode);
	}
	
	/**
	 * Traverse the tree to find
	 * the node that should be the
	 * parent of the given key value
	 * @param key The key to find
	 * the parent of
	 * @return the node that is the
	 * parent of the key 
	 */
	public static Node findLast(int key) {
		Node w = r; //Start at the root
		Node prev = null;
		while (w != null) {
			prev = w;
			if (key < w.key) { //Key is less than the node
				w = w.leftChild; //Move left
			}
			else if (key > w.key) {//Key is greater than the node
				w = w.rightChild; //Move right
			}
			else { //Node is equal to the key
				return w; //Return the node
			}
		}
		return prev; //Return the previous node before the key.
	}
	
	/**
	 * Add a child node to the requested node
	 * @param p The requested node
	 * @param u The new child node
	 * @return True if the node was added
	 * Return false if the node was already
	 * in the tree and was not added.
	 */
	public static boolean addChild(Node p, Node u) {
		if (p == null) { //First node in the tree, set it as the root
			r = u;
		}
		else {
			if (u.key < p.key) { //Node is less than the parent move left.
				p.leftChild = u;
			}
			else if (u.key > p.key) { //Node is greater than the parent move right.
				p.rightChild = u;
			}
			else {
				return false; //u.key is already in this tree
			}
			u.parent = p; //update u's parent pointer
		}
		n++; //increment the number of nodes
		return true;
	}
	
	/**
	 * Splice the node from it's parent node
	 * by having u.parent adopt u's child
	 * @param u the node to be spliced.
	 */
	public static void splice(Node u) {
		Node s; //u's child to be adopted by p
		Node p; //u's parent node
		if (u.leftChild != null) { //s is u's left child
			s = u.leftChild;
		}
		else { //s is u's right child
			s = u.rightChild;
		}
		if (u == r) { //node u is the root
			r = s; //u's child is now the root
			p = null; //root has no parent
		}
		else { 
			p = u.parent; //set p to equal u's parent
			if (p.leftChild == u) { //p adopts u's child as it's left child
				p.leftChild = s;
			}
			else {
				p.rightChild = s; //p adopts u's child as it's right child
			}
		}
		if (s != null) { // set p as the parent of s
			s.parent = p;
		}
		n--; //Decrement the number of nodes in the tree.
	}
	
	/**
	 * Will remove the requested node, u from the tree
	 * by calling the splice method if u is a leaf.
	 * Otherwise find the smallest value in the tree
	 * rooted at node u.rightchild then splice that node, w.
	 * @param u //The node to be removed
	 */
	public static void remove (Node u) {
		if (u.leftChild == null || u.rightChild == null) {
			splice(u);
		}
		else {
			Node w = u.rightChild;
			while (w.leftChild != null) {
				w = w.leftChild;
			}
			u.key = w.key;
			splice(w);
		}
	}
	
	/**
	 * Search through the tree until a node with
	 * the requested key is found. Go left in the
	 * tree if the value is smaller than the search
	 * node w's key, right if the key is larger than w.key
	 * @param key the key of the node to be found
	 * @return return the node that was requested
	 * if found. Otherwise return the key that is the
	 * smallest number in the tree but is still greater
	 * than the requested key.
	 */
	public static Node find(int key) {
		Node w = r;
		Node z = null;
		while (w != null) {
			if (key < w.key) {
				z = w;
				w = w.leftChild;
			}
			else if (key > w.key) {
				w = w.rightChild;
			}
			else {
				return w;
			}
		}
		return z == null ? null : z;
	}
	
	/**
	 * Traverse the tree by using recursion
	 * on the requested nodes left and right child
	 * @param u The root of the tree or subtree
	 * to be traversed.
	 */
	public static void traverse(Node u) {
		if (u == null) {
			return;
		}
		traverse(u.leftChild);
		traverse(u.rightChild);
	}
	
	/**
	 * Find the key to the next node
	 * from the requested node, assuming
	 * an in order traversal of the tree.
	 * @param u The node requested
	 * @return The key of the next node
	 * in a pre order traversal.
	 */
	public static int preOrderNext(Node u) {
		return u.key;
	}
	
	/**
	 * Find the key to the next node
	 * from the requested node, assuming
	 * an in order traversal of the tree.
	 * @param u The node requested
	 * @return The key of the next node
	 * in an in order traversal.
	 */
	public static int inOrderNext(Node u) {
		if (u.leftChild != null) {
			return u.leftChild.key;
		}
		else{
			return u.key;
		}
	}
	
	/**
	 * Find the key to the next node
	 * from the requested node, assuming
	 * a post order traversal of the tree.
	 * @param u The node requested
	 * @return The key of the next node
	 * in a post order traversal.
	 */
	public static int postOrderNext(Node u) {
		if (u.leftChild != null) {
			return u.leftChild.key;
		}
		else if (u.rightChild != null) {
			return u.rightChild.key;
		}
		else {
			return u.key;
		}
	}
	
	/**
	 * Uses recursion to print out the keys
	 * of each node in the binary tree
	 * in an in order traversal of the tree.
	 * @param u The root of the tree or subtree.
	 */
	public static void printTree(Node u) {
		if (u == null) {
			return;
		}	
		printTree(u.leftChild);
		System.out.print("(" + u.key + ")");
		printTree(u.rightChild);
	}
}
