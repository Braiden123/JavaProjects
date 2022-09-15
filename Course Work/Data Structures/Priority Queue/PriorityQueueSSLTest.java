/**
 * 	Assignment1, Question 1 a) COMP272
 * Class: PriorityQueueSLL.java
 * Purpose: To test the PriorityQueueSLL.java class for correctness.
 * 
 * @author Braiden Little
 * Student ID: 3364064
 * Date: January 12 2019
 * Version 1.0
 * 
 * Based on: Open Data Structures (in Java) By Pat Morin
 */
public class PriorityQueueSSLTest {

	public static void main(String[] args) {
		for (int i = 0; i <= 5; i++) {
			int x = (int)(Math.random() * 100);
			PriorityQueueSLL.add(x);
		}
		while (PriorityQueueSLL.size() != 0) {
			PriorityQueueSLL.printList();
			System.out.println();
			System.out.println("The list size is " + PriorityQueueSLL.size());
			System.out.println("Number deleted:" + PriorityQueueSLL.deleteMin());
		}
		PriorityQueueSLL.printList();
		PriorityQueueSLL.deleteMin();
	}

}
