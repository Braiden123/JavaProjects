/**
 * 	Assignment1, COMP268
 * Class: EmployeeSavingsTest.java
 * Purpose: To test the EmployeeSavings.java and AddressBook.java classes for accuracy in results and 
 * implementation.
 * 
 * @author Braiden Little
 * Student ID: 3364064
 * Date: September 10, 2018
 * Version 1.0
 * 
 * Based on: Introduction to Programming Using Java, Seventh Edition Version 7.0, August 2014 
 * (Version 7.0.2, with mostly typographical corrections, December 2016) Author:  David J. Eck  (eck@hws.edu)
 * http://math.hws.edu/javanotes/index.html
 *
 */
public class EmployeeSavingsTest {

	public static void main(String[] args) {
		
		EmployeeSavings[] allAccounts; //Declare the array for all users
		allAccounts = new EmployeeSavings[15]; //Create the array for 15 users
		allAccounts[0] = new EmployeeSavings("Elena", "Brandon"); //Constructor for user 1 with no monthly savings or interests input.
		allAccounts[1] = new EmployeeSavings("Thomas", "Molson"); //Constructor for user 2 with no monthly savings or interests input.
		allAccounts[2] = new EmployeeSavings("Hamilton", "Winn"); //Constructor for user 3 with no monthly savings or interests input.
		allAccounts[3] = new EmployeeSavings("Suzie", "Sarandin"); //Constructor for user 4 with no monthly savings or interests input.
		allAccounts[4] = new EmployeeSavings("Philip", "Winne"); //Constructor for user 5 with no monthly savings or interests input.
		allAccounts[5] = new EmployeeSavings("Alex", "Trebok"); //Constructor for user 6 with no monthly savings or interests input.
		allAccounts[6] = new EmployeeSavings("Emma", "Pivoto"); //Constructor for user 7 with no monthly savings or interests input.
		allAccounts[7] = new EmployeeSavings("John", "Lenthen"); //Constructor for user 8 with no monthly savings or interests input.
		allAccounts[8] = new EmployeeSavings("James", "Lean", 157, 10); //Constructor for user 9 with monthly savings and interests input.
		allAccounts[9] = new EmployeeSavings("Jane", "Ostin", 50, 7); //Constructor for user 10 with monthly savings and interests input.
		allAccounts[10] = new EmployeeSavings("Emily", "Car", 78, 50); //Constructor for user 11 with monthly savings and interests input.
		allAccounts[11] = new EmployeeSavings("Daniel", "Hamshire", 880, 90); //Constructor for user 12 with monthly savings and interests input.
		allAccounts[12] = new EmployeeSavings("Neda", "Bazdar", 55, 5); //Constructor for user 13 with monthly savings and interests input.
		allAccounts[13] = new EmployeeSavings("Aaron", "Smith", 500, 15); //Constructor for user 14 with monthly savings and interests input.
		allAccounts[14] = new EmployeeSavings("Kate", "Hen", 700, 89); //Constructor for user 15 with monthly savings and interests input.
		
		for (int i = 0; i <= 7; i++) { //Go through the first 8 users
			allAccounts[i].generateMonthlySavings(); //Generate their monthly savings between $100 to $800
			allAccounts[i].calculateInterests(); //Calculate the interest earned for each month.
		}
		
		String report = EmployeeSavings.getReport(allAccounts); //Generate the report for everyones name and account value.
		System.out.print(report); //Print the report.

	}

}
