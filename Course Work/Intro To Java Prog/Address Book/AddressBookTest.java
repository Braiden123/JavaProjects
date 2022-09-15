/**
 * 	Assignment1, COMP268
 * Class: AddressBookTest.java
 * Purpose: To use a main method to test the AddressBook.java class for correct, partially correct and incorrect inputs.
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
public class AddressBookTest {

	public static void main(String[] args) {
		AddressBook person1 = new AddressBook("John", "Smith", "Doe", "123 Main street", "8888888888", "7777777777", "9999999999", "John123", "123456", "www.example1.com"); //AddressBook object to test with all correct inputs.
		AddressBook person2 = new AddressBook("Jane"); //AddressBook object to test the second constructor(just first name) with correct input.
		AddressBook person3 = new AddressBook("Smith", "Bob"); //AddressBook object to test the third constructor(first and middle names) with correct input.
		AddressBook person4 = new AddressBook("Sam", "Ian", "Smith"); //AddressBook object to test the final constructor(first, middle and last names) with correct input.
		
		System.out.println("Person 1's full name, cell phone number, and personal website: "); //Test for getter methods.
		System.out.println("Name: " + person1.getFirstName() + " " + person1.getMiddleName() + " " + person1.getLastName() + ", CellPhone number: " + person1.getCellPhone() + ", Website: " + person1.getPersonalWebsite());
		System.out.println();
		person2.setLastName("Doe"); //Testing setter methods in AddressBook
		person2.setSkypeId("Jane888");
		person2.setHomeAddress("444 Fake Street");
		System.out.println(person2.getFirstName() + "'s last name is " + person2.getLastName() + " his/her Skype ID is " + person2.getSkypeId() + " and their home address is " + person2.getHomeAddress() + "."); //Testing to see if setter methods worked.
		System.out.println();
		System.out.println("Person 3's first and middle name is " + person3.getFirstName() + " " + person3.getMiddleName() + "."); //Testing to see if the third constructor worked.
		System.out.println();
		System.out.println("Person 4's full name is " + person4.getFirstName() + " " + person4.getMiddleName() + " " + person4.getLastName() + "."); //Testing to see if the forth constructor worked.
		person2.setBusinessPhone("888888888a"); //Test when entered phone number contains a non numeric character, should throw new NumberFormatException.
		person2.setHomePhone("12345678900"); //Test when phone number length is greater than 10 characters, should throw new IllegalFormatException.

	}

}
