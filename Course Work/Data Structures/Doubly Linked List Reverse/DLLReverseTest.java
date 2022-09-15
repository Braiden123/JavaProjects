/**
 * 	Assignment1, Question 5 COMP272
 * Class: Bag.java
 * Purpose: To test the DLLReverse.java class
 * for functionality and accuracy.
 * 
 * @author Braiden Little
 * Student ID: 3364064
 * Date: January 27 2019
 * Version 1.0
 * 
 * Based on: Open Data Structures (in Java) By Pat Morin
 */
public class DLLReverseTest {

	public static void main(String[] args) {
		System.out.println("The current list is: ");
		DLLReverse.printList();
		for (int i = 0; i <= 6; i++) { //Create the list with 7 nodes.
			DLLReverse.addAtEnd((int)(Math.random() * 100));
			System.out.println();
			System.out.println("The current list is: ");
			DLLReverse.printList();
		}
		DLLReverse.reverse(DLLReverse.dummy);
		System.out.println();
		System.out.print("The reversed list is: ");
		DLLReverse.printList();
	}
}
