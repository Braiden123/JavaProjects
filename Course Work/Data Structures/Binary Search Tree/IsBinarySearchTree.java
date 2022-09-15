/**
 * 	Assignment2, Question 2 COMP272
 * Class: IsBinarySearchTree.java
 * Purpose: Extend the binary tree class and use a method
 * to determine if the tree satisfies the properties
 * of a binary search tree.
 * 
 * @author Braiden Little
 * Student ID: 3364064
 * Date: February 23 2019
 * Version 1.0
 * 
 * Based on: Open Data Structures (in Java) By Pat Morin
 */
public class IsBinarySearchTree extends BinaryTree{
	
	/**
	 * Uses recursion to traverse the tree
	 * returning the smallest key value found
	 * This method will work regardless of
	 * whether the tree satisfies the 
	 * Binary Search Tree property.
	 * @param u The root of the tree or subtree
	 * @return The smallest key value in the tree
	 */
	public static int findMin(Node u) {
		if (u.leftChild == null && u.rightChild !=null) {
			return findMin(u.rightChild);
		}
		else if(u.leftChild != null && u.rightChild == null) {
			return findMin(u.leftChild);
		}
		else if (u.leftChild == null && u.rightChild == null) {
			return u.key;
		}
		else {
			return Math.min(findMin(u.leftChild), findMin(u.rightChild));
		}	
	}
	
	/**
	 * Uses recursion to traverse the tree
	 * returning the largest key value found
	 * This method will work regardless of
	 * whether the tree satisfies the 
	 * Binary Search Tree property.
	 * @param u The root of the tree or subtree
	 * @return The largest key value in the tree
	 */
	public static int findMax(Node u) {
		if (u.leftChild == null && u.rightChild !=null) {
			return findMax(u.rightChild);
		}
		else if(u.leftChild != null && u.rightChild == null) {
			return findMax(u.leftChild);
		}
		else if (u.leftChild == null && u.rightChild == null) {
			return u.key;
		}
		else {
			return Math.max(findMax(u.leftChild), findMax(u.rightChild));
		}	
	}
	
	/**
	 * Calls the findMin(r) and findMax(r) methods
	 * to find the smallest and largest values in the tree
	 * then passes these values into a call to isBST() method
	 * to determine if the tree satisfies the BST properties.
	 * @precondition Use if the minimum and maximum values in the tree are unknown
	 * @return True if the tree is a BST, otherwise return false.
	 */
	public static boolean isBSTUnknownMinMax() {
		return isBST(r, findMin(r), findMax(r));
	}
	
	/**
	 * Uses recursive calls to traverse through the tree
	 * checking each node to see if it satisfies the BST property.
	 * It will check if a node is less than or greater than it's 
	 * parent or any nodes above it when searching the left
	 * and right children respectively. Recursive calls
	 * are made with left child calls using u.key - 1
	 * as the maxKey to ensure all unique values in the tree.
	 * Recursive calls are also made with left child calls 
	 * using u.key + 1 as the minKey to ensure all unique 
	 * values in the tree.
	 * @param u The root of the tree or subtree
	 * @param minKey Node cannot be smaller than this key value.
	 * @param maxKey Node cannot be larger than this key value.
	 * @return True if the tree satisfies the BST properties.
	 * Otherwise return false.
	 */
	public static boolean isBST(Node u, int minKey, int maxKey) {
		if (u == null) {
			return true;
		}
		if (u.key < minKey || u.key > maxKey) {
			return false;
		}
		return (isBST(u.leftChild, minKey, u.key - 1) && isBST(u.rightChild, u.key + 1, maxKey));
	}
}
