/*
 * Tests based on tests from: https://www.codewars.com/kata/5541f58a944b85ce6d00006a/train/java/62f02f2b2fd1f83ce1af9496
 */
import java.util.Arrays;

public class ProdFibTest {
    public static void main(String[] args) {
       System.out.println("Test 1: 4895, should return {55, 89, 1}. ");
        if (Arrays.equals(new long[] {55, 89, 1}, ProdFib.productFib(4895))) {
            System.out.println("Test 1 Passed!");
        }
        else {
            System.out.println("Test 1 Failed.");
        }
        System.out.println("Test 2: 5895, should return {89, 144, 0}. ");
        if (Arrays.equals(new long[] {89, 144, 0}, ProdFib.productFib(5895))) {
            System.out.println("Test 2 Passed!");
        }
        else {
            System.out.println("Test 2 Failed.");
        }
    }
}
