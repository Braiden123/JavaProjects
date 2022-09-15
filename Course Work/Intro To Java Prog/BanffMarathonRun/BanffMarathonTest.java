import java.util.ArrayList;
/**
 * 	Assignment1, COMP268
 * Class: BanffMarathonTest.java
 * Purpose: To use the BanffMarathonRunner.java and AddressBook.java classes
 * with other methods to find the fastest and second fastest runners, give their
 * names, addresses and times.Calculate the difference in time between the fastest
 * and the second fastest runners. Calculate the average time of all runners and 
 * print the runner's years of participation if they had a faster than average time.
 * 
 * @author Braiden Little
 * Student ID: 3364064
 * Date: September 6, 2018
 * Version 1.0
 * 
 * Based on: Introduction to Programming Using Java, Seventh Edition Version 7.0, August 2014 
 * (Version 7.0.2, with mostly typographical corrections, December 2016) Author:  David J. Eck  (eck@hws.edu)
 * http://math.hws.edu/javanotes/index.html
 *
 */
public class BanffMarathonTest {

	public static void main(String[] args) {
		
		BanffMarathonRunner[] listOfRunners;
		listOfRunners = new BanffMarathonRunner[15];
		listOfRunners[0] = new BanffMarathonRunner("Elena", "Brandon", 341, 1);
		listOfRunners[1] = new BanffMarathonRunner("Thomas", "Molson", 273, 2);
		listOfRunners[2] = new BanffMarathonRunner("Hamilton", "Winn", 278, 5);
		listOfRunners[3] = new BanffMarathonRunner("Suzie", "Sarandin", 329, 7);
		listOfRunners[4] = new BanffMarathonRunner("Philip", "Winne", 445, 9);
		listOfRunners[5] = new BanffMarathonRunner("Alex", "Trebok", 275, 3);
		listOfRunners[6] = new BanffMarathonRunner("Emma", "Pivoto", 275, 4);
		listOfRunners[7] = new BanffMarathonRunner("John", "Lenthen", 243, 1);
		listOfRunners[8] = new BanffMarathonRunner("James", "Lean", 334, 1);
		listOfRunners[9] = new BanffMarathonRunner("Jane", "Ostin", 412, 1);
		listOfRunners[10] = new BanffMarathonRunner("Emily", "Car", 393, 4);
		listOfRunners[11] = new BanffMarathonRunner("Daniel", "Hamshire", 299, 4);
		listOfRunners[12] = new BanffMarathonRunner("Neda", "Bazdar", 343, 3);
		listOfRunners[13] = new BanffMarathonRunner("Aaron", "Smith", 317, 6);
		listOfRunners[14] = new BanffMarathonRunner("Kate", "Hen", 265, 8);
		BanffMarathonRunner fastestRunner = BanffMarathonRunner.getFastestRunner(listOfRunners);
		BanffMarathonRunner secondFastestRunner = BanffMarathonRunner.getSecondFastestRunner(listOfRunners);
		double averageTime = BanffMarathonRunner.getAverageTime(listOfRunners);
		String getAboveAverageRunner = BanffMarathonRunner.getAboveAverageRunners(listOfRunners);
		
		System.out.println("The fastest runner was " + fastestRunner.getFirstName() + " " + fastestRunner.getLastName() + ".");
		fastestRunner.setHomeAddress("123 Main Street");
		System.out.println("Their address is " + fastestRunner.getHomeAddress() + ".");
		System.out.println("With a time of " + fastestRunner.getTime() + " minutes.");
		System.out.println();
		System.out.println("The second fastest runner was " + secondFastestRunner.getFirstName() + " " + secondFastestRunner.getLastName() + ".");
		secondFastestRunner.setHomeAddress("566 Fake Street");
		System.out.println("Their address is " + secondFastestRunner.getHomeAddress() + ".");
		System.out.println("Their time was " + secondFastestRunner.getTime() + " minutes.");
		System.out.println("The difference between the two runners was " + (secondFastestRunner.getTime() - fastestRunner.getTime() ) + " minutes.");
		System.out.printf("The average time between all runners was %1.2f minutes.", averageTime);
		System.out.println("The following list is the names of all runners that were above the average time and the number of years they have participated. ");
		System.out.println(getAboveAverageRunner);
		

	}
	
}
