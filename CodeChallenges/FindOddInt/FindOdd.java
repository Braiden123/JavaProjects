/*
 * Challenge from https://www.codewars.com/kata/54da5a58ea159efa38000836/train/java/62f7f9d43afaff003c696a10
 * The challenge is as follows:
 * Given an array of integers, find the one that appears an odd number of times.
 * 
 * There will always be only one integer that appears an odd number of times.
 * Examples
 * [7] should return 7, because it occurs 1 time (which is odd).
 * [0] should return 0, because it occurs 1 time (which is odd).
 * [1,1,2] should return 2, because it occurs 1 time (which is odd).
 * [0,1,0,1,0] should return 0, because it occurs 3 times (which is odd).
 * [1,2,2,3,3,3,4,3,3,3,2,2,1] should return 4, because it appears 1 time (which is odd).
 * 
 * Solution by Braiden Little
 */

import java.util.HashMap;
public class FindOdd {
	public static int findIt(int[] a) {
    HashMap<Integer, Integer> intcount = new HashMap<Integer, Integer>(); //Used to count the number of times a digit occurs in a.
    for (int i = 0; i < a.length; i++) {
      if (intcount.containsKey(a[i])) { //Digit already exists in the hash table
        intcount.put(a[i], intcount.get(a[i]) + 1); //Increment the count
      }
      else { //First instance of the digit in a.
        intcount.put(a[i], 1);
      }
    }
    for (int i : intcount.keySet()) { //Check each digit in the hash table to see if appreared an odd number of times.
      if (intcount.get(i) % 2 != 0) {
        return i;
      }
    }
    return -1;
  }
}