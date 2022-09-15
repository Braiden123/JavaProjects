import java.util.Scanner;

/**
 * 	Assignment1, COMP268
 * Class: CartesianCoordinateSystem.java
 * Purpose: Program will prompt user in the main method for the x and y coordinates between 2 points.
 * The program will then calculate the distance between the 2 points, print the result, then end.
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
public class CartesianCoordinateSystem {

	public static void main(String[] args) {
		Scanner input = new Scanner( System.in); //Create the scanner for user input.
		
		double distance; //distance between the 2 points entered by the user.
		double x1, y1, x2, y2; //coordinates to be entered by the user.
		
		System.out.println("Please enter the points between 2 points then the program will calculate the distance between them.");
		System.out.println("Enter the x coordinate for the first point : ");
		x1 = input.nextDouble();
		System.out.println("Enter the y coordinate for the first point : ");
		y1 = input.nextDouble();
		System.out.println("Enter the x coordiante for the second point : ");
		x2 = input.nextDouble();
		System.out.println("Enter the y coordiante for the second point : ");
		y2 = input.nextDouble();

		distance = calculateDistance(x1, y1, x2, y2);
		
		System.out.printf("The distance between these 2 points is %1.2f points.", distance );
	}
	
	/**
	 * This method will take the coordinates for two different points then return the distance
	 * @param x1 X coordinate of point 1
	 * @param y1 Y coordinate of point 1
	 * @param x2 X coordinate of point 2
	 * @param y2 Y coordinate of point 2
	 * @return Distance between the 2 points.
	 */
	public static double calculateDistance(double x1, double y1, double x2, double y2) {
		
		double distance; //used to hold the distance calculation between the 2 points
		
		distance = (Math.pow((Math.pow((x2 - x1), 2) + (Math.pow((y2 - y1), 2))), 0.5)) ; //Calculate the distance.
		
		return distance; //return the distance between the 2 points.
		
	}

}
