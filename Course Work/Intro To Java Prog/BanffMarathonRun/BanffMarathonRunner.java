/**
 * 	Assignment1, COMP268
 * Class: BanffMarathonRunner.java
 * Purpose: To extend the AddressBook class to store runners times and years of participation.
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
public class BanffMarathonRunner extends AddressBook{
	
	private int time; //Recorded run time of the runner.
	private int years; //Years the runner has been participating.
	
	/**
	 * Constructor for objects BanffMarathonRunner will call AddressBook constructor given first name.
	 * @param fn First name given for the constructor
	 * @param ln Last name given for the constructor
	 * @param min Time in minutes that the runner finished the run.
	 * @param yr Years the runner has participated in the run.
	 */
	public BanffMarathonRunner(String fn, String ln, int min, int yr) {
		super(fn); //Call the constructor for AddressBook with parameter of first name.
		this.setFirstName(fn); //set the First name for the runner.
		this.setLastName(ln); //set the Last name for the runner.
		this.time = min; //set the run time in minutes for runner.
		this.years = yr; //set the years of participation for the runner.
	}
	
	/**
	 * Get the time of the runner in minutes.
	 * @return Time in minutes.
	 */
	public int getTime() {
		return time;
	}
	
	/**
	 * Get the years the runner has participated.
	 * @return Years of participation.
	 */
	public int getYears() {
		return years;
	}
	
	/**
	 * Set the time of the runner, in minutes.
	 * @param time The new time for the runner in minutes.
	 */
	public void setTime(int time) {
		this.time = time;
	}
	
	/**
	 * Set the years of participation for the runner.
	 * @param years Years the runner has participated in the race.
	 */
	public void setYears(int years) {
		this.years = years;
	}
	
	/**
	 * Function to find the fastest runner in the group.
	 * @param runners List of runners to be checked
	 * @return The fastest runner in the list.
	 */
	public static BanffMarathonRunner getFastestRunner(BanffMarathonRunner[] runners) {
		BanffMarathonRunner fastestRunner; //The fastest runner to be returned.
		fastestRunner = runners[0]; //First person checked will be the fastest runner so far.
		
		for (int i = 1; i <= runners.length - 1; i++) { // Go through the list of runners.
			if (runners[i].getTime() < fastestRunner.getTime()) //Check if current runner is faster than the fastest so far.
				fastestRunner = runners[i]; //Current runner was faster, current runner is now listed as the fastest.
		}
		return fastestRunner;
		
	}
	
	/**
	 * Function to find the second fastest runner in the group
	 * @param runners List of runners to be checked.
	 * @return The second fastest runner in the list.
	 */
	public static BanffMarathonRunner getSecondFastestRunner(BanffMarathonRunner[] runners) {
		
		BanffMarathonRunner fastestRunner; //The fastest runner.
		BanffMarathonRunner secondFastestRunner; //The second fastest runner to be returned.
		fastestRunner = runners[0]; //First person checked will be the fastest runner so far.
		secondFastestRunner = runners[0]; //First person will also be the second fastest runner so far.
		
		for (int i = 0; i <= runners.length - 1; i++) { //Go through the list of runners.
			if (runners[i].getTime() < fastestRunner.getTime()) { //Check if the current runner is faster than the fastest so far.
				secondFastestRunner = fastestRunner; /*Current runner is faster than the fastest runner, the former fastest runner is now
													the second fastest.*/
				fastestRunner = runners[i]; //Current runner was faster, current runner is now listed as the fastest.
			}
		}
		if (runners[runners.length - 1].getTime() < secondFastestRunner.getTime()) /*Check to see if the last person in the list is faster
																					than the current second fastest runner. It will not
																					be faster than the fastest as this was already checked
																					in the previous loop.*/
			secondFastestRunner = runners[runners.length - 1]; //The last person is the new second fastest runner.
		
		return secondFastestRunner; 
	}
	
	/**
	 * Function to calculate the fastest time between all the runners.
	 * @param runners List of all the runners.
	 * @return Average time taken between all the runners.
	 */
	public static double getAverageTime(BanffMarathonRunner[] runners) {
		
		double averageTime; //Average time between all runners to be returned.
		double sumOfTimes = 0; //Sum of all runners time.
		
		for (int i = 0; i <= runners.length - 1; i++) { //Go through the list of runners.
			sumOfTimes += runners[i].getTime(); //Add all the times of each runner to the sum.
		}
		averageTime = sumOfTimes / runners.length; //Divide the total time of all runners by the number of runners.
		return averageTime;
	}
	
	/**
	 * Function that calls the getAverageTime function and then finds all the runners that
	 * had a faster than average time then prints their first and last names as well as 
	 * the number of years they have been participating in the race.
	 * @param runners List of runners to be checked.
	 * @return String that lists all the runner's names and the number of years they participated.
	 */
	public static String getAboveAverageRunners(BanffMarathonRunner[] runners) {
		
		String aboveAverageRunners = ""; // List of all runner's names and their years of participation to be returned.
		double averageTime = getAverageTime(runners); //Average time of all runners.
		
		for (int i = 0; i <= runners.length - 1; i++) { //Go through the list of all runners.
			if (runners[i].getTime() <= averageTime) // Check if the runners time was faster than the average.
				aboveAverageRunners += runners[i].getFirstName() + " " + runners[i].getLastName() + ": (Years:" + runners[i].getYears() + ") "; /*Current Runner was faster than the average 
																																			record their name and years of participation.*/
		}
		
		return aboveAverageRunners;
	}
}
