/*
 * Tests based on tests from https://www.codewars.com/kata/54da5a58ea159efa38000836/train/java/62f7f9d43afaff003c696a10
 */
public class FindOddTest {
    public static void main(String[] args) {
        System.out.println("Test 1: Testing {20,1,-1,2,-2,3,3,5,5,1,2,4,20,4,-1,-2,5}, should return 5.");
        if (FindOdd.findIt(new int[]{20,1,-1,2,-2,3,3,5,5,1,2,4,20,4,-1,-2,5}) == 5){
            System.out.println("Test 1 Passed!");
        }
        else {
            System.out.println("Test 1 Failed.");
        }
        System.out.println("Test 2: Testing new int[]{1,1,2,-2,5,2,4,4,-1,-2,5}, should return -1.");
        if (FindOdd.findIt(new int[]{1,1,2,-2,5,2,4,4,-1,-2,5}) == -1){
            System.out.println("Test 2 Passed!");
        }
        else {
            System.out.println("Test 2 Failed.");
        }
        System.out.println("Test 3: Testing new int[]{20,1,1,2,2,3,3,5,5,4,20,4,5}, should return 5.");
        if (FindOdd.findIt(new int[]{20,1,1,2,2,3,3,5,5,4,20,4,5}) == 5){
            System.out.println("Test 3 Passed!");
        }
        else {
            System.out.println("Test 3 Failed.");
        }
        System.out.println("Test 4: Testing {10}, should return 10.");
        if (FindOdd.findIt(new int[]{10}) == 10){
            System.out.println("Test 4 Passed!");
        }
        else {
            System.out.println("Test 4 Failed.");
        }
        System.out.println("Test 5: Testing []{1,1,1,1,1,1,10,1,1,1,1}, should return 10.");
        if (FindOdd.findIt(new int[]{1,1,1,1,1,1,10,1,1,1,1}) == 10){
            System.out.println("Test 5 Passed!");
        }
        else {
            System.out.println("Test 5 Failed.");
        }
        System.out.println("Test 6: Testing new int[]{5,4,3,2,1,5,4,3,2,10,10}, should return 1.");
        if (FindOdd.findIt(new int[]{5,4,3,2,1,5,4,3,2,10,10}) == 1){
            System.out.println("Test 6 Passed!");
        }
        else {
            System.out.println("Test 6 Failed.");
        }
    }
}