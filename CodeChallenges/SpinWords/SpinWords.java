/*
 * Challenge from https://www.codewars.com/kata/5264d2b162488dc400000001/train/java/62f03903f47ee9d1ffa00921
 * The challenge is as follows:
 * Write a function that takes in a string of one or more words, and returns the same string, but with all five or more letter words reversed (Just like the name of this Kata).
 * Strings passed in will consist of only letters and spaces. Spaces will be included only when more than one word is present.
 *
 * Examples:
 * 
 * spinWords( "Hey fellow warriors" ) => returns "Hey wollef sroirraw"
 * spinWords( "This is a test") => returns "This is a test" 
 * spinWords( "This is another test" )=> returns "This is rehtona test"
 * 
 * Solution by Braiden Little
 */

import java.lang.StringBuilder;
public class SpinWords {
  public String spinWords(String sentence) {
    String result = "";
    String[] words = sentence.split(" "); // Split the words in sentence into an array.
    for (int i = 0; i < words.length; i++) {
      if (words[i].length() >= 5) { //If word longer than 5 letters, reverse it
        StringBuilder sb = new StringBuilder(words[i]);
        words[i] = sb.reverse().toString();
      }
      if (i == 0) { //First word
        result = result + words[i];
      }
      else {
        result = result + " " + words[i];
      }
    }
    return result;
  }
}