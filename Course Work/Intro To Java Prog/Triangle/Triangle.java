/**
 * 	Assignment1, COMP268
 * Class: Triangle.java
 * Purpose: Class used to store the lengths of a triangle, calculate side b of the triangle 
 * and test to see if the Triangle is a right angled triangle or not.
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
public class Triangle {
	
	private double sideA, sideB, sideC; //Sides of the triangle, sideC is the hypotenuse.
	private boolean rightTriangle; //variable to hold the result of the isRightAngle test.
	
	/**
	 * Constructor for a triangle give only 2 sides with one of them
	 * being the hypotenuse.
	 * @param a Side a of the triangle
	 * @param c Side c of the triangle / hypotenuse
	 */
	Triangle(double a, double c) {
		this.sideA = a;
		this.sideC = c;
	}
	
	/**
	 * Constructor for a triangle given all three sides.
	 * @param a Side a of a triangle
	 * @param b Side b of a triangle
	 * @param c Side c of a triangle / hypotenuse
	 */
	Triangle(double a, double b, double c) { /*Constructor for TriangleTest objects
												Provides sides for the Triangle.class */
		this.sideA = a;
		this.sideB = b;
		this.sideC = c;
	}
	
	/**
	 * When called will return the length of side A
	 * @return Side A
	 */
	public double getA() {
		return sideA;
	}
	
	/**
	 * When called will return the length of side B
	 * @return Side B
	 */
	public double getB() {
		return sideB;
	}
	
	/**
	 * When called will return the length of side C
	 * @return Side C
	 */
	public double getC() {
		return sideC;
	}
	
	/**
	 * Tests to see if the triangle is a right angle given the sides.
	 * @return Whether the triangle is a right angle(true) or not(false).
	 */
	public boolean isRightTriangle() {
		
		if ((Math.pow(sideA, 2) + Math.pow(sideB, 2)) == Math.pow(sideC, 2)) { //check to see if the triangle is a right angle triangle using pythagorean theorem.
			rightTriangle = true;
			return rightTriangle;
		}
		
		else { //if not a right angle triangle then return false.
			rightTriangle = false;
			return rightTriangle;
		}
	}
	
	/**
	 * Given the hypotenuse of the triangle find the length of the missing side.
	 * @return SideB the missing side.
	 */
	public double findMissingSide() {
		sideB = Math.sqrt((Math.pow(sideC, 2)) - (Math.pow(sideA, 2))); //Calculate the missing side using pythagorean theorem
		return sideB;
	}
}
