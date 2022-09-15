/*
 * Tests based on tests from challenge at: https://www.codewars.com/kata/5266876b8f4bf2da9b000362/train/java/62c4f80ec5ecc80018fbb17a
 */
public class WhoLikesItTest {
    public static void main(String[] args) {
        System.out.println("Test 1: Testing no strings should equal 'no one likes this' ");
        if (Solution.whoLikesIt().equals("no one likes this")) {
            System.out.println("Test 1 Passed!");
        }
        else {
            System.out.println("Test 1 Failed.");
        }
        System.out.println("Test 2: Testing string 'Peter', should return 'Peter likes this'");
         if (Solution.whoLikesIt("Peter").equals("Peter likes this")) {
            System.out.println("Test 2 Passed!");
        }
        else {
            System.out.println("Test 2 Failed.");
        }
        System.out.println("Test 3: Testing strings 'Jacob', and 'Alex', should return 'Jacob and Alex like this'");
        if (Solution.whoLikesIt("Jacob", "Alex").equals("Jacob and Alex like this")) {

            System.out.println("Test 3 Passed!");
        }
        else {
            System.out.println("Test 3 Failed.");
        }
        System.out.println("Test 4: Testing strings 'Max', 'John', and 'Mark' should return 'Max, John and Mark like this'");
        if (Solution.whoLikesIt("Max", "John", "Mark").equals("Max, John and Mark like this")) {
            System.out.println("Test 4 Passed!");
        }
        else {
            System.out.println("Test 4 Failed.");
        }
        System.out.println("Test 5: Testing strings 'Alex', 'Jacob', 'Mark', and 'Max' should return 'Alex, Jacob and 2 others like this'");
        if (Solution.whoLikesIt("Alex", "Jacob", "Mark", "Max").equals("Alex, Jacob and 2 others like this")  ) {
            System.out.println("Test 5 Passed!");
        }
        else {
            System.out.println("Test 5 Failed.");
        }
    }
}