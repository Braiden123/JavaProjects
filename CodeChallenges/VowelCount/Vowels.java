/*
 * Challenge from https://www.codewars.com/kata/54ff3102c1bad923760001f3/train/java/62f81fb33afaff000f696f26
 * The challenge is as follows:
 * Return the number (count) of vowels in the given string. 
 *
 * We will consider a, e, i, o, u as vowels for this Kata (but not y).
 * The input string will only consist of lower case letters and/or spaces.
 * Solution by Braiden Little
 */
public class Vowels {

  public static int getCount(String str) {
    int vowelsCount = 0;
    for(int i = 0; i < str.length(); i++) { //Check each letter in the string.
      char letter = str.charAt(i);
      if(letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u') //Letter is a vowel, add to count.
        vowelsCount++;
    }
    return vowelsCount;
  }
}