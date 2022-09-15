/*
 * Following code is based on the test code from:
 * https://www.codewars.com/kata/5265326f5fda8eb1160004c8/train/java/62da124015350958156a0fa7
 */

public class NumtoStringTest {
    public static void main(String args[]) {
        System.out.println("Test 1: Testing 67... ");
        if (Kata.numberToString(67).equals("67")) {
            System.out.println("Test 1 Passed!");
        }
        else {
            System.out.println("Test 1 Failed.");
        }
        System.out.println("Test 2: Testing 123... ");
        if (Kata.numberToString(123).equals("123")) {
            System.out.println("Test 2 Passed!");
        }
        else {
            System.out.println("Test 2 Failed.");
        }
        System.out.println("Test 3: Testing 999... ");
        if (Kata.numberToString(999).equals("999")) {
            System.out.println("Test 3 Passed!");
        }
        else {
            System.out.println("Test 3 Failed.");
        }
    }
}