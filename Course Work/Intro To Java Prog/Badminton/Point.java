/**
 * Assignment2, COMP268 Class: BadmintonScoringTestWithStroke.java Purpose: To
 * be used with the BadmintonScoringWithStroke.java class to store a point
 * scored, which player scored it and the stroke that the player used for that
 * point.
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
public class Point {

	private int player;
	private int score;
	private static final int PLAYER1 = 1;
	private static final int PLAYER2 = 2;
	private String stroke;

	/**
	 * Constructor method for the Point class
	 * 
	 * @param player //Player number
	 * @param stroke //Type of stroke player used to score
	 * @param value  //Players current score
	 */
	public Point(int player, String stroke, int value) {
		this.player = player;
		this.stroke = stroke;
		this.score = value;
	}

	/**
	 * Getter method to return the player number
	 * 
	 * @return Player number
	 */
	public int getPlayer() {
		return player;
	}

	/**
	 * Getter method to return the players score
	 * 
	 * @return Player score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * Getter method to return the stroke the player used
	 * 
	 * @return
	 */
	public String getStroke() {
		return stroke;
	}
}
