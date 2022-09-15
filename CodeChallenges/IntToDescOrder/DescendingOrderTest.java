/*
 * Tests written by Braiden Little
 */
public class DescendingOrderTest {
    public static void main(String[] args) {
        System.out.println("Test 1: Testing 78951... ");
        if (DescendingOrder.sortDesc(78951) == 98751) {
            System.out.println("Test 1 Passed!");
        }
        else {
            System.out.println("Test 1 Failed.");
        }
        System.out.println("Test 2: Testing 123456789... ");
        if (DescendingOrder.sortDesc(123456789) == 987654321) {
            System.out.println("Test 2 Passed!");
        }
        else {
            System.out.println("Test 2 Failed.");
        }
        System.out.println("Test 3: Testing 54232369... ");
        if (DescendingOrder.sortDesc(54232369) == 96543322) {
            System.out.println("Test 3 Passed!");
        }
        else {
            System.out.println("Test 3 Failed.");
        }
    }
}