/*
 * Challenge from https://www.codewars.com/kata/514b92a657cdc65150000006/train/java/62da1d3ddba84305d56c2c5f
 * The challenge is as follows:
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
 *
 * Finish the solution so that it returns the sum of all the multiples of 3 or 5 below the number passed in. 
 * Additionally, if the number is negative, return 0 (for languages that do have them).
 * Note: If the number is a multiple of both 3 and 5, only count it once.
 *
 * Solution by Braiden Little
 */

public class MultiplesOf3And5 {

    public int solution(int number) {
      int sum = 0;
      if(number < 0) //Negative number return 0.
        return 0;
      for(int i = 1; i < number; i++) {
        if(i % 3 == 0 || i % 5 == 0) { //Number is divisible by 3 or 5, add to sum.
          sum += i;
        }
      }
      return sum;
    }
  }