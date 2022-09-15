/*
 * Challenge from https://www.codewars.com/kata/545cedaa9943f7fe7b000048/train/java/62f0187c703f91004be81d94
 * The challenge is as follows:
 * A pangram is a sentence that contains every single letter of the alphabet at least once. For example, the sentence 
 * "The quick brown fox jumps over the lazy dog" is a pangram, because it uses the letters A-Z at least once (case is irrelevant). 
 *
 * Given a string, detect whether or not it is a pangram. Return True if it is, False if not. Ignore numbers and punctuation.
 * 
 * Solution by Braiden Little
 */

import java.util.*;
public class PangramChecker {
  public boolean check(String sentence){
    char alphab[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    String lowersen = sentence.toLowerCase(); //Convert to lowercase for easier comparison.
    List<Character> sentarr= new ArrayList<>();
    for (char ch: lowersen.toCharArray()) { //Add all characters to a list.
      sentarr.add(ch);
    }
    for(int i = 0; i < alphab.length; i++) { //Check each character in the alphabet
      if (!sentarr.contains(alphab[i])) { // The sentence does not contain this letter and is not a pangram.
        return false;
      }
    }
    return true;
  }
}