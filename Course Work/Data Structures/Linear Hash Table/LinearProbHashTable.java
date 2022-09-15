/**
 * 	Assignment2, Question 4 COMP272
 * Class: LinearProbHashTable.java
 * Purpose: Create a hash table with the hash
 * function K mod 13 and to implement linear
 * probing to handle collisions.
 * 
 * @author Braiden Little
 * Student ID: 3364064
 * Date: February 14 2019
 * Version 1.0
 * 
 * Based on: Open Data Structures (in Java) By Pat Morin
 */
public class LinearProbHashTable{
	
	static String[] table = new String[30];
	
	static int d; //t.length = 2^d
	
	static int n; //Variable to track the number of elements
	
	static int q; //Variable to track of all non-null values.
	
	/**
	 * @return The number of elements in the hash table.
	 */
	public int size() {
		return n;
	}
	
	/**
	 * @precondition String cannot contain non integer values
	 * Hash an object using K mod 13
	 * @param element The element to be hashed
	 * @return 
	 */
	public static int hash(String element) {
		int x = Integer.parseInt(element);
		return x % 13;
	}
	
	/**
	 * Find an element in the hash table
	 * @param element to be found
	 * @return the element if found, null 
	 * if the element does not exist in the table.
	 */
	public static String find(String element) {
		int location = hash(element);
		while (table[location] != null) {
			if (table[location] != "del" && table[location] == element) {
				return table[location];
			}
			location = (location == table.length - 1) ? 0 : location + 1; /*increment location
																			return to index 0
																			if at the end of 
																			the table.*/
		}
		return null;
	}
	
	/**
	 * @precondition element cannot already exist in the hash table
	 * hash and element then add it to the hash table
	 * @param element the element to be hashed and added.
	 * @return true if the element was added to the table.
	 * Return false if the element was already in the table
	 * and could not be added.
	 */
	public static boolean add(String element) {
		if (find(element) != null) {
			return false;
		}
		if (2 * q + 1 > table.length) { //max 50% occupancy.
			resize(); //Resize the table
		}
		int location = hash(element); //Find the hash of the element and start there.
		while (table[location] != null && table[location] != "del") { /*index is empty and doesn't 
																		contain a deleted element.*/
			location = (location == table.length - 1) ? 0 : location + 1; /*increment location
																			return to index 0
																			if at the end of 
																			the table.*/
		}
		if (table[location] == null) {
			q++;
		}
		n++;
		table[location] = element;
		return true;
	}
	
	/**
	 * Remove the requested element from the hash table
	 * @param element The element to be removed
	 * @return the element that was deleted
	 * null if the element was not in the list.
	 */
	public String remove(String element) {
		int location = hash(element);
		while (table[location] != null && table[location] != "del") {/*index is empty and doesn't 
																		contain a deleted element.*/
			String y = table[location];
			if (element == table[location] && y != "del") {
				n--;
				table[location] = "del";
				if (8 * n < table.length) { //Minimum 12.5% occupancy
					resize(); //Resize the table
				}
				return y;
			}
			location = (location == table.length - 1) ? 0 : location + 1; /*increment location
																			return to index 0
																			if at the end of 
																			the table.*/
		}
		return null;
	}
	
	/**
	 * Resize the table to be the closest number to
	 * 3 * n while maintaining the rule that
	 * table.length = 2^d
	 */
	private static void resize() {
		d = 1;
        while ((1<<d) < 3*n) {
        	d++;
        }	
        String[] told = new String[1 << d];
        q = n;
        for (int i = 0; i < told.length; i++) {
        	if (told[i] != null && told[i] != "del") {
        		int k = hash(told[i]);
        		while (table[k] != null) {
        			i = (i == table.length-1) ? 0 : i + 1;
        		}
        		table[k] = told[i];
        	}
        }
	}
	
	/**
	 * Method for printing out every value in the table.
	 */
	static void printTable() {
		for (int i = 0; i < table.length; i++) {
			System.out.print(table[i] + " ,");
		}
	}
	
}
