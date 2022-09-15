/*
 * Tests based on tests from https://www.codewars.com/kata/5264d2b162488dc400000001/train/java/62f03903f47ee9d1ffa00921
 */
public class SpinWordsTest {
    public static void main(String[] args) {
       SpinWords testClass = new SpinWords();
       System.out.println("Test 1: 'Welcome', should return 'emocleW'");
        if (testClass.spinWords("Welcome").equals("emocleW")) {
            System.out.println("Test 1 Passed!");
        }
        else {
            System.out.println("Test 1 Failed.");
        } 
       System.out.println("Test 2: 'Hey fellow warriors', should return 'Hey wollef sroirraw'");
        if (testClass.spinWords("Hey fellow warriors").equals("Hey wollef sroirraw")) {
            System.out.println("Test 2 Passed!");
        }
        else {
            System.out.println("Test 2 Failed.");
        } 
    }
}
