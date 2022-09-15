/**
 * 	Assignment2, Question 1 COMP272
 * Class: BinaryTreeOrderNumberTest.java
 * Purpose: To test the OrderNumberBT.java class
 * for functionality and accuracy.
 * 
 * @author Braiden Little
 * Student ID: 3364064
 * Date: March 7 2019
 * Version 1.0
 * 
 * Based on: Open Data Structures (in Java) By Pat Morin
 */
public class BinaryTreeOrderNumberTest {

	public static void main(String[] args) {
		//Create a new binary tree
		OrderNumberBT.add(20);
		OrderNumberBT.add(10);
		OrderNumberBT.add(5);
		OrderNumberBT.add(15);
		OrderNumberBT.add(12);
		OrderNumberBT.add(7);
		OrderNumberBT.add(40);
		OrderNumberBT.add(30);
		OrderNumberBT.add(25);
		OrderNumberBT.add(35);
		OrderNumberBT.add(45);//Set the pre-order, in-order, and post-order fields for each node.
		OrderNumberBT.inOrderNumber();
		OrderNumberBT.preOrderNumber();
		OrderNumberBT.postOrderNumber();
		OrderNumberBT.printNodeOrders(OrderNumberBT.r);
		OrderNumberBT.remove(OrderNumberBT.find(45));//Delete the old tree and create a new one.
		OrderNumberBT.remove(OrderNumberBT.find(35));
		OrderNumberBT.remove(OrderNumberBT.find(25));
		OrderNumberBT.remove(OrderNumberBT.find(30));
		OrderNumberBT.remove(OrderNumberBT.find(40));
		OrderNumberBT.remove(OrderNumberBT.find(7));
		OrderNumberBT.remove(OrderNumberBT.find(12));
		OrderNumberBT.remove(OrderNumberBT.find(15));
		OrderNumberBT.remove(OrderNumberBT.find(5));
		OrderNumberBT.remove(OrderNumberBT.find(10));
		OrderNumberBT.remove(OrderNumberBT.find(20));
		OrderNumberBT.add(58);
		OrderNumberBT.add(29);
		OrderNumberBT.add(51);
		OrderNumberBT.add(4);
		OrderNumberBT.add(22);
		OrderNumberBT.add(83);
		OrderNumberBT.add(92);
		System.out.println();		
		OrderNumberBT.inOrderNumber();//Set the pre-order, in-order, and post-order fields for each node.
		OrderNumberBT.preOrderNumber();
		OrderNumberBT.postOrderNumber();
		OrderNumberBT.printNodeOrders(OrderNumberBT.r);
	}
}
