import java.util.Scanner;

/**
 * Assignment2, COMP268 Class: RandomSumGameTest.java Purpose: To test the
 * RandomSumGame.java class for accuracy and prompt the user if they wish to
 * play a game and accept input.
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

public class RandomSumGameTest {

	public static void main(String[] args) {

		RandomSumGame game = new RandomSumGame(); // Create a new RandomSumGame object called game
		Scanner input = new Scanner(System.in); // Create the scanner for user input
		boolean playAgain; // When false the game will stop playing
		int die1Input; // User input value for Die 1
		int die2Input; // User input value for Die 2

		while (true) { // Keep playing the game until the user says false
			System.out.println("Would you like to play a game of Craps? True/False");
			playAgain = input.nextBoolean(); // Get user input if they want to play
			if (!playAgain) // User answered false break the loop and end the program.
				break;
			System.out.println("Would you like to decide the initial values enter 0 if you want to roll.");
			System.out.println("Die 1: ");
			die1Input = input.nextInt(); // Get the users value for the first die.

			if (die1Input != 0) { // If they answered anything but 0 ask for Die 2 value
				System.out.println("Die 2:");
				die2Input = input.nextInt(); // Get the users value for the second die.
				game.play(die1Input, die2Input); // Play the game using the values given by the user
			} else { // Play the game with random numbers decided by rolls.
				game.play();
			}
		}
	}
}
