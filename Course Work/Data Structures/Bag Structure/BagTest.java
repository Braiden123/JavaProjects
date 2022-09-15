/**
 * 	Assignment1, Question 3 COMP272
 * Class: Bag.java
 * Purpose: To test the Bag.java class for
 * functionality and accuracy.
 * 
 * @author Braiden Little
 * Student ID: 3364064
 * Date: January 26 2019
 * Version 1.0
 * 
 * Based on: Open Data Structures (in Java) By Pat Morin
 */
public class BagTest {

	public static void main(String[] args) {
		Bag.add(0, 37);
		Bag.add(0, 76);
		Bag.add(0, 8);
		Bag.add(0, 76);
		Bag.add(0, 52);
		Bag.add(0, 99);
		Bag.add(0, 76);
		Bag.add(0, 22);
		Bag.add(0, 5);
		System.out.println("The array looks like:");
		Bag.printList();
		System.out.println();
		System.out.print("Removing the data at the sixth index");
		System.out.println(" removes " + Bag.remove(6) + ".");
		System.out.println("The list now looks like:");
		Bag.printList();
		System.out.println();
		System.out.println("Attempting to find 52 in the list:");
		System.out.println(Bag.find(52));
		System.out.println("Attempting to find 55 in the list:");
		System.out.println(Bag.find(55));
		System.out.println("Attempting to find all 76's in the list:");
		Bag.printArray(Bag.findAll(76));
		System.out.println();
		System.out.println("Attempting to find all 2's in the list:");
		System.out.println(Bag.findAll(2));
	}
}
