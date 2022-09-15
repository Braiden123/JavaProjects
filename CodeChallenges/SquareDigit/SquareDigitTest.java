/*
 * Tests are based on tests from https://www.codewars.com/kata/546e2562b03326a88e000020/train/java/62f7f4203afaff0025696937
 */
public class SquareDigitTest {
    public static void main(String[] args) {
        SquareDigit testclass = new SquareDigit();
        System.out.println("Test 1: 9119, should return 811181.");
        if (testclass.squareDigits(9119) == 811181) {
            System.out.println("Test 1 Passed!");
        }
        else {
            System.out.println("Test 1 Failed.");
        } 
        System.out.println("Test 1: 0, should return 0.");
        if (testclass.squareDigits(0) == 0) {
            System.out.println("Test 1 Passed!");
        }
        else {
            System.out.println("Test 1 Failed.");
        }
    }
}