/*
 * Challenge from https://www.codewars.com/kata/5541f58a944b85ce6d00006a/train/java/62f02f2b2fd1f83ce1af9496
 * The challenge is as follows:
 * The Fibonacci numbers are the numbers in the following integer sequence (Fn):
 * 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, ... 
 * 
 * such as 
 *
 * F(n) = F(n-1) + F(n-2) with F(0) = 0 and F(1) = 1.
 * 
 * Given a number, say prod (for product), we search two Fibonacci numbers F(n) and F(n+1) verifying 
 * F(n) * F(n+1) = prod.
 * 
 * Your function productFib takes an integer (prod) and returns an array: 
 * [F(n), F(n+1), true] or {F(n), F(n+1), 1} or (F(n), F(n+1), True)
 * depending on the language if F(n) * F(n+1) = prod.
 * 
 * If you don't find two consecutive F(n) verifying F(n) * F(n+1) = prodyou will return
 * [F(n), F(n+1), false] or {F(n), F(n+1), 0} or (F(n), F(n+1), False)
 * F(n) being the smallest one such as F(n) * F(n+1) > prod.
 * 
 * Some Examples of Return:
 * (depend on the language)
 * 
 * productFib(714) # should return (21, 34, true), 
 *               # since F(8) = 21, F(9) = 34 and 714 = 21 * 34
 *
 * productFib(800) # should return (34, 55, false), 
 *              # since F(8) = 21, F(9) = 34, F(10) = 55 and 21 * 34 < 800 < 34 * 55
 * 
 * -----
 * productFib(714) # should return [21, 34, true], 
 * productFib(800) # should return [34, 55, false], 
 * -----
 * productFib(714) # should return {21, 34, 1}, 
 * productFib(800) # should return {34, 55, 0},    
 * -----
 * productFib(714) # should return {21, 34, true}, 
 * productFib(800) # should return {34, 55, false}, 
 * 
 * Solution by Braiden Little
 */

import java.util.*;
public class ProdFib { // must be public for codewars	
	public static long[] productFib(long prod) {
    if (prod == 0) { //0 is a product of the F(0) and F(1)
      long[] result = {0, 1, 1};
      return result;
    }
    List<Long> fibNum = new ArrayList<Long>(); //List to contain the fib numbers using memoization for performance reasons.
    fibNum.add((long)0); //Add the first two fib numbers.
    fibNum.add((long)1);
    for (int i = 2; i < prod; i++) { //Add fib numbers until a result is found or the products of fib numbers exceeds prod.
      fibNum.add(fibNum.get(i - 2) + fibNum.get(i - 1)); //Next fib number added.
      if (fibNum.get(i - 1) * fibNum.get(i) == prod) { //Fib number product is equal to prod.
        long[] result = {fibNum.get(i - 1), fibNum.get(i), 1}; //Generate the result and return.
        return result;
      }
      else if (fibNum.get(i - 1) * fibNum.get(i) > prod) { //The product of the fib numbers has exceeded prod.
        long[] result = {fibNum.get(i - 1), fibNum.get(i), 0}; //generate the last two fib numbers and false as a return value.
        return result;
      }
    }
    long[] result = {1, 1, 1}; //Default case
    return result;
   }
}