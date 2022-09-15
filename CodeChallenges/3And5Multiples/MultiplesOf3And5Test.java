// Following test code by Braiden Little
public class MultiplesOf3And5Test {
    public static void main(String args[]) {
        System.out.println("Test 1: Testing 13");
        if (new MultiplesOf3And5().solution(13) == 45) {
            System.out.println("Test 1 Passed!");
        }
        else {
            System.out.println("Test 1 Failed.");
        }
        System.out.println("Test 2: Testing 19");
        if (new MultiplesOf3And5().solution(19) == 78) {
            System.out.println("Test 2 Passed!");
        }
        else {
            System.out.println("Test 2 Failed.");
        }
    }
}