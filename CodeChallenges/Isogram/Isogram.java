/*
 * Challenge from https://www.codewars.com/kata/54ba84be607a92aa900000f1/train/java/62deffed970b2212ccc3b233
 * The challenge is as follows:
 * An isogram is a word that has no repeating letters, consecutive or non-consecutive. Implement a function that determines whether a string that contains only letters is an isogram.
 * Assume the empty string is an isogram. Ignore letter case.
 *
 * Examples (input --> output):
 *
 * "Dermatoglyphics" --> true
 * "aba" --> false
 * "moOse" --> false (ignore letter case)
 * Solution by Braiden Little
 */
import java.util.ArrayList;
public class Isogram {
    public static boolean  isIsogram(String str) {
      ArrayList<Character> word = new ArrayList<>(); //To contain the characters in str.
      for(int i = 0; i < str.length(); i++) {
        if(word.contains(Character.toLowerCase(str.charAt(i)))) { //Letter at position i in str is in word and is a duplicate and not an isogram.
          return false;
        }
        else {
        word.add(Character.toLowerCase(str.charAt(i))); //Add the first instance of the character to the word array
        }
      }
      return true;
    } 
}