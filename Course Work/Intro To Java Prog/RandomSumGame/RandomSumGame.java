/**
 * Assignment2, COMP268 Class: RandomSumGame.java Purpose: To simulate a game of
 * Craps by rolling a pair of six sided dice If the sum of the roll is 2, 3 or
 * 12 the player loses, if they get 7 or 11 they win. If none of these are
 * rolled then record the value of the roll and roll again until you either roll
 * the value(win) or 7(lose)
 * 
 * 
 * @author Braiden Little Student ID: 3364064 Date: September 12, 2018 Version
 *         1.0
 * 
 *         Based on: Introduction to Programming Using Java, Seventh Edition
 *         Version 7.0, August 2014 (Version 7.0.2, with mostly typographical
 *         corrections, December 2016) Author: David J. Eck (eck@hws.edu)
 *         http://math.hws.edu/javanotes/index.html
 *
 */
public class RandomSumGame {
	boolean start; // Variable used to see if option 3 is in effect.
	int d1; // Variable to hold the value of the first die
	int d2; // Variable to hold the value of the second die
	int sum; // Sum of the 2 dice
	int valuePoint; // Record the value for option 3 if a natural or craps is not rolled.
	String status; // Used to record the win/loss status for games.

	/**
	 * Method to play a game of Craps given the initial values of the 2 dice
	 * 
	 * @param d1 Value of Die 1
	 * @param d2 Value of Die 2
	 * @throws IllegalArgumentException if any dice number are not between 1 to 6
	 */
	public void play(int d1, int d2) {
		if (d1 <= 0 || d1 >= 7 || d2 <= 0 || d2 >= 7) // Invalid Dice values.
			throw new IllegalArgumentException("Dice value must be in the range of 1 to 6");
		int gamesPlayed = 0; // Variable used to track number of games played
		int gamesWon = 0; // Variable used to track the number of games the user has won.
		int gamesLost = 0; // Variable used to track the number of games the user has lost.
		this.start = false; // Not following option 3 yet due to new game.
		this.sum = d1 + d2; // Get the sum of the 2 dice values passed through the parameter.
		status = " \n You rolled " + Integer.toString(d1) + " and " + Integer.toString(d2); // Record the roll on a new
																							// line.
		do {
			if (sum == 2 || sum == 3 || sum == 12) { // User rolled Craps lose the game
				gamesPlayed++; // Increase the number of games played
				gamesLost++; // Increase the number of games lost
				status += "Craps you lose, "; // Add the game status to status
			} else if (sum == 7 || sum == 11) { // User rolled a Natural win the game
				gamesPlayed++; // Increase the number of games played
				gamesWon++; // Increase the number of games won
				status += "Natural you win, "; // Add the game status to status
			} else { /*
						 * User did not roll Craps or Natural Option 3 is in effect keep rolling until
						 * the first sum is rolled again(win) or a 7(loss).
						 */
				valuePoint = sum; // Record the value point rolled previously.
				status = status + " You did not roll Craps or a natural, Roll Again";

				do { // Keep rolling until the value point or 7 is rolled
					rollDice(); // Roll the dice again
					status = status + " \n You rolled " + Integer.toString(this.d1) + " and"
							+ Integer.toString(this.d2); // Record the roll on a new line.
					if (this.sum == valuePoint) {// User rolled the value point user wins
						gamesPlayed++; // Increase the number of games played
						gamesWon++; // Increase the number of games won
						status += " Value point rolled (win), "; // Add the game status to status.
						start = true; // No longer in option 3
					} else if (this.sum == 7) { // User rolled a 7 user loses
						gamesPlayed++; // Increase the number of games played
						gamesLost++; // Increase the number of games lost
						status += " Rolled 7 in option 3,"; // Add the game status to status
						start = true; // No longer in option 3
					} else
						status += " Roll Again";
				} while (!start);
			}

			rollDice(); // Roll the dice again for a new game
			status = status + " \n You rolled " + Integer.toString(this.d1) + " and " + Integer.toString(this.d2); // Record
																													// the
																													// roll
																													// on
																													// a
																													// new
																													// line.
		} while (gamesPlayed < 3); // Run until 3 games have been played.
		System.out.println("The results of your 3 games was " + status);
		System.out.println("In total you won " + gamesWon + " games and lost " + gamesLost + " games.");
	}

	public void play() {
		int gamesPlayed = 0; // Variable used to track number of games played
		int gamesWon = 0; // Variable used to track the number of games the user has won.
		int gamesLost = 0; // Variable used to track the number of games the user has lost.
		this.start = false; // Not following option 3 yet due to new game.
		status = "";
		do {
			rollDice(); // Roll the dice for a new game
			status = status + " \n You rolled " + Integer.toString(this.d1) + " and " + Integer.toString(this.d2); // Record
																													// the
																													// roll
																													// on
																													// a
																													// new
																													// line.
			if (sum == 2 || sum == 3 || sum == 12) { // User rolled Craps lose the game
				gamesPlayed++; // Increase the number of games played
				gamesLost++; // Increase the number of games lost
				status += " Craps you lose, "; // Add the game status to status
			} else if (sum == 7 || sum == 11) { // User rolled a Natural win the game1
				gamesPlayed++; // Increase the number of games played
				gamesWon++; // Increase the number of games won
				status += " Natural you win, "; // Add the game status to status
			} else { /*
						 * User did not roll Craps or Natural Option 3 is in effect keep rolling until
						 * the first sum is rolled again(win) or a 7(loss).
						 */
				valuePoint = sum; // Record the value point rolled previously.
				status = status + " You did not roll Craps or a natural,";

				do { // Keep rolling until the value point or 7 is rolled
					status = status + " Roll again.";
					rollDice(); // Roll the dice again
					status = status + " \n You rolled " + Integer.toString(this.d1) + " and "
							+ Integer.toString(this.d2); // Record the roll on a new line.
					if (this.sum == valuePoint) {// User rolled the value point user wins
						gamesPlayed++; // Increase the number of games played
						gamesWon++; // Increase the number of games won
						status += " Value point rolled, you win "; // Add the game status to status.
						start = true; // No longer in option 3
					} else if (this.sum == 7) { // User rolled a 7 user loses
						gamesPlayed++; // Increase the number of games played
						gamesLost++; // Increase the number of games lost
						status += " Rolled 7 in option 3 you lose, "; // Add the game status to status
						start = true; // No longer in option 3
					}
				} while (!start);
			}
		} while (gamesPlayed < 3); // Run until 3 games have been played.
		System.out.println("The results of your 3 games was " + status);
		System.out.println("In total you won " + gamesWon + " games and lost " + gamesLost + " games.");
	}

	public void rollDice() {
		this.d1 = (int) (Math.random() * 6) + 1; // Roll a random number between 1 and 6 for d1
		this.d2 = (int) (Math.random() * 6) + 1; // Roll a random number between 1 and 6 for d2
		this.sum = d1 + d2; // Add the sum of the 2 dice.
	}
}
