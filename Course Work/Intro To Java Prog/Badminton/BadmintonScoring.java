/**
 * Assignment2, COMP268 Class: BadmintonScoring.java Purpose: To store scores
 * for both players during a game of badminton, will also be able to give the
 * players final score and their highest continuous streak.
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
public class BadmintonScoring {

	static final int PLAYER1 = 1; // ID# for player 1
	static final int PLAYER2 = 2; // ID# for player 2
	static int[][] scores = { { 0, 1, 2, 0, 0, 0, 0, 0, 3, 4, 0, 0, 0, // Create the 2d array to score the badminton
																		// scores.
			0, 0, 0, 0, 0, 0, 0, 5, 0, 0, 0, 0, 0, 0 }, // Player 1 scores
			{ 0, 0, 0, 1, 2, 3, 4, 5, 0, 0, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 0, 16, 17, 18, 19, 20, 21 }, // Player 2
																												// scores.
	};

	/**
	 * Get the final score of player 1
	 * 
	 * @return final score of player 1
	 */
	public int getPlayer1Points() {
		int finalScore = 0; // Assume final score is 0
		for (int column = 26; column >= 0; column--) { // Go through the players score starting at the end
			if (scores[0][column] != 0) { // Score is a non 0 number, it is the players highest scores.
				finalScore = scores[0][column];
				return finalScore;
			}
		}
		return finalScore; // Return player 1s final score.
	}

	/**
	 * Get the final score of player 2
	 * 
	 * @return final score of player 2
	 */
	public int getPlayer2Points() {
		int finalScore = 0; // Assume final score is 0
		for (int column = 26; column >= 0; column--) { // Go through the players score starting at the end
			if (scores[1][column] != 0) { // Score is a non 0 number, it is the players highest scores.
				finalScore = scores[1][column];
				return finalScore;
			}
		}
		return finalScore; // Return player 2s final score.
	}

	/**
	 * Go through the score list for Player 1 and find the longest continuous
	 * scoring sequence.
	 * 
	 * @return //The longest scoring sequence for Player 1
	 */
	public int getContinuousPointsPlayer1() {
		int highestSequence = 0; // Used to track the highest sequence of points scored
		int currentSequence = 0; // Used to track the current sequence of points scored
		boolean sequenceStart = false; // used to track if a sequence has started
		for (int column = 0; column < scores[0].length; column++) { // Go through the players score list.
			if (scores[0][column] != 0) { // Player 1 scored a point, add to the sequence
				if (sequenceStart) { // Add 1 to the sequence if currently in a sequence
					currentSequence++;
				} else
					sequenceStart = true; // Sequence has started
			} else if (scores[0][column] == 0) {
				currentSequence = 0; // Player did not score end the current sequence.
				sequenceStart = false; // Sequence has ended
			}
			if (column == 0) { // Assume the 0 at the start begins the sequence.
				sequenceStart = true;
			}
			if (currentSequence > highestSequence) // Current sequence is higher than the highest so far
				highestSequence = currentSequence; // Set the highest sequence to be the current sequence(now highest so
													// far)
		}
		return highestSequence;
	}

	/**
	 * Go through the score list for Player 2 and find the longest continuous
	 * scoring sequence.
	 * 
	 * @return //The longest scoring sequence for Player 2
	 */
	public int getContinuousPointsPlayer2() {
		int highestSequence = 0; // Used to track the highest sequence of points scored
		int currentSequence = 0; // Used to track the current sequence of points scored
		boolean sequenceStart = false; // used to track if a sequence has started
		for (int column = 0; column < scores[1].length; column++) { // Go through the players score list.
			if (scores[1][column] != 0) { // Player 2 scored a point, add to the sequence
				if (sequenceStart) { // Add 1 to the sequence if currently in a sequence
					currentSequence++;
				} else
					sequenceStart = true; // Sequence has started
			} else if (scores[1][column] == 0) {
				currentSequence = 0; // Player did not score end the current sequence.
				sequenceStart = false; // Sequence has ended
			}
			if (column == 0) { // Assume the 0 at the start begins the sequence.
				sequenceStart = true;
			}
			if (currentSequence > highestSequence) // Current sequence is higher than the highest so far
				highestSequence = currentSequence; // Set the highest sequence to be the current sequence(now highest so
													// far)
		}
		return highestSequence;
	}
}
