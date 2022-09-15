/**
 * Assignment2, COMP268 Class: BadmintonScoringTest.java Purpose: To test the
 * BadmintonScoring.java, BadmintonScoringWithStroke.java and the Point.java
 * classes for accuracy by creating an Arraylist in a BadmintonScoringWithStroke
 * object to represent the players points earned in the game and what stroke
 * they used for that point.
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
public class BadmintonScoringTest {
	static final int PLAYER1 = 1; // Player ID# for player 1
	static final int PLAYER2 = 2; // Player ID# for player 2

	public static void main(String[] args) {
		BadmintonScoringWithStroke gameScores = new BadmintonScoringWithStroke();
		gameScores.scores.add(new Point(PLAYER1, "a", 1)); // Add a score of 1 and slice stroke for player 1
		gameScores.scores.add(new Point(PLAYER1, "c", 2)); // Add a score of 2 and smash stroke for player 1
		gameScores.scores.add(new Point(PLAYER1, "a", 3)); // Add a score of 3 and slice stroke for player 1
		gameScores.scores.add(new Point(PLAYER1, "c", 4)); // Add a score of 4 and smash stroke for player 1
		gameScores.scores.add(new Point(PLAYER1, "c", 5)); // Add a score of 5 and smash stroke for player 1
		gameScores.scores.add(new Point(PLAYER2, "d", 1)); // Add a score of 1 and drop stroke for player 2
		gameScores.scores.add(new Point(PLAYER2, "e", 2)); // Add a score of 2 and net-shot stroke for player 2
		gameScores.scores.add(new Point(PLAYER2, "d", 3)); // Add a score of 3 and drop stroke for player 2
		gameScores.scores.add(new Point(PLAYER2, "e", 4)); // Add a score of 4 and net-shot stroke for player 2
		gameScores.scores.add(new Point(PLAYER2, "d", 5)); // Add a score of 5 and drop stroke for player 2
		gameScores.scores.add(new Point(PLAYER2, "e", 6)); // Add a score of 6 and net-shot stroke for player 2
		gameScores.scores.add(new Point(PLAYER2, "e", 7)); // Add a score of 7 and net-shot stroke for player 2
		gameScores.scores.add(new Point(PLAYER2, "a", 8)); // Add a score of 8 and slice stroke for player 2
		gameScores.scores.add(new Point(PLAYER2, "d", 9)); // Add a score of 9 and drop stroke for player 2
		gameScores.scores.add(new Point(PLAYER2, "e", 10)); // Add a score of 10 and net-shot stroke for player 2
		gameScores.scores.add(new Point(PLAYER2, "e", 11)); // Add a score of 11 and net-shot stroke for player 2
		gameScores.scores.add(new Point(PLAYER2, "e", 12)); // Add a score of 12 and net-shot stroke for player 2
		gameScores.scores.add(new Point(PLAYER2, "e", 13)); // Add a score of 13 and net-shot stroke for player 2
		gameScores.scores.add(new Point(PLAYER2, "e", 14)); // Add a score of 14 and net-shot stroke for player 2
		gameScores.scores.add(new Point(PLAYER2, "e", 15)); // Add a score of 15 and net-shot stroke for player 2
		gameScores.scores.add(new Point(PLAYER2, "e", 16)); // Add a score of 16 and net-shot stroke for player 2
		gameScores.scores.add(new Point(PLAYER2, "e", 17)); // Add a score of 17 and net-shot stroke for player 2
		gameScores.scores.add(new Point(PLAYER2, "e", 18)); // Add a score of 18 and net-shot stroke for player 2
		gameScores.scores.add(new Point(PLAYER2, "e", 19)); // Add a score of 19 and net-shot stroke for player 2
		gameScores.scores.add(new Point(PLAYER2, "e", 20)); // Add a score of 20 and net-shot stroke for player 2
		gameScores.scores.add(new Point(PLAYER2, "e", 21)); // Add a score of 21 and net-shot stroke for player 2
		gameScores.scores.add(new Point(PLAYER2, "a", 22)); // Add a score of 22 and slice stroke for player 2
		System.out.println("Player 1 had a score of " + gameScores.getPlayer1Points() + "."); // Print out player 1
																								// score
		System.out.println("with a highest streak of " + gameScores.getContinuousPointsPlayer1() + "."); // Print out
																											// player 1
																											// longest
																											// streak
		System.out.println("Their most used stroke was " + gameScores.getMostUsedStrokePlayer1()); // Print out most
																									// used stroke for
																									// player 1
		System.out.println("Player 2 had a score of " + gameScores.getPlayer2Points() + "."); // Print out player 2
																								// score
		System.out.println("with a highest streak of " + gameScores.getContinuousPointsPlayer2() + "."); // Print out
																											// player 2
																											// longest
																											// streak
		System.out.println("Their most used stroke was " + gameScores.getMostUsedStrokePlayer2()); // Print out most
																									// used stroke for
																									// player 2
	}
}
