import java.util.ArrayList;

/**
 * 	Assignment1, COMP268
 * Class: AddressBook.java
 * Purpose: Goes through the numbers from 0 to 113, print each number on a line,
 * followed by another statement(s) if applicable.
 * If the number is odd, print "x is odd"
 * If the number is divisible by 5, print"hi five"
 * If the total of a number (x) and its subsequent number (x+1) is a value divisible by 7, print “wow”
 * If the number is prime, print “prime”.
 * 
 * @author Braiden Little
 * Student ID: 3364064
 * Date: September 7, 2018
 * Version 1.0
 * 
 * Based on: Introduction to Programming Using Java, Seventh Edition Version 7.0, August 2014 
 * (Version 7.0.2, with mostly typographical corrections, December 2016) Author:  David J. Eck  (eck@hws.edu)
 * http://math.hws.edu/javanotes/index.html
 *
 */
public class Number {

	public static void main(String[] args) {
		
		ArrayList<String> iterationList = new ArrayList<String>();
		
		for (int i = 0; i <= 113;  i++) { //Go through numbers 0-113 print each number out and it's applicable statements.
			iterationList = iterate(i);
			System.out.println(i + iterationList.toString());


				

		}

	}
	
	/**
	 * Method used to create an ArrayList of strings to print.
	 * @return ArrayList of strings
	 */
	public static ArrayList<String> iterate(int n) {
		ArrayList<String> iterationList = new ArrayList<String>();
		
		if (isOdd(n)) //number is odd add " is odd" to the ArrayList.
			iterationList.add(" is odd");
		if (isDivisibleBy5(n)) //number is divisible by 5 add " hi five" to the ArrayList.
			iterationList.add(" hi five");
		if (isDivisibleBy7(n)) //number and it's subsequent number is divisible by 7 add " wow" to the ArrayList.
			iterationList.add(" wow");
		if (isPrime(n)) //number is prime add "prime" to the ArrayList.
			iterationList.add(" prime.");
		return iterationList;

	}
		

	
	/**
	 * Test to see if the number is divisible by 5
	 * @param n The number to be tested
	 * @return True if the number is divisible by 5 false if not.
	 */
	public static boolean isDivisibleBy5(int n) {
		boolean divisibleBy5; //variable to tell if division by 5 is true
			
		if (n % 5 == 0) //Test to see if the number is divisible by 5
			divisibleBy5 = true; //Number is divisible by 5
		else
			divisibleBy5 = false; //Number is not divisible by 5
		return divisibleBy5;
	}
	
	/**
	 * Test to see if a number and that number plus 1 are both divisible by 7
	 * @param n Number to be tested
	 * @return True if n and n + 1 are divisible by 7, false otherwise.
	 */
	public static boolean isDivisibleBy7(int n) {
		boolean divisibleBy7; //variable to tell if division by 7 of both numbers is true.
		
		if (n % 7 == 0) { //Test to see if the number is divisible by 7
			if ((n + 1) % 7 == 0) //number is divisible by 7, test the number plus 1 if it is also divisible by 7
				divisibleBy7 = true; //Both numbers are divisible by 7
			else divisibleBy7 = false; //The number plus 1 was not divisible by 7
		}
		else
			divisibleBy7 = false; //Number is not divisible by 7
		
		return divisibleBy7;
	}
	
	/**
	 * Test to see if the number is odd.
	 * @param n Number to be tested
	 * @return True if the number is odd, false if even.
	 */
	public static boolean isOdd(int n) {
		boolean oddNumber; //variable to tell if the number is odd
		
		if (n % 2 == 1) //Test to see if the number is odd
			oddNumber = true; //Number is odd
		else
			oddNumber = false;//Number is not odd.
		return oddNumber;
	}
	
	/**
	 * Test to see if a given number is prime.
	 * @param n Number to be tested
	 * @return True if number is prime, false otherwise.
	 */
	public static boolean isPrime(int n) {
		boolean isPrimeNumber; //Variable to tell if the number is prime
		
		if (n == 0 || n == 1) { //Check if the number is 0 or 1
			isPrimeNumber = false; //Number is 0 or 1 these are not prime numbers.
			return isPrimeNumber;
		}
		
		for (int i = 2; i < n; i++) { //Test to see if the number is prime
			if (n % i == 0) {//Number has a even divisor that isn't one or itself.
				isPrimeNumber = false;
				return isPrimeNumber;
			}
		}
		isPrimeNumber = true; //n is a prime number.
		return isPrimeNumber;
	}
	
}
