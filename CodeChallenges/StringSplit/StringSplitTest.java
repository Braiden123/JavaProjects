import java.util.Arrays;

/*
 * Tests are based on tests from https://www.codewars.com/kata/515de9ae9dcfc28eb6000001/train/java/62f00c182fd1f80023afd960
 */
public class StringSplitTest {
    public static void main(String[] args) {
        //First two tests test even length strings, tests 3 and 4 test odd length strings.
        System.out.println("Test 1: Testing abcdef, should return [ab, cd, ef].");
        if (Arrays.equals(StringSplit.solution("abcdef"), new String[] {"ab", "cd", "ef"})) {
            System.out.println("Test 1 Passed!");
        }
        else {
            System.out.println("Test 1 Failed.");
        }
        System.out.println("Test 2: Testing HelloWorld, should return [He, ll, oW, or, ld].");
        if (Arrays.equals(StringSplit.solution("HelloWorld"), new String[] {"He", "ll", "oW", "or", "ld"})) {
            System.out.println("Test 2 Passed!");
        }
        else {
            System.out.println("Test 2 Failed.");
        }
        System.out.println("Test 3: Testing abcde, should return [ab, cd, e_].");
        if (Arrays.equals(StringSplit.solution("abcde"), new String[] {"ab", "cd", "e_"})) {
            System.out.println("Test 3 Passed!");
        }
        else {
            System.out.println("Test 3 Failed.");
        }
        System.out.println("Test 4: Testing LovePizza, should return [Lo, ve, Pi, zz, a_].");
        if (Arrays.equals(StringSplit.solution("LovePizza"), new String[] {"Lo", "ve", "Pi", "zz", "a_"})) {
            System.out.println("Test 4 Passed!");
        }
        else {
            System.out.println("Test 4 Failed.");
        }
    }
}
