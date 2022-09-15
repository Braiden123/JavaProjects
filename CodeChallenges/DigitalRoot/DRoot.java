/*
 * Challenge from https://www.codewars.com/kata/541c8630095125aba6000c00/train/java/62f81efa3afaff4525696541
 * The challenge is as follows:
 * Digital root is the recursive sum of all the digits in a number.
 *
 * Given n, take the sum of the digits of n. If that value has more than one digit, continue reducing in this way until a single-digit number is produced. The input will be a non-negative integer.
 *
 * Examples
 * 
 * 16  -->  1 + 6 = 7
 * 942  -->  9 + 4 + 2 = 15  -->  1 + 5 = 6
 * 132189  -->  1 + 3 + 2 + 1 + 8 + 9 = 24  -->  2 + 4 = 6
 * 493193  -->  4 + 9 + 3 + 1 + 9 + 3 = 29  -->  2 + 9 = 11  -->  1 + 1 = 2
 * 
 * Solution by Braiden Little
 */

import java.lang.Math;
public class DRoot {
  public static int digital_root(int n) {
    int sum = 0;
    while (true) {
      for (int i = Integer.toString(n).length(); i > 0; i--) { //Iterate over each digit
        sum += (int) (n / Math.pow(10, i - 1)) % 10; //Retrieve the next digit and add to sum.
      }
      if (sum > 9) { //Reduce n to smaller digital root
        n = sum;
        sum = 0;
      }
      else { //Digital root is found
        break;
      }
    }
    return sum;
  }
}