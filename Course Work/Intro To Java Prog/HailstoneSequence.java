import java.util.ArrayList;
import java.util.Scanner;

/**
 * 	Assignment1, COMP268
 * Class: HailstoneSequence.java
 * Purpose: Program will take a number entered by the user and apply the hailstone sequence to it.
 * If a number is odd multiply it by 3 and add 1, if even divide by 2. Do this until the number is equal to 1.
 * Then display the results and the number of times the sequence had to be applied to finish the sequence.
 * 
 * @author Braiden Little
 * Student ID: 3364064
 * Date: September 4, 2018
 * Version 1.0
 * 
 * Based on: Introduction to Programming Using Java, Seventh Edition Version 7.0, August 2014 
 * (Version 7.0.2, with mostly typographical corrections, December 2016) Author:  David J. Eck  (eck@hws.edu)
 * http://math.hws.edu/javanotes/index.html
 *
 */
public class HailstoneSequence {

	public static void main(String[] args) {
		
		Scanner input = new Scanner( System.in); // Variable used to hold the input from the user.
		ArrayList<Integer> hailstoneSequence = new ArrayList<Integer>(); //ArrayList to hold the results of the Hailstone Sequence.
		int number; //Number to be entered by the user and apply the Hailstone Sequence.
		
		System.out.println("Please enter a positive whole number and the program will apply the Hailstone Sequence to it until it reaches 1.");
		number = input.nextInt(); //Get a number from the user to apply the hailstone sequence to.
		hailstoneSequence = getHailstoneSequence(number);
		System.out.println("The Hailstone Sequence for " + number + " is:");
		for (int i = 0; i <= hailstoneSequence.size() - 1; i++ ) { //Print out all the numbers in the hailstone sequence.
			System.out.println(hailstoneSequence.get(i));
		}
		System.out.println("The number of times that the sequence had to be applied was " + (hailstoneSequence.size() - 1) + " times.");

	}
	
	/**
	 * Take any integer and apply the hailstone sequence to it, dividing by 2 when even and 
	 * multiplying it by 3 and adding 1 when odd
	 * @param n The number to have the hailstone sequence applied to
	 * @return The list of all 
	 * @throws IllegalArgumentException The hailstone sequence cannot be applied to a negative number.
	 */
	public static ArrayList<Integer> getHailstoneSequence(int n) {
		
		if (n < 0) //Check if the number entered is negative
			throw new IllegalArgumentException("The hailstone sequence cannot be applied to a negative number."); //Hailstone sequence cannot be applied to a negative number, throw new IllegalArgumentException and end.
		
		ArrayList<Integer> sequenceList = new ArrayList<Integer>(); //Variable used to hold the ArrayList for the Hailstone Sequence and be returned to the main method.
		sequenceList.add(n); //Add the user's number to the start of the ArrayList.
		
		
		do {
			if (n % 2 == 1) { //Number is odd, multiply by 3 and add 1 to the number
				n = n * 3 + 1;
				sequenceList.add(n); //Add the number to the sequenceList.
			}
			
			if (n % 2 == 0) { //Number is even, divide by 2.
				n = n / 2;
				sequenceList.add(n); //Add the number to the sequenceList.
			}
		} while ( n != 1); //end the sequence when the number is 1
		
		return sequenceList;
	}

}
