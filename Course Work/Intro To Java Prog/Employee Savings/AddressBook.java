/**
 * 	Assignment1, COMP268
 * Class: AddressBook.java
 * Purpose: To store information about an individual. First middle and last names, home cell and business phone numbers, Skype ID, FacebookID, and Personal Website.
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

public class AddressBook {
	private String businessPhone; //Persons Business phone number
	private String cellPhone; //Persons Cell phone number
	private String homeAddress; //Persons home address
	private String homePhone; //Persons home phone number
	private String firstName; //Persons first name
	private String middleName; // Persons middle name
	private String lastName; //Persons last name
	private String facebookId; //Persons FacebookID#
	private String personalWebsite; //Persons personal web site
	private String skypeId; //Persons Skype ID
	private long numberTest;//Used to test if the input contains only digits if the variable requires it.
	
	/**
	 * Create a new object of class AddressBook 
	 * assigning values to all available variables in the class.
	 * 
	 * @param fn First name assigned in the constructor
	 * @param mn Middle name assigned in the constructor
	 * @param ln Last name assigned in the constructor
	 * @param homeAddress home address assigned in the constructor
	 * @param businessPhone business phone number assigned in the constructor. Must contain only numeric characters and be 10 characters in length
	 * @param homePhone home phone number assigned in the constructor. Must contain only numeric characters and be 10 characters in length
	 * @param cellPhone cell phone number assigned in the constructor. Must contain only numeric characters and be 10 characters in length
	 * @param skypeId Skype ID assigned in the constructor.
	 * @param facebookId Facebook ID# assigned in the constructor. Must contain only numeric characters and be 10 characters in length
	 * @param personalWebSite personal web site assigned in the constructor.
	 */
	public AddressBook (String fn, String mn, String ln, String homeAddress, String businessPhone, String homePhone, String cellPhone, String skypeId, String facebookId, String personalWebSite) {
		this.firstName = fn;
		this.middleName = mn;
		this.lastName = ln;
		this.homeAddress = homeAddress;
		this.homePhone = homePhone;
		this.cellPhone = cellPhone;
		this.skypeId = skypeId;
		this.facebookId = facebookId;
		this.personalWebsite = personalWebSite;
		
		
		try { //Test if the new phone number contains any non numeric characters.
			numberTest = Long.parseLong(businessPhone); //Try to convert to an integer, if it cannot it is not a valid phone number.
		}
		catch ( NumberFormatException e) { //Number contains invalid characters print an error message to the user.
			System.out.println("Not a legal phone number. Please enter a phone number 10 digits in length and only contains digits 0-9.");
			throw new NumberFormatException();
		}
		
		if (businessPhone.length() != 10) { //test to see if the phone number is 10 characters in length.
			throw new IllegalArgumentException("Phone number must be 10 digits in length.");
		}
		this.businessPhone = businessPhone;
		
		try { //Test if the new phone number contains any non numeric characters.
			numberTest = Long.parseLong(homePhone);
		}
		catch ( NumberFormatException e) { //Number contains invalid characters print an error message to the user.
			System.out.println("Not a legal phone number. Please enter a phone number 10 digits in length and only contains digits 0-9.");
			throw new NumberFormatException();
		}
		
		if (homePhone.length() != 10) { //test to see if the phone number is 10 characters in length.
			throw new IllegalArgumentException("Phone number must be 10 digits in length.");
		}
		this.homePhone = homePhone;
		
		try { //Test if the new phone number contains any non numeric characters.
			numberTest = Long.parseLong(cellPhone);		
		}
		catch ( NumberFormatException e) { //Number contains invalid characters print an error message to the user.
			System.out.println("Not a legal phone number. Please enter a phone number 10 digits in length and only contains digits 0-9.");
			throw new NumberFormatException();
		}
		
		if (cellPhone.length() != 10) { //test to see if the phone number is 10 characters in length.
			throw new IllegalArgumentException("Phone number must be 10 digits in length.");
		}
		this.cellPhone = cellPhone;
	}
	
	/**
	 * Create a new object of class AddressBook
	 * assigning a value to firstName.
	 * @param fn First name assigned to the constructor.
	 */
	public AddressBook(String fn) {
		this.firstName = fn;
	}
	
	/**
	 * Create a new object of class AddressBook
	 * assigning values to firstName and middleName.
	 * @param fn First name assigned to the constructor
	 * @param mn Middle name assigned to the constructor 
	 */
	public AddressBook(String fn, String mn) {
		this.firstName = fn;
		this.middleName = mn;
	}
	
	/**
	 * Create a new object of class AddressBook
	 * assigning values to firstName, middleName and lastName.
	 * @param fn First name assigned to the constructor
	 * @param mn Middle name assigned to the constructor
	 * @param ln Last name assigned to the constructor.
	 */
	public AddressBook(String fn, String mn, String ln) {
		this.firstName = fn;
		this.middleName = mn;
		this.lastName = ln;
	}
	
	/**
	 * Compare 2 names to see if they are the same.
	 * return a string based on if they are the same or not.
	 * @param name1 The first name to be compared.
	 * @param name2 The second name to be compared.
	 * @return String saying if the names are the same or not.
	 */
	public static String compareNames(String name1, String name2) {
		String namesAreSame; //Variable to return to tell if the 2 names are the same or not.
		
		if (name1.equals(name2)) { //Tests to see if the two names are the same.
			namesAreSame = "Name 1 and Name 2 are the same."; //Test is true so the names are the same.
			return namesAreSame;
		}
		else { //Test failed so the names are not the same.
			namesAreSame = "Name 1 and Name 2 are different.";
			return namesAreSame;
		}	
	}
	
	/**
	 * Method returns the current persons Business Phone number.
	 * @return Persons current business phone number.
	 */
	public String getBusinessPhone() { //Returns the individuals business phone number.
		return businessPhone;
	}
	
	/**
	 * Method returns the current persons Cell Phone number.
	 * @return Persons current cell phone number.
	 */
	public String getCellPhone() { //Returns the individuals cell phone number.
		return cellPhone;
	}
	
	/**
	 * Method returns the current persons Home Phone number.
	 * @return Persons current home phone number.
	 */
	public String getHomePhone() { //Returns the individuals home phone number.
		return homePhone;
	}
	
	/**
	 * Method returns the current persons Facebook ID#.
	 * @return Persons current Facebook ID.
	 */
	public String getFacebookId() { //Returns the individuals Facebook ID.
		return facebookId;
	}
	
	/**
	 * Method returns the current persons first name.
	 * @return Persons current first name.
	 */
	public String getFirstName() { //Returns the individuals first name.
		return firstName;
	}
	
	/**
	 * Method returns the current persons last name.
	 * @return Persons current last name.
	 */
	public String getLastName() { //Returns the individuals last name.
		return lastName;
	}
	
	/**
	 * Method returns the current persons middle name.
	 * @return Persons current middle name.
	 */
	public String getMiddleName() { //Returns the individuals middle name.
		return middleName;
	}
	
	/**
	 * Method returns the current persons home address.
	 * @return Persons current home address.
	 */
	public String getHomeAddress() { //Returns the individuals home address.
		return homeAddress;
	}
	
	/**
	 * Method returns the current persons personal web site.
	 * @return Persons current personal web site.
	 */
	public String getPersonalWebsite() { //Returns the individuals personal website.
		return personalWebsite;
	}
	
	/**
	 * Method returns the current persons Skype ID.
	 * @return Persons current Skype ID.
	 */
	public String getSkypeId() { //Returns the individuals Skype ID.
		return skypeId;
	}
	
	/**
	 * Changes the current persons business phone number into a new phone number.
	 * @param newBusinessPhone The new phone number to be set and must be 10 characters in length and contain only numbers.
	 * @throws IllegalArgumentException if the length of the phone number is not 10 characters in length.
	 * @throws NumberFormatException if there is any non numeric characters in the phone number.
	 */
	public void setBusinessPhone(String newBusinessPhone) {
		
		if (newBusinessPhone.length() != 10) { //test to see if the phone number is 10 characters in length.
			throw new IllegalArgumentException("Phone number must be 10 digits in length.");
		}
		
		try { //Test if the new phone number contains any non numeric characters.
			numberTest = Long.parseLong(newBusinessPhone);
		}
		catch ( NumberFormatException e) { //Number contains invalid characters print an error message to the user.
			System.out.println("Not a legal phone number. Please enter a phone number 10 digits in length and only contains digits 0-9.");
			throw new NumberFormatException();
		}
		businessPhone = newBusinessPhone;
		
	}
	
	/**
	 * Changes the current persons cell phone number into a new phone number.
	 * @param newCellPhone The new phone number to be set and must be 10 characters in length and contain only numbers.
	 * @throws IllegalArgumentException if the length of the phone number is not 10 characters in length.
	 * @throws NumberFormatException if there is any non numeric characters in the phone number.
	 */
	public void setCellPhone(String newCellPhone) {
		
		if (newCellPhone.length() != 10) { //test to see if the phone number is 10 characters in length.
			throw new IllegalArgumentException("Phone number must be 10 digits in length.");
		}
		
		try { //Test if the new phone number contains any non numeric characters.
			numberTest = Long.parseLong(newCellPhone);			
		}
		catch ( NumberFormatException e) { //Number contains invalid characters print an error message to the user.
			System.out.println("Not a legal phone number. Please enter a phone number 10 digits in length and only contains digits 0-9.");
			throw new NumberFormatException();
		}
		cellPhone = newCellPhone;
		
	}
	
	/**
	 * Changes the current persons home phone number into a new phone number.
	 * @param newHomePhone The new phone number to be set and must be 10 characters in length and contain only numbers.
	 * @throws IllegalArgumentException if the length of the phone number is not 10 characters in length.
	 * @throws NumberFormatException if there is any non numeric characters in the phone number.
	 */
	public void setHomePhone(String newHomePhone) {
		
		if (newHomePhone.length() != 10) { //test to see if the phone number is 10 characters in length.
			throw new IllegalArgumentException("Phone number must be 10 digits in length.");
		}
		
		try { //Test if the new phone number contains any non numeric characters.
			numberTest = Long.parseLong(newHomePhone);			
		}
		catch ( NumberFormatException e) { //Number contains invalid characters print an error message to the user.
			System.out.println("Not a legal phone number. Please enter a phone number 10 digits in length and only contains digits 0-9.");
			throw new NumberFormatException();
		}
		homePhone = newHomePhone;
		
	}
	
	/**
	 * Changes the current persons Facebook ID# into a new one.
	 * @param newFacebookId The new Facebook ID# to be set for the individual's address book.
	 * @throws NumberFormatException if there is any non numeric characters in the new ID#
	 */
	public void setFacebookId(String newFacebookId) {
		
		try { //test if the new Facebook ID# contains any non numeric characters.
			numberTest = Long.parseLong(newFacebookId);
		}
		catch ( NumberFormatException e) { //Number contains invalid characters, print an error message to the user
			System.out.println("The new Facebook ID must contain only numerical characters 0-9.");
			throw new NumberFormatException();
		}
		facebookId = newFacebookId;
		
	}
	
	/**
	 * Changes current persons first name into a new one
	 * @param newFirstName The new first name to be set.
	 */
	public void setFirstName(String newFirstName) {
		firstName = newFirstName;
	}
	
	/**
	 * Changes current persons last name into a new one.
	 * @param newLastName The new last name to be set.
	 */
	public void setLastName(String newLastName) {
		lastName = newLastName;
	}
	
	/**
	 * Changes current persons middle name into a new one.
	 * @param newMiddleName The new middle name to be set.
	 */
	public void setMiddleName(String newMiddleName) {
		middleName = newMiddleName;
	}
	
	/**
	 * Changes current person home address into a new one.
	 * @param newHomeAddress The new home address to be set.
	 */
	public void setHomeAddress(String newHomeAddress) {
		homeAddress = newHomeAddress;
	}
	
	/**
	 * Changes current person home address into a new one.
	 * @param newPersonalWebsite The new web site to be set.
	 */
	public void setPersonalWebsite(String newPersonalWebsite) {
		personalWebsite = newPersonalWebsite;
	}
	
	/**
	 * Changes current persons Skype ID into a new one.
	 * @param newSkypeId The new Skype ID to be set.
	 */
	public void setSkypeId(String newSkypeId) {
		skypeId = newSkypeId;
	}
	
}
