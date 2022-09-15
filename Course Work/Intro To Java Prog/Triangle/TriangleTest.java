/**
 * 	Assignment1, COMP268
 * Class: TriangleTest.java
 * Purpose: Program will find the length of the missing side of 2 triangles when given 2 sides then display the result.
 * Then the program will take all three of the lengths of 2 more triangles then test to see if they are right angled triangles.
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
public class TriangleTest {

	public static void main(String[] args) {
		
		Triangle triangle1 = new Triangle(48, 80); //Triangle represented in part I)a.
		Triangle triangle2 = new Triangle(84, 91); //Triangle represented in part I)b.
		Triangle triangle3 = new Triangle(45, 55, 75); //Triangle represented in part II)a.
		Triangle triangle4 = new Triangle(28, 45, 53); //Triangle represented in part II)b.
		
		System.out.println("The sides of triangle 1 are :");
		System.out.printf("A = %1.2f%n", triangle1.getA());
		System.out.printf("C = %1.2f%n", triangle1.getC());
		System.out.printf("And the missing side B is :%1.2f%n", triangle1.findMissingSide()); //calculate the missing side of triangle 2
		System.out.println("The sides of triangle 2 are :");
		System.out.printf("A = %1.2f%n", triangle2.getA());
		System.out.printf("C = %1.2f%n", triangle2.getC());
		System.out.printf("And the missing side B is :%1.2f%n", triangle2.findMissingSide()); //calculate the missing side of triangle 2
		if (triangle3.isRightTriangle()) //test for triangle 3 is a right angle triangle.
			System.out.println("Triangle 3 is a right angle triangle.");
		else //test for triangle 3 returns false, not a right triangle
			System.out.println("Triangle 3 is not a right triangle.");
		
		if (triangle4.isRightTriangle()) //test for triangle 4 is a right angle triangle.
			System.out.println("Triangle 4 is a right angle triangle.");
		else //test for triangle 3 returns false, not a right triangle
			System.out.println("Triangle 4 is not a right angle triangle.");

	}

}
