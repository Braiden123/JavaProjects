/*
 * Tests based on tests from: https://www.codewars.com/kata/545cedaa9943f7fe7b000048/train/java/62f0187c703f91004be81d94
 */
public class PangramCheckerTest {
    public static void main(String[] args) {
        System.out.println("Test 1: The quick brown fox jumps over the lazy dog. Should return true.");
        PangramChecker pangramCheck = new PangramChecker();
        if (pangramCheck.check("The quick brown fox jumps over the lazy dog.")) {
            System.out.println("Test 1 Passed!");
        }
        else {
            System.out.println("Test 1 Failed.");
        }
        System.out.println("Test 2: You shall not pass!. Should return false.");
        if (!pangramCheck.check("You shall not pass!")) {
            System.out.println("Test 2 Passed!");
        }
        else {
            System.out.println("Test 2 Failed.");
        }
    }
}
