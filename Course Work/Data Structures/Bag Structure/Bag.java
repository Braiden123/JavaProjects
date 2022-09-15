/**
 * 	Assignment1, Question 3 COMP272
 * Class: Bag.java
 * Purpose: To implement the Bag data structure
 * supporting add(x), remove(x), find(x) and 
 * findAll(x).
 * 
 * @author Braiden Little
 * Student ID: 3364064
 * Date: January 26 2019
 * Version 1.0
 * 
 * Based on: Open Data Structures (in Java) By Pat Morin
 */
public class Bag {
	static int[] a = new int[0]; //New array to hold the bag.
	static int n; //Number of elements in the array.
	/**
	 * @return the number of data sets in the array
	 */
	public static int size() {
		return n;
	}
	/**
	 * Return the number at the specified position in the array
	 * @param i the index in the array to have data returned from.
	 * @return the data at index i
	 */
	public static int get (int i) {
		if (i < 0 || i > n) {
			throw new IndexOutOfBoundsException("Requested index is outside of the range of the array.");
		}
		return a[i];
	}
	/**
	 * Set the array index at position i to equal x
	 * @param i the index of the array to be set
	 * @param x the new data to set 
	 * @return the old data stored in the index
	 */
	public static int set (int i, int x) {
		if (i < 0 || i > n - 1) {
			throw new IndexOutOfBoundsException("Requested index is outside of the range of the array.");
		}
		int y = a[i];
		a[i] = x;
		return y;
	}
	/**
	 * Remove the index at position i then move 
	 * all the indexes ahead of i one position
	 * to the left
	 * @param i the index to be removed
	 */
	public static int remove (int i) {
		if (i < 0 || i > n - 1) {
			throw new IndexOutOfBoundsException("Requested index is outside of the range of the array.");
		}
		int x = a[i];
		for (int j = i; j <= n - 1; j++) {
			if (j == n - 1) {
				a[j] = 0;
				break;
			}
			a[j] = a[j + 1];
		}
		n--;
		if (a.length >= 3 * n) resize();
		return x;
	}
	/**
	 * move all indexes to the 
	 * right starting at the end 
	 * of the array then add the new 
	 * data set x at index i 
	 * @param i the index to be added to
	 * @param x the data to be added to i
	 */
	public static void add(int i, int x) {
		if (i < 0 || i > n) {
			throw new IndexOutOfBoundsException("Requested index is outside the range of the array.");
		}
		if (n + 1 > a.length) {
			resize();
		}
		for (int j = n; j > i; j--) { //Move all data sets from the end to the right.
			a[j] = a[j - 1];
		}
		a[i] = x; //Set index i to contain x
		n++;
	}
	/**
	 * 8Create a new array b the size of 2 * n
	 * then move all the data from a to b
	 * then set a to equal the new array, b.
	 */
	public static void resize() {
		int[] b = new int[Math.max(2 * n, 1)]; //Create a new array twice the size of n or size 1
		for (int i = 0; i < n; i++) {
			b[i] = a[i];
		}
		a = b;
	}
	/**
	 * Run through the array and return
	 * the first instance of x found.
	 * @param x the number to be found in the array.
	 * @return The number x if found, null
	 * if x was not found in the array.
	 */
	public static int find(int x) {
		for (int i = 0; i < a.length; i++) {
			if (a[i] == x) {
				return a[i];
			}
		}
		System.out.println("The number does not exist in the array.");
		return -1;
	}
	/**
	 * Create a new array allFound to record all instances of x.
	 * Run through the array a and add to allFound if x is found.
	 * @param x The number to be found in the array.
	 * @return The array allFound containing all instances of x.
	 * else return null if x is not found.
	 */
	public static int[] findAll(int x) {
		int[] allFound = new int[a.length]; //array to store x found
		int count = 0; //Used to track how many time x has been found
		int j = 0; /*used to move through the new array containing all 
				instances of x*/
		for (int i = 0; i < a.length; i++) {
			if (a[i] == x) { //x is found add to allFound array.
				allFound[j] = a[i];
				count++;
				j++;
			}
		}
		if (count == 0) {
			return null;
		}
		else {
			return allFound;
		}
	}
	/**
	 * Print out all the variables in the array.
	 */
	public static void printList() {
		if (n == 0) {
			System.out.println("The list is empty");
			return;
		}
		System.out.println();
		for (int i = 0; i < a.length; i++) {
			System.out.print("{" + a[i] + "}");
		}
	}
	/**
	 * Method to print out a given array
	 */
	public static void printArray(int[] c) {
		System.out.println();
		for (int i = 0; i < c.length; i++) {
			if (c[i] == 0) {
				return;
			}
			else {
				System.out.print("{" + c[i] + "}");
			}
		}
	}
}
