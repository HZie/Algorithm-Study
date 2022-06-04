// First Idea
// Time Complexity: O(nlogn + n^2) --> Time Limit Exceed
// Space Complexity: O(n)

/* 
 * Brute Force: Search Everything --> time: O(N^3)
 * Another Way
 * 1. sort the arrays (NlogN)
 * 2. check if same number exist (if curr number is same as before one, just skip)
 * 3. make curr one as a middle number, search from left and right to make sum = 0
 * --> Time Limit Exceed
*/

import java.util.*;

class Solution {
  public List<List<Integer>> threeSum(int[] nums) {
      ArrayList<List<Integer>> ans = new ArrayList<List<Integer>>();
      // nlogn
      Arrays.sort(nums);
      
      // since there should be both positive and negative integer to make sum = 0
      
      // n^2
      for(int i = 0; i < nums.length - 1 && nums[i] <= 0 ; i++){
          if(i - 1 >= 0 && nums[i-1] == nums[i]) continue;
          int left = i+1, right = nums.length - 1;
          int sum = 0;
          
          while(left < right){
              sum = nums[left] + nums[i] + nums[right];
              if(sum == 0){
                  ArrayList<Integer> set = new ArrayList<Integer>();
                  set.add(nums[i]);
                  set.add(nums[left]);
                  set.add(nums[right]);
                  if(!ans.contains(set))
                      ans.add(set);
                  left++;
                  right--;
              }
              else if(sum < 0)
                  left++;
              else
                  right--;
          }
      }
      
      return ans;
  }
}



// Solution

/*
Approach 3: "No-Sort"
What if you cannot modify the input array, and you want to avoid copying it due to memory constraints?

We can adapt the hashset approach above to work for an unsorted array. 
We can put a combination of three values into a hashset to avoid duplicates. 
Values in a combination should be ordered (e.g. ascending). Otherwise, we can have results with the same values in the different positions.

Algorithm

The algorithm is similar to the hashset approach above. We just need to add few optimizations so that it works efficiently for repeated values:

Use another hashset dups to skip duplicates in the outer loop.
Without this optimization, the submission will time out for the test case with 3,000 zeroes. This case is handled naturally when the array is sorted.
Instead of re-populating a hashset every time in the inner loop, we can use a hashmap and populate it once. 
Values in the hashmap will indicate whether we have encountered that element in the current iteration. 
When we process nums[j] in the inner loop, we set its hashmap value to i. This indicates that we can now use nums[j] as a complement for nums[i].
This is more like a trick to compensate for container overheads. The effect varies by language, e.g. for C++ it cuts the runtime in half. 
Without this trick the submission may time out.
 */

  /*
Time Complexity: O(N^2). We have outer and inner loops, each going through nn elements.

While the asymptotic complexity is the same, this algorithm is noticeably slower than the previous approach. 
Lookups in a hashset, though requiring a constant time, are expensive compared to the direct memory access.

Space Complexity: O(N) for the hashset/hashmap.

For the purpose of complexity analysis, we ignore the memory required for the output. 
However, in this approach we also store output in the hashset for deduplication. 
In the worst case, there could be O(N^2) triplets in the output, like for this example: [-k, -k + 1, ..., -1, 0, 1, ... k - 1, k]. 
Adding a new number to this sequence will produce n / 3 new triplets.
  */


class Solution {
  public List<List<Integer>> threeSum(int[] nums) {
      Set<List<Integer>> res = new HashSet<>();
      Set<Integer> dups = new HashSet<>();
      Map<Integer, Integer> seen = new HashMap<>();
      for (int i = 0; i < nums.length; ++i)
          if (dups.add(nums[i])) {
              for (int j = i + 1; j < nums.length; ++j) {
                  int complement = -nums[i] - nums[j];
                  if (seen.containsKey(complement) && seen.get(complement) == i) {
                      List<Integer> triplet = Arrays.asList(nums[i], nums[j], complement);
                      Collections.sort(triplet);
                      res.add(triplet);
                  }
                  seen.put(nums[j], i);
              }
          }
      return new ArrayList(res);
  }
}