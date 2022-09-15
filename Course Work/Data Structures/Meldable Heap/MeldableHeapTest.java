/**
 * 	Assignment3, Question 7 COMP272
 * Class: MeldableHeapTest.java
 * Purpose: To test the MeldableHeap.java class
 * for accuracy and functionality.
 * 
 * 
 * @author Braiden Little
 * Student ID: 3364064
 * Date: April 11 2019
 * Version 1.0
 * 
 * Based on: Open Data Structures (in Java) By Pat Morin
 */	
public class MeldableHeapTest {

	public static void main(String[] args) {
		MeldableHeap heap = new MeldableHeap();
		
		heap.add(4); //Create the heap.
		heap.add(8);
		heap.add(9);
		heap.add(17);
		heap.add(19);
		heap.add(50);
		heap.add(16);
		heap.add(26);
		System.out.println("The heap in an breadth first traversal looks like:");
		heap.printList();
		System.out.println(" Delete the node 17 \n");
		heap.remove(heap.find(17)); //Test deleting a node in the middle of the heap.
		System.out.println("The heap in an breadth first traversal now looks like:");
		heap.printList(); 
		System.out.println(" Delete the node 4 \n"); //Will call upon remove() to delete the root.
		heap.remove(heap.find(4));
		System.out.println("The heap in an breadth first traversal now looks like:");
		heap.printList(); 
		/*
		 * Delete the entire tree to 
		 * test the remove(u) method
		 * and all it's edge cases.
		 */
		System.out.println(" Delete the node 8 \n");
		heap.remove(heap.find(8));
		System.out.println("The heap in an breadth first traversal now looks like:");
		heap.printList(); 
		System.out.println(" Delete the node 16 \n");
		heap.remove(heap.find(16));
		System.out.println("The heap in an breadth first traversal now looks like:");
		heap.printList(); 
		System.out.println(" Delete the node 19 \n");
		heap.remove(heap.find(19));
		System.out.println("The heap in an breadth first traversal now looks like:");
		heap.printList(); 
		System.out.println(" Delete the node 50 \n");
		heap.remove(heap.find(50));
		System.out.println("The heap in an breadth first traversal now looks like:");
		heap.printList(); 
		System.out.println(" Delete the node 9 \n");
		heap.remove(heap.find(9));
		System.out.println("The heap in an breadth first traversal now looks like:");
		heap.printList(); 
		System.out.println(" Delete the node 26 \n");
		heap.remove(heap.find(26));
		System.out.println("The heap in an breadth first traversal now looks like:");
		heap.printList(); 
		//Try deleting a node that does not exist.
		System.out.println(" Delete the node 26 \n");
		heap.remove(heap.find(26));
	}
}
