// Following test code by Braiden Little
import java.util.Arrays;

public class ArrayDiffTest {
    public static void main(String[] args) {
        System.out.println("Test 1: Testing {1, 2, 3, 4, 5, 6} and {2, 8, 99, 12, 4}... ");
        if (Arrays.equals(Kata.arrayDiff(new int[] {1, 2, 3, 4, 5, 6}, new int[] {2, 8, 99, 12, 4}), new int[] {1, 3, 5, 6})) {
            System.out.println("Test 1 Passed!");
        }
        else {
            System.out.println("Test 1 Failed.");
        }
        System.out.println("Test 1: Testing {1, 33, 44, 44, 66, 27} and {33, 44, 27}... ");
        if (Arrays.equals(Kata.arrayDiff(new int[] {1, 33, 44, 44, 66, 27}, new int[] {33, 44, 27}), new int[] {1, 66})) {
            System.out.println("Test 2 Passed!");
        }
        else {
            System.out.println("Test 2 Failed.");
        }
    }
}
