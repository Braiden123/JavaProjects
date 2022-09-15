import java.util.ArrayList;
/**
 * 	Assignment1, COMP268
 * Class: CandidateTest.java
 * Purpose: To test the Candidate.java class for correct function and output.
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
public class CandidateTest {

	public static void main(String[] args) {
		ArrayList<Candidate> eligibleCandidates = new ArrayList<Candidate>(); //List to hold all the eligible Candidates.
		Candidate[] potentialCandidates; //List of all Candidates
		potentialCandidates = new Candidate[15];
		potentialCandidates[0] = new Candidate("Elena", "Brandon", 82.30, "poor", true, 0.5); // First Candidate constructor
		potentialCandidates[1] = new Candidate("Thomas", "Molson", 85.10, "poor", false, 1.0); // Second Candidate constructor
		potentialCandidates[2] = new Candidate("Hamilton", "Winn", 77.77, "average", false, 0.8); // Third Candidate constructor 
		potentialCandidates[3] = new Candidate("Suzie", "Sarandin", 69.93, "average", false, 0.0); // Fourth Candidate constructor
		potentialCandidates[4] = new Candidate("Philip", "Winne", 93.03, "average", true, 1.0); // Fifth Candidate constructor
		potentialCandidates[5] = new Candidate("Alex", "Trebok", 88.61, "poor", true, 0.7); // Sixth Candidate constructor
		potentialCandidates[6] = new Candidate("Emma", "Pivoto", 55.99, "excellent", false, 0.8); // Seventh Candidate constructor
		potentialCandidates[7] = new Candidate("John", "Lenthen", 87.49, "excellent", true, 0.9); // Eighth Candidate constructor
		potentialCandidates[8] = new Candidate("James", "Lean", 88.00, "excellent", false, 0.5); // Ninth Candidate constructor
		potentialCandidates[9] = new Candidate("Jane", "Ostin", 91.20, "average", true, 0.6); // Tenth Candidate constructor
		potentialCandidates[10] = new Candidate("Emily", "Car", 66.79, "excellent", false, 0.3); // Eleventh Candidate constructor
		potentialCandidates[11] = new Candidate("Daniel", "Hamshire", 76.65, "average", true, 0.2); // Twelfth Candidate constructor
		potentialCandidates[12] = new Candidate("Neda", "Bazdar", 55.89, "excellent", true, 0.5); // Thirteenth Candidate constructor
		potentialCandidates[13] = new Candidate("Aaron", "Smith", 90.01, "excellent", false, 0.3); // Fourteenth Candidate constructor
		potentialCandidates[14] = new Candidate("Kate", "Hen", 87.90, "poor", false, 0.8); // Fifteenth Candidate constructor
		
		System.out.println("The list of potential Candidates is as follows: "); 
		for (int i = 0; i <= potentialCandidates.length - 1; i++) { //Print the first and last names of all the Candidates.
			System.out.println(potentialCandidates[i].getFirstName() + " " + potentialCandidates[i].getLastName() + ".");
		}
		eligibleCandidates = Candidate.getEligibleCandidates(potentialCandidates);
		System.out.println();
		System.out.println("And the eligible candidates are as follows :");
		for (int i = 0; i <= eligibleCandidates.size() - 1; i++) { //Print all the eligible Candidates.
			System.out.println(eligibleCandidates.get(i).getFirstName() + " " + eligibleCandidates.get(i).getLastName() + ".");
		}

	}

}
