/**
 * 	Assignment1, COMP268
 * Class: EmployeeSavings.java
 * Purpose: To extend the AddressBook class and use it to record the savings of employees. 
 * The program will also simulate the employees adding a number between 100 to 800 dollars to 
 * their savings account and will also calculate interest for each month then display
 * the final value of their account after 1 year.
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
public class EmployeeSavings extends AddressBook{
	
	private double accountValue;
	private double[] monthlyInterests = new double[12];
	private double[] monthlySavings = new double[12];
	public static final double ANNUAL_INTEREST_RATE = 0.05;
	
	/**
	 * Constructor for EmployeeSavings objects given a first and last name.
	 * @param fn First name
	 * @param ln Last name
	 */
	public EmployeeSavings(String fn, String ln) {
		super(fn); //Call the Constructor from AddressBook
		this.setFirstName(fn); //Set the first name
		this.setLastName(ln); //Set the last name
	}
	
	/**
	 * Constructor for EmployeeSavings objects given a first and last name as
	 * well as the monthly savings interests values.
	 * @param fn First name
	 * @param ln Last name
	 * @param d1 Monthly Savings
	 * @param d2 Monthly Interests
	 */
	public EmployeeSavings(String fn, String ln, double d1, double d2) {
		super(fn); //Call the constructor from AddressBook
		this.setFirstName(fn); //Set the first name
		this.setLastName(ln); //Set the last name
		
		for (int i = 0; i <= monthlySavings.length - 1; i++) { /*Fill the array of monthly savings
																with the value given by the parameter d1.*/
			monthlySavings[i] = d1;
			this.accountValue += monthlySavings[i]; //Add the value of the monthly saving to the account value
		}
		for (int i = 0; i <= monthlyInterests.length - 1; i++) { /*Fill the array of monthly interests
																	with the value given by the parameter d2.*/
			monthlyInterests[i] = d2;
			this.accountValue += monthlyInterests[i]; //Add the value of the monthly interests to the account value.
		}
	}
	
	/**
	 * Function to return the current account value.
	 * @return Current account value.
	 */
	public double getAccountValue() {
		accountValue = (double)Math.round(accountValue * 100d) / 100d; //Round the account value to 2 decimal places.
		return accountValue;
	}
	
	/**
	 * Function used to calculate the interest on the account value
	 * then list it as an array. Add the interest to the account value afterwards.
	 * Then return the amount of interest as each month as an array
	 * Requires that Monthly savings for each month has been entered.
	 * @return The amount of interest earned for each month as an array.
	 */
	public double[] calculateInterests() {
		double monthlyInterestRate = ANNUAL_INTEREST_RATE / 12; /*Calculate the monthly interest rate 
																	based on the annual interest rate*/
		double tempAccountValue = 0; //value used to hold the value of the account through each month.
		
		for (int i = 0; i <= monthlyInterests.length - 1; i++) { //Go through each month and calculate the interest.
			tempAccountValue += monthlySavings[i]; //add each months savings to the temporary account value to calculate interest.
			monthlyInterests[i] = tempAccountValue * monthlyInterestRate; //Add the interest earned to the array
			this.accountValue += monthlyInterests[i]; //Add the interest earned to the value of the account.
		}
		return monthlyInterests;
		
	}
	
	/**
	 * Function used to generate a random number between 100 and 800
	 * to deposit into the savings account each month.
	 * Increase the account value based on the deposit amount.
	 * @return array giving how much money was deposited each month.
	 */
	public double[] generateMonthlySavings() {
		
		for (int i = 0; i <= monthlySavings.length - 1; i++) { //Go through each month and generate an amount to deposit.
			monthlySavings[i] = (int) (Math.random() * 700) + 100;
			this.accountValue += monthlySavings[i]; //Add the deposit to the account value.
		}
		return monthlySavings;
	}
	
	/**
	 * Function to get the month savings array for an individual.
	 * @return Array for the savings deposited each month.
	 */
	public double[] getMonthlySavings() {
		return monthlySavings;
	}
	
	/**
	 * Function to get the monthly interests array for an individual.
	 * @return Array for the interests earned each month.
	 */
	public double[] getMonthlyInterests() {
		return monthlyInterests;
	}
	
	/**
	 * Function to attach the first and last names as well as their
	 * account value to a string from an array of EmployeeSavings.
	 * Each person will be printed on a new line.
	 * @param arr Array of EmployeeSavings
	 * @return String with all first name, last name and account value of 
	 * everyone in the array list.
	 */
	public static String getReport(EmployeeSavings[] arr) {
		String report = "First Name:LastName:	Account Value:"; //Set a header for the report
		
		for (int i = 0; i <= arr.length - 1; i++) { //Go through each individuals name and account value then add it to the string on a new line.
			report += "\n" + arr[i].getFirstName() + "	" + arr[i].getLastName() + "		$" + arr[i].getAccountValue();
		}
		return report;
	}

}
