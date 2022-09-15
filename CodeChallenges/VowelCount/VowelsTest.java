// Following test code by Braiden Little
public class VowelsTest {
    public static void main(String[] args) {
        System.out.println("Test 1: 'This is a sample sentence.'");
        if (Vowels.getCount("This is a sample sentence") == 8) {
            System.out.println("Test 1 Passed!");
        }
        else {
            System.out.println("Test 2 Failed.");
        }
        System.out.println("Test 2: 'aabbcffeppoiqqy'");
        if (Vowels.getCount("aabbcffeppoiqqy") == 5) {
            System.out.println("Test 2 Passed!");
        }
        else {
            System.out.println("Test 2 Failed.");
        }
    }
}
