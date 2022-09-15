/*
 * Tests from https://www.codewars.com/kata/52fba66badcd10859f00097e/train/java/62b75a97211432bf9705c21a
 */
public class TrollTest {
    public static void main(String[] args) {
        System.out.println("Test 1: Testing 'This website is for losers LOL!', 'Ths wbst s fr lsrs LL'");
        if (Troll.disemvowel("This website is for losers LOL!").equals("Ths wbst s fr lsrs LL!")) {
            System.out.println("Test 1 Passed!");
        }
        else {
            System.out.println("Test 1 Failed.");
        } 
        System.out.println("Test 2: Testing 'No offense but,\nYour writing is among the worst I've ever read', 'N ffns bt,\nYr wrtng s mng th wrst 'v vr rd'");
        if (Troll.disemvowel("No offense but,\nYour writing is among the worst I've ever read").equals("N ffns bt,\nYr wrtng s mng th wrst 'v vr rd")) {
            System.out.println("Test 2 Passed!");
        }
        else {
            System.out.println("Test 2 Failed.");
        } 
        System.out.println("Test 3: Testing 'What are you, a communist?', 'Wht r y,  cmmnst?'");
        if (Troll.disemvowel("What are you, a communist?").equals("Wht r y,  cmmnst?")) {
            System.out.println("Test 3 Passed!");
        }
        else {
            System.out.println("Test 3 Failed.");
        } 
    }
}
