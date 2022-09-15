/*
 * Tests based on tests from https://www.codewars.com/kata/54da539698b8a2ad76000228/train/java/62f7f3a413360f003d6d532d
 */
public class TenMinWalkTest {
    public static void main(String[] args) {
        System.out.println("Test 1: {'n','s','n','s','n','s','n','s','n','s'}, should return true.");
        if (TenMinWalk.isValid(new char[] {'n','s','n','s','n','s','n','s','n','s'})) {
            System.out.println("Test 1 Passed!");
        }
        else {
            System.out.println("Test 1 Failed.");
        }
        System.out.println("Test 2: {'w','e','w','e','w','e','w','e','w','e','w','e'}, should return false.");
        if (!TenMinWalk.isValid(new char[] {'w','e','w','e','w','e','w','e','w','e','w','e'})) {
            System.out.println("Test 2 Passed!");
        }
        else {
            System.out.println("Test 2 Failed.");
        }
        System.out.println("Test 3: {'w'} should return false.");
        if (!TenMinWalk.isValid(new char[] {'w'})) {
            System.out.println("Test 3 Passed!");
        }
        else {
            System.out.println("Test 3 Failed.");
        }
        System.out.println("Test 4: {'n','n','n','s','n','s','n','s','n','s'}, should return false.");
        if (!TenMinWalk.isValid(new char[] {'n','n','n','s','n','s','n','s','n','s'})) {
            System.out.println("Test 4 Passed!");
        }
        else {
            System.out.println("Test 4 Failed.");
        }
    }
}