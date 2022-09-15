/**
 * Assignment2, COMP268 Class: RockPaperScissorsLizardSpock.java Purpose: To
 * simulate a game of RockPaperScissorsLizardSpock between 2 computer players.
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
public class RockPaperScissorsLizardSpock {
	private int consecutiveWins; // variable to hold the number of consecutive wins
	private int lastWinner; // variable to track the last winner
	public static final int LIZARD = 4; // Variable to represent lizard for the game.
	public static final int PAPER = 2; // Variable to represent paper for the game.
	public static final int PLAYER1 = 123; // Player 1 ID#
	public static final int PLAYER2 = 222; // Player 2 ID#
	public static final int ROCK = 1; // Variable to represent rock for the game.
	public static final int SCISSORS = 3; // Variable to represent scissors for the game.
	public static final int SPOCK = 5; // Variable to represent Spock for the game.

	/**
	 * Getter Method for returning the current consecutive wins.
	 * 
	 * @return Number of consecutive wins.
	 */
	public int getConsecutiveWins() {
		return consecutiveWins;
	}

	/**
	 * Getter Method for returning the last winner
	 * 
	 * @return Last winners player number 1 or 2
	 */
	public int getLastWinner() {
		return lastWinner;
	}

	/**
	 * Function to generate a random number between 1 - 5 for the game.
	 * 
	 * @return Random number between 1- 5
	 */
	public int random() {
		int randomNumber; // Random number to be returned
		randomNumber = (int) (Math.random() * 5) + 1; // Generate the random number.
		return randomNumber;
	}

	/**
	 * Takes an integer in the range of 1 to 5 and converts it into a string/weapon
	 * for the game.
	 * 
	 * @param i the number to be converted
	 * @return String naming the weapon chosen.
	 */
	public static String convert(int i) {
		String convertToWeapon = null; // Variable to hold what weapon is chosen based on the number.
		if (i == ROCK) // number is 1 which means rock was chosen
			convertToWeapon = "Rock";
		else if (i == PAPER) // number is 2 which means paper was chosen
			convertToWeapon = "Paper";
		else if (i == SCISSORS) // number is 3 which means scissors was chosen
			convertToWeapon = "Scissors";
		else if (i == LIZARD) // number is 1 which means lizard was chosen
			convertToWeapon = "Lizard";
		else if (i == SPOCK) // number is 1 which means Spock was chosen
			convertToWeapon = "Spock";
		return convertToWeapon;
	}

	/**
	 * Take 2 numbers between 1 to 5 to represent the players weapon of choice for
	 * the game. Then check if player 1 or player 2 wins end the game when one
	 * player gets 4 consecutive wins.
	 * 
	 * @param player1 Value of the weapon the player chose
	 * @param player2 Value of the weapon the player chose
	 * @throws IllegalArgumentException if the number entered is out of the range of
	 *                                  1 to 4.
	 */
	public void play(int player1, int player2) {
		if (player1 <= 0 || player1 >= 6 || player2 <= 0 || player2 >= 6) // Number is not between the range of 1 to 5
			throw new IllegalArgumentException("Values must be between 1 and 5");
		do {
			/**
			 * Conditions for player 1 winning begin here
			 */
			if (player1 == SCISSORS && player2 == PAPER) { // Scissors beats paper Player 1 wins
				if (lastWinner == PLAYER2) // Player 2's win streak is over set the consecutive wins to 0
					consecutiveWins = 0;
				lastWinner = PLAYER1; // Record player 1 as the last winner
				consecutiveWins++; // Increase the number of consecutive wins
				System.out.println(convert(player1) + " cuts " + convert(player2) + " Player 1 wins!");
				System.out.println("Consecutive wins: " + consecutiveWins);
			} else if (player1 == SCISSORS && player2 == LIZARD) { // Scissors beats lizard Player 1 wins
				if (lastWinner == PLAYER2) // Player 2's win streak is over set the consecutive wins to 0
					consecutiveWins = 0;
				lastWinner = PLAYER1; // Record player 1 as the last winner
				consecutiveWins++; // Increase the number of consecutive wins
				System.out.println(convert(player1) + " decapitates " + convert(player2) + " Player 1 wins!");
				System.out.println("Consecutive wins: " + consecutiveWins);
			} else if (player1 == PAPER && player2 == ROCK) { // Paper beats rock Player 1 wins
				if (lastWinner == PLAYER2) // Player 2's win streak is over set the consecutive wins to 0
					consecutiveWins = 0;
				lastWinner = PLAYER1; // Record player 1 as the last winner
				consecutiveWins++; // Increase the number of consecutive wins
				System.out.println(convert(player1) + " covers " + convert(player2) + " Player 1 wins!");
				System.out.println("Consecutive wins: " + consecutiveWins);
			} else if (player1 == PAPER && player2 == SPOCK) { // Paper beats Spock Player 1 wins
				if (lastWinner == PLAYER2) // Player 2's win streak is over set the consecutive wins to 0
					consecutiveWins = 0;
				lastWinner = PLAYER1; // Record player 1 as the last winner
				consecutiveWins++; // Increase the number of consecutive wins
				System.out.println(convert(player1) + " disproves " + convert(player2) + " Player 1 wins!");
				System.out.println("Consecutive wins: " + consecutiveWins);
			} else if (player1 == ROCK && player2 == LIZARD) { // Rock beats lizard Player 1 wins
				if (lastWinner == PLAYER2) // Player 2's win streak is over set the consecutive wins to 0
					consecutiveWins = 0;
				lastWinner = PLAYER1; // Record player 1 as the last winner
				consecutiveWins++; // Increase the number of consecutive wins
				System.out.println(convert(player1) + " crushes " + convert(player2) + " Player 1 wins!");
				System.out.println("Consecutive wins: " + consecutiveWins);
			} else if (player1 == ROCK && player2 == SCISSORS) { // Rock beats scissors Player 1 wins
				if (lastWinner == PLAYER2) // Player 2's win streak is over set the consecutive wins to 0
					consecutiveWins = 0;
				lastWinner = PLAYER1; // Record player 1 as the last winner
				consecutiveWins++; // Increase the number of consecutive wins
				System.out.println(convert(player1) + " breaks " + convert(player2) + " Player 1 wins!");
				System.out.println("Consecutive wins: " + consecutiveWins);
			} else if (player1 == LIZARD && player2 == SPOCK) { // Lizard beats Spock Player 1 wins
				if (lastWinner == PLAYER2) // Player 2's win streak is over set the consecutive wins to 0
					consecutiveWins = 0;
				lastWinner = PLAYER1; // Record player 1 as the last winner
				consecutiveWins++; // Increase the number of consecutive wins
				System.out.println(convert(player1) + " poisons " + convert(player2) + " Player 1 wins!");
				System.out.println("Consecutive wins: " + consecutiveWins);
			} else if (player1 == LIZARD && player2 == PAPER) { // Lizard beats paper Player 1 wins
				if (lastWinner == PLAYER2) // Player 2's win streak is over set the consecutive wins to 0
					consecutiveWins = 0;
				lastWinner = PLAYER1; // Record player 1 as the last winner
				consecutiveWins++; // Increase the number of consecutive wins
				System.out.println(convert(player1) + " eats " + convert(player2) + " Player 1 wins!");
				System.out.println("Consecutive wins: " + consecutiveWins);
			} else if (player1 == SPOCK && player2 == SCISSORS) { // Spock beats Scissors Player 1 wins
				if (lastWinner == PLAYER2) // Player 2's win streak is over set the consecutive wins to 0
					consecutiveWins = 0;
				lastWinner = PLAYER1; // Record player 1 as the last winner
				consecutiveWins++; // Increase the number of consecutive wins
				System.out.println(convert(player1) + " melts " + convert(player2) + " Player 1 wins!");
				System.out.println("Consecutive wins: " + consecutiveWins);
			} else if (player1 == SPOCK && player2 == ROCK) { // Spock beats rock Player 1 wins
				if (lastWinner == PLAYER2) // Player 2's win streak is over set the consecutive wins to 0
					consecutiveWins = 0;
				lastWinner = PLAYER1; // Record player 1 as the last winner
				consecutiveWins++; // Increase the number of consecutive wins
				System.out.println(convert(player1) + " vaporizes " + convert(player2) + " Player 1 wins!");
				System.out.println("Consecutive wins: " + consecutiveWins);
			}
			/**
			 * Conditions for player 2 winning begin here
			 */
			else if (player2 == SCISSORS && player1 == LIZARD) { // Scissors beats lizard Player 2 wins
				if (lastWinner == PLAYER1) // Player 1's win streak is over set the consecutive wins to 0
					consecutiveWins = 0;
				lastWinner = PLAYER2; // Record player 2 as the last winner
				consecutiveWins++; // Increase the number of consecutive wins
				System.out.println(convert(player2) + " decapitates " + convert(player1) + " Player 2 wins!");
				System.out.println("Consecutive wins: " + consecutiveWins);
			} else if (player2 == SCISSORS && player1 == PAPER) { // Scissors beats paper Player 2 wins
				if (lastWinner == PLAYER1) // Player 1's win streak is over set the consecutive wins to 0
					consecutiveWins = 0;
				lastWinner = PLAYER2; // Record player 2 as the last winner
				consecutiveWins++; // Increase the number of consecutive wins
				System.out.println(convert(player2) + " cuts " + convert(player1) + " Player 2 wins!");
				System.out.println("Consecutive wins: " + consecutiveWins);
			} else if (player2 == PAPER && player1 == ROCK) { // Paper beats rock Player 2 wins
				if (lastWinner == PLAYER1) // Player 1's win streak is over set the consecutive wins to 0
					consecutiveWins = 0;
				lastWinner = PLAYER2; // Record player 2 as the last winner
				consecutiveWins++; // Increase the number of consecutive wins
				System.out.println(convert(player2) + " covers " + convert(player1) + " Player 2 wins!");
				System.out.println("Consecutive wins: " + consecutiveWins);
			} else if (player2 == PAPER && player1 == SPOCK) { // Paper beats Spock Player 2 wins
				if (lastWinner == PLAYER1) // Player 1's win streak is over set the consecutive wins to 0
					consecutiveWins = 0;
				lastWinner = PLAYER2; // Record player 2 as the last winner
				consecutiveWins++; // Increase the number of consecutive wins
				System.out.println(convert(player2) + " disproves " + convert(player1) + " Player 2 wins!");
				System.out.println("Consecutive wins: " + consecutiveWins);
			} else if (player2 == ROCK && player1 == LIZARD) { // Rock beats lizard Player 2 wins
				if (lastWinner == PLAYER1) // Player 1's win streak is over set the consecutive wins to 0
					consecutiveWins = 0;
				lastWinner = PLAYER2; // Record player 2 as the last winner
				consecutiveWins++; // Increase the number of consecutive wins
				System.out.println(convert(player2) + " crushes " + convert(player1) + " Player 2 wins!");
				System.out.println("Consecutive wins: " + consecutiveWins);
			} else if (player2 == ROCK && player1 == SCISSORS) { // Rock beats scissors Player 2 wins
				if (lastWinner == PLAYER1) // Player 1's win streak is over set the consecutive wins to 0
					consecutiveWins = 0;
				lastWinner = PLAYER2; // Record player 2 as the last winner
				consecutiveWins++; // Increase the number of consecutive wins
				System.out.println(convert(player2) + " breaks " + convert(player1) + " Player 2 wins!");
				System.out.println("Consecutive wins: " + consecutiveWins);
			} else if (player2 == LIZARD && player1 == SPOCK) { // Lizard beats Spock Player 2 wins
				if (lastWinner == PLAYER1) // Player 1's win streak is over set the consecutive wins to 0
					consecutiveWins = 0;
				lastWinner = PLAYER2; // Record player 2 as the last winner
				consecutiveWins++; // Increase the number of consecutive wins
				System.out.println(convert(player2) + " poisons " + convert(player1) + " Player 2 wins!");
				System.out.println("Consecutive wins: " + consecutiveWins);
			} else if (player2 == LIZARD && player1 == PAPER) { // Lizard beats paper Player 2 wins
				if (lastWinner == PLAYER1) // Player 1's win streak is over set the consecutive wins to 0
					consecutiveWins = 0;
				lastWinner = PLAYER2; // Record player 2 as the last winner
				consecutiveWins++; // Increase the number of consecutive wins
				System.out.println(convert(player2) + " eats " + convert(player1) + " Player 2 wins!");
				System.out.println("Consecutive wins: " + consecutiveWins);
			} else if (player2 == SPOCK && player1 == SCISSORS) { // Spock beats scissors Player 2 wins
				if (lastWinner == PLAYER1) // Player 1's win streak is over set the consecutive wins to 0
					consecutiveWins = 0;
				lastWinner = PLAYER2; // Record player 2 as the last winner
				consecutiveWins++; // Increase the number of consecutive wins
				System.out.println(convert(player2) + " melts " + convert(player1) + " Player 2 wins!");
				System.out.println("Consecutive wins: " + consecutiveWins);
			} else if (player2 == ROCK && player1 == ROCK) { // Spock beats rock Player 2 wins
				if (lastWinner == PLAYER1) // Player 1's win streak is over set the consecutive wins to 0
					consecutiveWins = 0;
				lastWinner = PLAYER2; // Record player 2 as the last winner
				consecutiveWins++; // Increase the number of consecutive wins
				System.out.println(convert(player2) + " vaporizes " + convert(player1) + " Player 2 wins!");
				System.out.println("Consecutive wins: " + consecutiveWins);
			} else if (player1 == player2) { // Both players selected the same weapon end it a tie.
				consecutiveWins = 0;
				System.out.println("Tie game both players selected " + convert(player1) + ".");

			}
			System.out.println();
			player1 = random(); // Player 1 chooses a new weapon for the next round
			player2 = random(); // Player 2 chooses a new weapon for the next round
		} while (consecutiveWins < 4);
		if (lastWinner == PLAYER1)
			System.out.println("Player 1 won 4 consecutive games in a row.");
		else
			System.out.println("Player 2 won 4 consecutive games in a row.");
	}
}
