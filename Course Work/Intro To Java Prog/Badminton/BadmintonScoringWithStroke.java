import java.util.ArrayList;

/**
 * Assignment2, COMP268 Class: BadmintonScoringTestWithStroke.java Purpose: To
 * extend the BadmintonScoring.java class to store an array of Point objects
 * which will hold the players points at each round of the game but also what
 * stroke they used for that point. Can also determine what the most used stroke
 * the player used was.
 * 
 * 
 * @author Braiden Little Student ID: 3364064 Date: September 17, 2018 Version
 *         1.0
 * 
 *         Based on: Introduction to Programming Using Java, Seventh Edition
 *         Version 7.0, August 2014 (Version 7.0.2, with mostly typographical
 *         corrections, December 2016) Author: David J. Eck (eck@hws.edu)
 *         http://math.hws.edu/javanotes/index.html
 *
 */
public class BadmintonScoringWithStroke extends BadmintonScoring {

	ArrayList<Point> scores = new ArrayList<Point>();
	int score1;
	int score2;
	static final int PLAYER1 = 1; // Player ID# for player 1
	static final int PLAYER2 = 2; // Player ID# for player 2

	/**
	 * Function to determine the most used stroke for Player 1
	 * 
	 * @return Most used stroke(Slice, Drive, Smash, Drop, or Net-Shot)
	 */
	public String getMostUsedStrokePlayer1() {
		String mostUsed = null; // Variable used to track what the most used stroke was
		int sliceCount = 0; // Used to track the number of slices
		int driveCount = 0; // Used to track the number of drives
		int smashCount = 0; // Used to track the number of smashes
		int dropCount = 0; // Used to track the number of drops
		int netShotCount = 0; // Used to track the number of net-shots
		for (int i = 0; i <= scores.size() - 1; i++) { // Go through the entire score list
			if (scores.get(i).getPlayer() == PLAYER1) { // For player 1
				if (scores.get(i).getStroke() == "a") // Stroke was a slice
					sliceCount++;
				else if (scores.get(i).getStroke() == "b") // Stroke was a drive
					driveCount++;
				else if (scores.get(i).getStroke() == "c") // Stroke was a smash
					smashCount++;
				else if (scores.get(i).getStroke() == "d") // Stroke was a drop
					dropCount++;
				else if (scores.get(i).getStroke() == "e") // Stroke was a net-shot
					netShotCount++;
			}
		}
		if (sliceCount > driveCount) { // Slice count greater than drive
			if (sliceCount > smashCount) { // Slice count greater than smash
				if (sliceCount > dropCount) { // Slice count greater than drop
					if (sliceCount > netShotCount) { // Slice count greater than net-shot
						mostUsed = "Slice"; // Slice is the most used stroke
						return mostUsed;
					}
				}
			}
		}
		if (driveCount > smashCount) { /*
										 * Drive cannot be greater than slice Drive count greater than smash
										 */
			if (driveCount > dropCount) { // Drive count greater than drop
				if (driveCount > netShotCount) { // Drive count greater than net-shot
					mostUsed = "Drive"; // Drive count is the most used stroke
					return mostUsed;
				}
			}
		}
		if (smashCount > dropCount) { /*
										 * Smash cannot be greater than slice or drop Smash count greater than drop
										 */
			if (smashCount > netShotCount) { // Smash count greater than net-shot
				mostUsed = "Smash"; // Smash is the most used stroke
				return mostUsed;
			}
		}
		if (dropCount > netShotCount) { /*
										 * Drop cannot be greater than slice,drop or smash Drop count greater than
										 * net-shot
										 */
			mostUsed = "Drop"; // Drop is the most used stroke
			return mostUsed;
		} else { // All other possibilities have been eliminated
			mostUsed = "Net-Shot"; // Net-Shot is the most used stroke
			return mostUsed;
		}
	}

	/**
	 * Function to determine the most used stroke for Player 2
	 * 
	 * @return Most used stroke(Slice, Drive, Smash, Drop, or Net-Shot)
	 */
	public String getMostUsedStrokePlayer2() {
		String mostUsed = null; // Variable used to track what the most used stroke was
		int sliceCount = 0; // Used to track the number of slices
		int driveCount = 0; // Used to track the number of drives
		int smashCount = 0; // Used to track the number of smashes
		int dropCount = 0; // Used to track the number of drops
		int netShotCount = 0; // Used to track the number of net-shots
		for (int i = 0; i <= scores.size() - 1; i++) { // Go through the entire score list
			if (scores.get(i).getPlayer() == PLAYER2) { // For player 2
				if (scores.get(i).getStroke() == "a") // Stroke was a slice
					sliceCount++;
				else if (scores.get(i).getStroke() == "b") // Stroke was a drive
					driveCount++;
				else if (scores.get(i).getStroke() == "c") // Stroke was a smash
					smashCount++;
				else if (scores.get(i).getStroke() == "d") // Stroke was a drop
					dropCount++;
				else if (scores.get(i).getStroke() == "e") // Stroke was a net-shot
					netShotCount++;
			}
		}
		if (sliceCount > driveCount) { // Slice count greater than drive
			if (sliceCount > smashCount) { // Slice count greater than smash
				if (sliceCount > dropCount) { // Slice count greater than drop
					if (sliceCount > netShotCount) { // Slice count greater than net-shot
						mostUsed = "Slice"; // Slice is the most used stroke
						return mostUsed;
					}
				}
			}
		}
		if (driveCount > smashCount) { /*
										 * Drive cannot be greater than slice Drive count greater than smash
										 */
			if (driveCount > dropCount) { // Drive count greater than drop
				if (driveCount > netShotCount) { // Drive count greater than net-shot
					mostUsed = "Drive"; // Drive count is the most used stroke
					return mostUsed;
				}
			}
		}
		if (smashCount > dropCount) { /*
										 * Smash cannot be greater than slice or drop Smash count greater than drop
										 */
			if (smashCount > netShotCount) { // Smash count greater than net-shot
				mostUsed = "Smash"; // Smash is the most used stroke
				return mostUsed;
			}
		}
		if (dropCount > netShotCount) { /*
										 * Drop cannot be greater than slice,drop or smash Drop count greater than
										 * net-shot
										 */
			mostUsed = "Drop"; // Drop is the most used stroke
			return mostUsed;
		} else { // All other possibilities have been eliminated
			mostUsed = "Net-Shot"; // Net-Shot is the most used stroke
			return mostUsed;
		}
	}
}
