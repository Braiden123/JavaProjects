/*
 * Challenge from https://www.codewars.com/kata/515de9ae9dcfc28eb6000001/train/java/62f00c182fd1f80023afd960
 * The challenge is as follows:
 * Complete the solution so that it splits the string into pairs of two characters. If the string contains an odd number of characters then it should replace the missing second character of the final pair with an underscore ('_').
 * 
 * Examples:
 * * 'abc' =>  ['ab', 'c_']
 * * 'abcdef' => ['ab', 'cd', 'ef']
 * Solution by Braiden Little
 */

import java.util.ArrayList;
import java.util.List;
public class StringSplit {
    public static String[] solution(String s) {
      List<String> result = new ArrayList<String>();
      for (int i = 0; i < s.length(); i++) {
        if (((i + 1) >= 0) && ((i + 1) < s.length())) { //i at start of string and is not the last character in the string.
          result.add(Character.toString(s.charAt(i))); //Add character i to result
          result.set(result.size() - 1, (result.get(result.size() - 1)) + Character.toString(s.charAt(i + 1))); //Add the character after i to the same position in the list as i.
          i++; //i + 1 is added so we move two positions in the string
        }
        else { // string contains an odd amount of characters, add last character to the end of the list and append _ to the last element in the list.
          result.add(Character.toString(s.charAt(i)));
          result.set(result.size() - 1, result.get(result.size() - 1) + "_");
        }
      }
      String resArr[] = new String[result.size()]; 
      resArr = result.toArray(resArr);
      return resArr;
    }
}