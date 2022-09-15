/*
 * Challenge from https://www.codewars.com/kata/54da539698b8a2ad76000228/train/java/62f7f3a413360f003d6d532d
 * The challenge is as follows:
 * You live in the city of Cartesia where all roads are laid out in a perfect grid. You arrived ten minutes too early to an appointment, so you decided to take the opportunity to go for a short walk. 
 * The city provides its citizens with a Walk Generating App on their phones -- everytime you press the button it sends you an array of one-letter strings representing directions to walk (eg. ['n', 's', 'w', 'e']). 
 * You always walk only a single block for each letter (direction) and you know it takes you one minute to traverse one city block,
 * so create a function that will return true if the walk the app gives you will take you exactly ten minutes (you don't want to be early or late!) and will,
 * of course, return you to your starting point. Return false otherwise.
 *
 * Note: you will always receive a valid array containing a random assortment of direction letters ('n', 's', 'e', or 'w' only). It will never give you an empty array (that's not a walk, that's standing still!).
 * 
 * Solution by Braiden Little
 */

public class TenMinWalk {
  public static boolean isValid(char[] walk) {
    if(walk.length != 10) { //Walk does not take 10 minutes
      return false;
    }
    int nscount = 0, ewcount = 0; //Used to track directions, value of 0 is the starting point in the respective direction.
    for (int i = 0; i < walk.length; i++) {
      switch(walk[i]) {
          case 'e': //Move one minute eastward.
            ewcount++;
            break;
          case 'w': //Move one minute westward.
            ewcount--;
            break;
          case 'n': //Move one minute northward.
            nscount++;
            break;
          case 's': //Move one minute southward.
            nscount--;
            break;
      }
    }
    if(nscount != 0 || ewcount != 0) { //Both counts must be 0 to be back at the starting point.
      return false;
    }
    else {
      return true;
    }
  }
}