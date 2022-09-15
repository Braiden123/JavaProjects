import java.util.ArrayList;

/**
 * 	Assignment1, COMP268
 * Class: Candidate.java
 * Purpose: To extend the AddressBook class and use it to record the criteria of the individuals(candidates)
 * such as communication ability, bachelor grades, innovation, and ability to self regulate.
 * This class will also be able to take a list of potential candidates then provide a list of eligible candidates.
 * 
 * @author Braiden Little
 * Student ID: 3364064
 * Date: September 10, 2018
 * Version 1.0
 * 
 * Based on: Introduction to Programming Using Java, Seventh Edition Version 7.0, August 2014 
 * (Version 7.0.2, with mostly typographical corrections, December 2016) Author:  David J. Eck  (eck@hws.edu)
 * http://math.hws.edu/javanotes/index.html
 *
 */
public class Candidate extends AddressBook{
	private boolean innovation;
	private double grade;
	private double regulation;
	private String communication;
	
	/**
	 * Constructor for the Candidate class.
	 * @param fn First Name
	 * @param ln Last Name
	 * @param grade Candidates final marks Can range from 00.00% to 100.00%
	 * @param comm Ability to communicate Either excellent, average or poor.
	 * @param innov Innovation either brilliant(true) or average(false)
	 * @param reg Ability to regulate one's own skill as a probability value between 0.0(no regulatory skills) to 1.0(excellent skill)
	 */
	public Candidate( String fn, String ln, double grade, String comm, boolean innov, double reg) {
		super(fn); //Call on the Address Book constructor given a first name.
		this.setFirstName(fn); //Candidates first name
		this.setLastName(ln); //Candidates last name
		this.communication = comm; //Candidates communication skill
		this.grade = grade; //Candidates final grade for bachelors
		this.innovation = innov; //Candidates innovation either brilliant or average.
		this.regulation = reg; //Candidates ability to regulate ones own skill.
	}
	
	/**
	 * Used to tell if the Candidate is brilliant or average innovation
	 * @return True if brilliant false if average.
	 */
	public boolean isInnovative() {
		return innovation;
	}
	
	/**
	 * Used to tell the Candidates Grade.
	 * @return Grade on a score of 0.00% to 100.00%
	 */
	public double getGrade() {
		return grade;
	}
	
	/**
	 * Used to tell the Candidates ability to self regulate their own skill.
	 * @return Ability to regulate ones own skill from 0.0  lowest to 1.0 highest.
	 */
	public double getRegulation() {
		return regulation;
	}
	
	/**
	 * Used to tell the Candidates communication skills.
	 * @return Ability to communicate, either excellent, average, or poor.
	 */
	public String getCommunication() {
		return communication;
	}
	
	/**
	 * Used to set a Candidates communication skills.
	 * @param comm Communication skill as either excellent, average, or poor.
	 */
	public void setCommunication(String comm) {
		this.communication = comm;
	}
	
	/**
	 * Used to set a Candidates final grade
	 * @param grade Grade achieved on Candidate's Bachelor
	 */
	public void setGrade(double grade) {
		this.grade = grade;
	}
	
	/**
	 * Used to set a Candidates innovation level as brilliant or average
	 * @param innov Innovation Brilliant(true) or average(false)
	 */
	public void setInnovation(boolean innov) {
		this.innovation = innov;
	}
	
	/**
	 * Used to set a Candidates self regulation level on a scale of 0.0 to 1.0
	 * @param reg Candidates ability to self regulate 
	 */
	public void setRegulation(double reg) {
		this.regulation = reg;
	}
	
	/**
	 * The function will take a list of potential candidates, find all potential candidates then return them as a list.
	 * If a candidate has a grade lower than 85% they must have a self regulation score of 0.5 or greater and must
	 * have at least an average communication ability. If the candidates communication ability is poor 
	 * then they must have brilliant innovation capability.
	 * @param cands The list of potential candidates as an array of Candidate[]
	 * @return ArrayList of all eligible candidates.
	 */
	public static ArrayList<Candidate> getEligibleCandidates(Candidate[] cands) {
	
		ArrayList<Candidate> eligCandidates = new ArrayList<Candidate>(); //ArrayList to hold all potential candidates.
		
		
		for ( int i = 0; i < cands.length; i++) { //Go through each of the potential candidates and determine their eligibility.
			
			boolean isElligible = true; // Assume Candidate is eligible, becomes false if they fail a criteria.
			if (cands[i].getGrade() < 85) { /* Grade is less than 85, candidate must have self regulation abilities of 0.5 or higher
											and also have above average communication abilities.*/
				if (cands[i].getRegulation() < 0.5) //Checks Candidates self regulation ability.
					isElligible = false; //self Regulation ability is below 0.5, Candidate not eligible.
				else if (cands[i].getCommunication() == "poor")//Check Candidates communication ability
					isElligible = false; //Candidates communication ability was not average or higher, Candidate not eligible.
			}
			if (cands[i].getCommunication().equalsIgnoreCase("poor")) { //Candidate has poor communication abilities  they must have innovation capabilities that are brilliant.//
				
				if (!cands[i].isInnovative()) //Checks if the Candidate's innovation is considered brilliant(true) or average(false)
					isElligible = false; //Candidate is not innovative they are not eligible 
			}
			if (isElligible) //Candidate is eligible, add them to the list of eligible Candidates.
				eligCandidates.add(cands[i]);
		}
		return eligCandidates; 
	}
	
}
