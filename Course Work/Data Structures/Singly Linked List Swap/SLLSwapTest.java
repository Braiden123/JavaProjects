/**
 * 	Assignment1, Question 2 a) COMP272
 * Class: SLLSwap.java
 * Purpose: To test the SLLSwap.java class
 * for functionality and accuracy.
 * 
 * @author Braiden Little
 * Student ID: 3364064
 * Date: January 16 2019
 * Version 1.0
 * 
 * Based on: Open Data Structures (in Java) By Pat Morin
 */
public class SLLSwapTest {

	public static void main(String[] args) {
		System.out.println("The current list is: ");
		SLLSwap.printList();
		for (int i = 0; i <= 6; i++) { //Create the list with 7 nodes
			SLLSwap.add((int)(Math.random() * 100));
			System.out.println();
			System.out.println("The current list is: ");
			SLLSwap.printList();
		}
		System.out.println();
		System.out.println("The fourth node shall be ");
		System.out.print("swapped with the previous.");
		System.out.println();
		SLLSwap.swapWithPrev(3); //Swap the fourth node with the third
		System.out.println("The list now looks like: ");
		SLLSwap.printList();
		System.out.println();
		System.out.println("The sixth node shall now ");
		System.out.print("be swapped with the next node.");
		System.out.println();
		SLLSwap.swapWithNext(6);
		System.out.println("The list now looks like: ");
		SLLSwap.printList();
		System.out.println("Swapping the head with the next");
		SLLSwap.swapWithNext(1);
		System.out.println("The list now looks like: ");
		SLLSwap.printList();
	}

}
