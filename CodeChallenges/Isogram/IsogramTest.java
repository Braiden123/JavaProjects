/*
 * Test based tests from: https://www.codewars.com/kata/54ba84be607a92aa900000f1/train/java/62deffed970b2212ccc3b233
 */
class IsogramTest {
    public static void main(String[] args) {
        System.out.println("Test 1: Testing 'Dermatoglyphics', should return true.");
        if (Isogram.isIsogram("Dermatoglyphics")) {
            System.out.println("Test 1 Passed!");
        }
        else {
            System.out.println("Test 1 Failed.");
        }
        System.out.println("Test 2: Testing 'moose', should return false.");
        if (!Isogram.isIsogram("moose")) {
            System.out.println("Test 2 Passed!");
        }
        else {
            System.out.println("Test 2 Failed.");
        }
        System.out.println("Test 3: Testing 'moOse', should return false.");
        if (!Isogram.isIsogram("moOse")) {
            System.out.println("Test 3 Passed!");
        }
        else {
            System.out.println("Test 3 Failed.");
        }
    }
}