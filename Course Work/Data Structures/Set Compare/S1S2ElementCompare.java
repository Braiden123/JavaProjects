import java.util.PriorityQueue;
/**
 * 	Assignment3, Question 3 COMP272
 * Class: S1S2ElementCompare.java
 * Purpose: To create two sets containing elements and then compare 
 * them to see if they contain the same set of elements.
 * Both sets are defined by a total order relation.
 * The main method will test for accuracy and
 * functionality.
 * 
 * 
 * @author Braiden Little
 * Student ID: 3364064
 * Date: April 24 2019
 * Version 1.0
 * 
 * Based on: Open Data Structures (in Java) By Pat Morin
 */	
public class S1S2ElementCompare {
	
	/**
	 * Take two sets of elements and then test to see if 
	 * they are different sizes. If they are then return
	 * false as they cannot contain the same elements. 
	 * If they are the same size, record the size of 
	 * the sets and create two copies. Continue
	 * by removing the head of each set and comparing
	 * if the heads are the same, if at any point the 
	 * elements are not equal, then return false.
	 * Afterwards return true as all elements are
	 * identical as each has been tested.
	 * @param S1 The first set of elements as a heap.
	 * @param S2 The second set of elements as a heap.
	 * @return False if the elements in each set are not
	 * identical, true otherwise.
	 */
	public static boolean containsSameElements(PriorityQueue<Integer> S1, PriorityQueue<Integer> S2) {
		if (S1.size() != S2.size()) /*If the two sets contain a different number of elements they
										cannot contain the same set of Elements*/
			return false;
		int setSize = S1.size(); //record the size of the sets
		PriorityQueue<Integer> S1Copy = new PriorityQueue<Integer>(S1); //Create a copy of S1
		PriorityQueue<Integer> S2Copy = new PriorityQueue<Integer>(S2); //Create a copy of S2
		for (int i = 0; i < setSize; i++) {
			if (S1Copy.poll() != S2Copy.poll()) //Elements are not equal return false.
				return false;
		}
		return true; //All elements were equal in each set, return true.
	}
	
	public static void main(String[] args) {
		PriorityQueue<Integer> S1 = new PriorityQueue<Integer>(); //The first set of elements as a heap.
		PriorityQueue<Integer> S2 = new PriorityQueue<Integer>(); //The second set of elements as a heap.
		
		System.out.println("S1 and S2 will be created with the same elements and some duplicates.");
		{ //Create two sets containing the same elements to test containsSameElements
		S1.add(5);
		S1.add(2);
		S1.add(7);
		S1.add(89);
		S1.add(5);
		S1.add(5);
		S1.add(89);
		S1.add(47);
		}
		{
		S2.add(89);
		S2.add(5);
		S2.add(47);
		S2.add(5);
		S2.add(89);
		S2.add(5);
		S2.add(7);
		S2.add(2);
		}
		if (containsSameElements(S1, S2)) //Set contains the same elements
			System.out.println("The two sets contain the same elements.");
		else 
			System.out.println("The two sets do not contain the same elements.");
		S1.clear();
		S2.clear();
		System.out.println("Create identical sets except the last element in each will differ.");
		{ //Create two sets containing the the same elements except the final one.
		S1.add(5);
		S1.add(2);
		S1.add(7);
		S1.add(89);
		S1.add(5);
		S1.add(55);
		S1.add(79);
		S1.add(59);
		}
		{
		S2.add(5);
		S2.add(2);
		S2.add(7);
		S2.add(99);
		S2.add(5);
		S2.add(55);
		S2.add(79);
		S2.add(59);
		}
		if (containsSameElements(S1, S2)) //Set contains the same elements
			System.out.println("The two sets contain the same elements.");
		else 
			System.out.println("The two sets do not contain the same elements.");
		S1.clear();
		S2.clear();
		System.out.println("Create two sets that have no identical elements.");
		{ //Create two sets that do not contain any identical elements.
		S1.add(5);
		S1.add(2);
		S1.add(7);
		S1.add(89);
		S1.add(5);
		S1.add(55);
		S1.add(79);
		S1.add(59);
		}
		{
		S2.add(58);
		S2.add(222);
		S2.add(73);
		S2.add(52);
		S2.add(1);
		S2.add(12);
		S2.add(88);
		S2.add(99);
		}
		if (containsSameElements(S1, S2)) //Set contains the same elements
			System.out.println("The two sets contain the same elements.");
		else 
			System.out.println("The two sets do not contain the same elements.");
		S1.clear();
		S2.clear();
		//Used to test the first if statement in containsSameElements
		System.out.print("Create two sets, S1 will have 5 elements identical to the "); 
		System.out.println("first 5 elements of S2, but S2 will contain 8 elements.");
		{ //Create two sets that do not contain any identical elements.
		S1.add(5);
		S1.add(2);
		S1.add(7);
		S1.add(89);
		S1.add(5);
		}
		{
		S2.add(5);
		S2.add(2);
		S2.add(7);
		S2.add(89);
		S2.add(5);
		S2.add(95);
		S2.add(92);
		S2.add(99);
		}
		if (containsSameElements(S1, S2)) //Set contains the same elements
			System.out.println("The two sets contain the same elements.");
		else 
			System.out.println("The two sets do not contain the same elements.");
	}
}
