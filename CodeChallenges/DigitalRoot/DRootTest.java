/*
 * Tests based on tests from https://www.codewars.com/kata/541c8630095125aba6000c00/train/java/62f81efa3afaff4525696541
 */
public class DRootTest {
    public static void main(String[] args) {
        System.out.println("Test 1: Testing 16");
        if (DRoot.digital_root(16) == 7) {
            System.out.println("Test 1 Passed!");
        }
        else {
            System.out.println("Test 1 Failed.");
        }
        System.out.println("Test 1: Testing 456");
        if (DRoot.digital_root(456) == 6) {
            System.out.println("Test 2 Passed!");
        }
        else {
            System.out.println("Test 2 Failed.");
        }
    }
}
