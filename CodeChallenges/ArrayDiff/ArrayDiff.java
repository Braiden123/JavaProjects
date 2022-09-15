/*
 * Challenge from https://www.codewars.com/kata/523f5d21c841566fde000009/train/java/62df038ac1e633132bfae237
 * The challenge is as follows:
 * Your goal in this kata is to implement a difference function, which subtracts one list from another and returns the result.
 *
 * It should remove all values from list a, which are present in list b keeping their order.
 *
 * Kata.arrayDiff(new int[] {1, 2}, new int[] {1}) => new int[] {2}
 * 
 * If a value is present in b, all of its occurrences must be removed from the other:
 * Kata.arrayDiff(new int[] {1, 2, 2, 2, 3}, new int[] {2}) => new int[] {1, 3}
 * Solution by Braiden Little
 */
class Kata {
  public static int[] removeElement(int[] arr, int index) { 
    int[] newArr = new int[arr.length - 1];
    System.arraycopy(arr, 0, newArr, 0, index); //Copy from start of original array to index, into new array
    System.arraycopy(arr, index + 1, newArr, index, arr.length - index - 1);// Copy from index + 1 to end of array.
    return newArr;
  }
  public static int findIndex(int[] a, int element) {
    for (int i = 0; i < a.length; i++) {
      if(a[i] == element) {
        return i;
      }
    }
    return -1;
  }
  public static boolean arrContains(int[] a, int x) {
    for (int i = 0; i < a.length; i++) { //Check each index for int x in the array.
      if (a[i] == x) {
        return true;
      }
    }
    return false;
  }
  public static int[] arrayDiff(int[] a, int[] b) {
    for(int i = 0; i < b.length; i++) {
      while(arrContains(a, b[i])) { //Go through every element in b
        a = removeElement(a, findIndex(a, b[i])); // Remove all instances of b[i] in a.
      }
    }
    return a;
  }
}
