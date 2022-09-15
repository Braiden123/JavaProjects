import java.util.ArrayList;

/**
 * Assignment2, COMP268 Class: PersonTest.java Purpose: To test the Person.java
 * class by putting 4 persons into an array then printing out all the
 * information stored in the object.
 * 
 * @author Braiden Little Student ID: 3364064 Date: September 11, 2018 Version
 *         1.0
 * 
 *         Based on: Introduction to Programming Using Java, Seventh Edition
 *         Version 7.0, August 2014 (Version 7.0.2, with mostly typographical
 *         corrections, December 2016) Author: David J. Eck (eck@hws.edu)
 *         http://math.hws.edu/javanotes/index.html
 *
 */
public class PersonTest {

	public static void main(String[] args) {
		ArrayList<Person> peopleList = new ArrayList<Person>(); // Create new peopleList ArrayList to store all the
																// person objects
		Person person1 = new Person("Andrew", 125.5, 55.1); // Person1 constructor
		Person person2 = new Person("Boyd", 150, 67); // Person2 constructor
		Person person3 = new Person("Cathy", 135, 72.3); // Person 3 constructor
		Person person4 = new Person("Donna", 190, 64); // Person 4 constructor
		person1.setBMI(29.06); // Set person 1's BMI
		person2.setBMI(23.49); // Set person 2's BMI
		person3.setBMI(18.16); // Set person 3's BMI
		person4.setBMI(32.60); // Set person 4's BMI
		peopleList.add(person1); // Add Person 1 to the peopleList ArrayList
		peopleList.add(person2); // Add Person 2 to the peopleList ArrayList
		peopleList.add(person3); // Add Person 3 to the peopleList ArrayList
		peopleList.add(person4); // Add Person 4 to the peopleList ArrayList
		for (int i = 0; i <= peopleList.size() - 1; i++) { // Go through each person in peopleList and print out
															// information such as name, weight, height, BMI and weight
															// category.
			System.out.println(peopleList.get(i).getName() + " weighs " + peopleList.get(i).getWeight()
					+ " pounds and is " + peopleList.get(i).getHeight() + " inches tall, and their BMI is "
					+ peopleList.get(i).getBMI() + " they are "
					+ peopleList.get(i).getCategory(peopleList.get(i).getBMI()) + ".");
		}
	}
}
