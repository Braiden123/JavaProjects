/*
 * Challenge from https://www.codewars.com/kata/5467e4d82edf8bbf40000155/train/java/62dc6b1aed71435652c877cb
 * The challenge is as follows:
 * Your task is to make a function that can take any non-negative integer as an argument and return it with its digits in descending order.
 * Essentially, rearrange the digits to create the highest possible number.
 * 
 * Examples:
 * Input: 42145 Output: 54421
 * Input: 145263 Output: 654321
 * Input: 123456789 Output: 987654321
 */

import java.util.Arrays;
public class DescendingOrder {
  public static int sortDesc(final int num) {
    String numStr = Integer.toString(num); //Convert to string
    char strArr[] = numStr.toCharArray(); //Convert string to array of chars
    Arrays.sort(strArr);
    char arrCopy[] = strArr.clone(); 
    for (int i = 0; i < strArr.length; i++) { //Put the elements in arrCopy into strArr in descending order
      strArr[i] = arrCopy[arrCopy.length - 1 - i];
    }
    return Integer.parseInt(new String(strArr)); //Convert strArr into a single integer to return
  }
}
