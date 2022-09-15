/**
 * 	Assignment1, COMP268
 * Class: BonusOnSavings.java
 * Purpose: Takes the monthly commitment from an employee then will apply bonuses to the employee based on their quarterly and annual savings
 * with the possibility of the Company matching some annual savings if certain conditions are met.
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
public class BonusOnSavings {

	public static void main(String[] args) {
		
		double employeeBonus; //Total employee bonus calculated.
		double empl1Commit = 2000; //Employee 1 monthly commitment
		double empl1Q1 = 5000; // Q1 savings for employee 1
		double empl1Q2 = 7000; // Q2 savings for employee 1
		double empl1Q3 = 4000; // Q3 savings for employee 1
		double empl1Q4 = 8000; // Q4 savings for employee 1
		double empl2Commit = 3000; //Employee 2 monthly commitment.
		double empl2Q1 = 6000; // Q1 savings for employee 2
		double empl2Q2 = 9000; // Q2 savings for employee 2
		double empl2Q3 = 10000; // Q3 savings for employee 2
		double empl2Q4 = 17000; // Q4 savings for employee 2
		
		employeeBonus = computeBonus(empl1Commit, empl1Q1, empl1Q2, empl1Q3, empl1Q4);
		System.out.println("Employee 1 commited to save " + empl1Commit + " dollars per month.");
		System.out.println("Employee 1 saved: ");
		System.out.println("Q1: " + empl1Q1);
		System.out.println("Q2: " + empl1Q2);
		System.out.println("Q3: " + empl1Q3);
		System.out.println("Q4: " + empl1Q4);
		System.out.println("Employee 1 earned a bonus of " + employeeBonus);
		
		employeeBonus = computeBonus(empl2Commit, empl2Q1, empl2Q2, empl2Q3, empl2Q4);
		System.out.println("Employee 2 commited to save " + empl2Commit + " dollars per month.");
		System.out.println("Employee 2 saved: ");
		System.out.println("Q1: " + empl2Q1);
		System.out.println("Q2: " + empl2Q2);
		System.out.println("Q3: " + empl2Q3);
		System.out.println("Q4: " + empl2Q4);
		System.out.println("Employee 2 earned a bonus of " + employeeBonus);
		
	}

	/**
	 * Takes the employees commitment as well as each of their quarterly savings
	 * then computes the end bonus to be paid to be paid to the employee.
	 * @param commitment Monthly commitment by employee to save per month.
	 * @param q1 Quarter 1 savings from employee
	 * @param q2 Quarter 2 savings from employee
	 * @param q3 Quarter 3 savings from employee
	 * @param q4 Quarter 4 savings from employee
	 * @return
	 */
	public static double computeBonus(double commitment, double q1, double q2, double q3, double q4) {
		
		double employeeBonus = 0; //Total bonus the employee earns, returned by the method
		double annualSavings = q1 + q2 + q3 + q4; // Total savings by the employee over 1 year.
		double companyMatch; // Amount Space Inc. will match for savings if total saved is greater than 25%
		double annualCommit = commitment * 12; //Total amount the employee committed to save over 1 year.
		
		if (q1 >= commitment * 3) // Adds 3% bonus of the quarters savings if savings were greater than or equal to 3 times the monthly commitment.
			employeeBonus += (q1 * 0.03);
		
		if (q2 >= commitment * 3) // Adds 3% bonus of the quarters savings if savings were greater than or equal to 3 times the monthly commitment.
			employeeBonus += (q2 * 0.03);
		
		if (q3 >= commitment * 3) // Adds 3% bonus of the quarters savings if savings were greater than or equal to 3 times the monthly commitment.
			employeeBonus += (q3 * 0.03);
		
		if (q4 >= commitment * 3) // Adds 3% bonus of the quarters savings if savings were greater than or equal to 3 times the monthly commitment.
			employeeBonus += (q4 * 0.03);
		
		if (annualSavings >= annualCommit) //Adds 5% bonus of the annual savings if the savings were greater or equal to the monthly commitment.
			employeeBonus += (annualSavings * 0.05);
		
		if (annualSavings >= annualCommit * 1.25) { /* If the annual savings are greater than 25% of the commitment 
													the Company matches any annual savings over the 25% savings. */
			companyMatch = annualSavings - (annualCommit * 1.25);
			employeeBonus += companyMatch;
		}
		
		return employeeBonus; //Return the total employee bonus.
	}
}
