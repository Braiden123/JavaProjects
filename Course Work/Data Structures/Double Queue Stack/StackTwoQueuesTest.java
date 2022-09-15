/**
 * 	Assignment1, Question 1 b) COMP272
 * Class: StackTwoQueuesTest.java
 * Purpose: To test the implementation of the
 * StackTwoQueues.java class for correctness.
 * 
 * @author Braiden Little
 * Student ID: 3364064
 * Date: January 16 2019
 * Version 1.0
 * 
 * Based on: Open Data Structures (in Java) By Pat Morin
 */
public class StackTwoQueuesTest {

	public static void main(String[] args) {
		
		for (int i = 0; i <= 6; i++) {
			StackTwoQueues.push((int)(Math.random() * 100));
			System.out.println("The first queue contains: ");
			StackTwoQueues.q1.printList();
			System.out.println("The second queue contains: ");
			StackTwoQueues.q2.printList();
		}
		
		for (int i = 0; i <= 6; i++) {
			StackTwoQueues.pop();
			System.out.println("The first queue contains: ");
			StackTwoQueues.q1.printList();
			System.out.println("The second queue contains: ");
			StackTwoQueues.q2.printList();
		}

	}

}
