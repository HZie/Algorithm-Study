// First Idea
// time: O(N^2), space: O(N)

/*
 * sample input: abcbcacbb
 *
 * from the start make string and input the character and index into the hash map
 * count up the length
 * if find same character from the hash map, then start counting from next index of first repeated character
 *  
 */

import java.util.*;

class Solution {
  public int lengthOfLongestSubstring(String s) {
    HashMap<Character, Integer> map = new HashMap<>();
    int count = 0, max = 0;

    // O(N)
    for(int i = 0; i < s.length(); i++){
      char curr = s.charAt(i);
      if(map.containsKey(curr)){
        max = Math.max(max, count);

        int formerIdx = map.get(curr);
        count = i - formerIdx;

        map.clear();

        // O(N)
        for(int j = formerIdx+1; j <= i; j++){
          map.put(s.charAt(j), j);
        }
      }
      else{
        map.put(curr, i);
        count++;
      }
    }

    max = Math.max(max, count);

    return max;
  }
}



// Solution 
// time: O(N), space: O(1) --> num of character

/*
 * use two pointer (with runner)
 * i pointing start, j pointing last one
 * for loop with string length
 * if i and j is equal, then i++
 * each loop calculate the length of substring using i and j (j-i+1)
 * get max value by comparing max variable and length of substring calculated before
 */

public class Solution {
  public int lengthOfLongestSubstring(String s) {
      int n = s.length(), ans = 0;
      Map<Character, Integer> map = new HashMap<>(); // current index of character
      // try to extend the range [i, j]
      for (int j = 0, i = 0; j < n; j++) {
          if (map.containsKey(s.charAt(j))) {
              i = Math.max(map.get(s.charAt(j)), i);
          }
          ans = Math.max(ans, j - i + 1);
          map.put(s.charAt(j), j + 1);
      }
      return ans;
  }
}