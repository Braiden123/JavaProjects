/**
 * Assignment2, COMP268 Class: Person.java Purpose: To record a persons name,
 * weight, height, BMI and weight category Program can also determine weight
 * category when given the BMI.
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
public class Person {

	private double bmi;
	private double height;
	private double weight;
	private String category;
	private String name;

	/**
	 * Constructor method for the Person class given name weight and height.
	 * 
	 * @param name   Persons name
	 * @param weight Persons Weight in pounds
	 * @param height Persons height in inches.
	 */
	public Person(String name, double weight, double height) {
		this.name = name;
		this.weight = weight;
		this.height = height;
	}

	/**
	 * Getter method to return the current persons BMI
	 * 
	 * @return
	 */
	public double getBMI() {
		return bmi;
	}

	/**
	 * Getter method to return the current persons height in inches
	 * 
	 * @return
	 */
	public double getHeight() {
		return height;
	}

	/**
	 * Getter method to return the current persons weight in pounds
	 * 
	 * @return
	 */
	public double getWeight() {
		return weight;
	}

	/**
	 * Method used to determine a persons weight category returned as a string,
	 * given their current BMI
	 * 
	 * @param bmi Persons current BMI
	 * @return Persons weight category
	 */
	public String getCategory(double bmi) {
		if (bmi < 18.5) // Persons BMI falls in the underweight category
			this.category = "Underweight";
		else if (bmi >= 18.5 && bmi < 25) // Persons BMI falls in the normal weight category
			this.category = "Normal weight";
		else if (bmi >= 25 && bmi < 30) // Persons BMI falls in the overweight category
			this.category = "Overweight";
		else if (bmi >= 30) // Persons BMI falls into the obese category
			this.category = "Obese";
		return this.category;
	}

	/**
	 * Getter method to return the current persons weight category.
	 * 
	 * @return Persons current weight Category.
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * Getter method to return the current persons name.
	 * 
	 * @return Persons current name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter method to change the persons BMI
	 * 
	 * @param bmi Persons new BMI.
	 */
	public void setBMI(double bmi) {
		this.bmi = bmi;
	}

	/**
	 * Setter method to change the persons height
	 * 
	 * @param height Persons new height in inches
	 */
	public void setHeight(double height) {
		this.height = height;
	}

	/**
	 * Setter method to change the persons name
	 * 
	 * @param name Persons new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Setter method to change the persons weight
	 * 
	 * @param weight Persons new weight in pounds
	 */
	public void setWeight(double weight) {
		this.weight = weight;
	}

}
