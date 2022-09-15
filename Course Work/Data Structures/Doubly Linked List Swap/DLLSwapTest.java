/**
 * 	Assignment1, Question 2 b) COMP272
 * Class: DLLSwapTest.java
 * Purpose: To test the functionality and accuracy
 * of the DLLSwap.java class.
 * 
 * @author Braiden Little
 * Student ID: 3364064
 * Date: January 21 2019
 * Version 1.0
 * 
 * Based on: Open Data Structures (in Java) By Pat Morin
 */
public class DLLSwapTest {

	public static void main(String[] args) {
		System.out.println("The current list is: ");
		DLLSwap.printList();
		for (int i = 0; i <= 6; i++) { //Create the list with 7 nodes.
			DLLSwap.addAtEnd((int)(Math.random() * 100));
			System.out.println();
			System.out.println("The current list is: ");
			DLLSwap.printList();
		}
		System.out.println();
		System.out.println("The fourth node shall be ");
		System.out.print("swapped with the previous.");
		System.out.println();
		DLLSwap.swapPrev(DLLSwap.getNode(3)); //Swap the fourth node with the third
		System.out.println("The list now looks like: ");
		DLLSwap.printList();
		System.out.println();
		System.out.println("The sixth node shall now ");
		System.out.print("be swapped with the next node.");
		System.out.println();
		DLLSwap.swapNext(DLLSwap.getNode(5)); //Swap the sixth node with the seventh
		System.out.println("The list now looks like: ");
		DLLSwap.printList();
	}
}
