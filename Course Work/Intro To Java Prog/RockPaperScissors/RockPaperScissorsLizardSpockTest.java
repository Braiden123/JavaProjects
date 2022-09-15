/**
 * Assignment2, COMP268 Class: RockPaperScissorsLizardSpockTest.java Purpose: To
 * test the RockPaperScissorsLizardSpock.java class by creating a
 * RockPaperScissorsLizardSpock object and playing a game with it.
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
public class RockPaperScissorsLizardSpockTest {

	public static void main(String[] args) {
		RockPaperScissorsLizardSpock game = new RockPaperScissorsLizardSpock(); // Create the
																				// RockPaperScissorsLizarsSpock object
		game.play(game.random(), game.random()); // Play the game with 2 random values passed to represent each players
													// weapons.
	}
}
