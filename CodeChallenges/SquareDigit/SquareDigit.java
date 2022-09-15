/*
 * Challenge from https://www.codewars.com/kata/546e2562b03326a88e000020/train/java/62f7f4203afaff0025696937
 * The challenge is as follows:
 * Welcome. In this kata, you are asked to square every digit of a number and concatenate them.
 * For example, if we run 9119 through the function, 811181 will come out, because 92 is 81 and 12 is 1. 
 * Note: The function accepts an integer and returns an integer
 * Solution by Braiden Little
 */
public class SquareDigit {

  public int squareDigits(int n) {
    if (n == 0) {
      return 0;
    }
    String solution = "";
    int nextdig;
    for (int i = Integer.toString(n).length(); i > 0; i--) {
      nextdig = ((int) ((n / Math.pow(10, i - 1) % 10))) * ((int) ((n / Math.pow(10, i - 1) % 10))); //The next digit in n, square it and save to nextdig.
      solution += nextdig; //Append squared digit to solution
    }
    return Integer.parseInt(solution); //Convert solution to int and return.
  }
}