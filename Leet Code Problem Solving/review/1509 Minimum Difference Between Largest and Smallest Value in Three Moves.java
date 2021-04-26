// https://leetcode.com/problems/minimum-difference-between-largest-and-smallest-value-in-three-moves/
// Time: O(nlogn)
// Space: O(n)

class Solution {
    public int minDifference(int[] nums) {
        if(nums.length <= 4){
            return 0;
        }
        
        Arrays.sort(nums);
        int[] order = new int[4];
        int[] reverseOrder = new int[4];
        
        for(int i = 0; i < order.length; i++){
            order[i] = nums[i];
            reverseOrder[reverseOrder.length-1 - i] = nums[nums.length-1 - i];
        }
        
        int min = Integer.MAX_VALUE;
        
        for(int i = 0; i < order.length; i++){
            int diff = reverseOrder[i] - order[i];
            if(min > diff)
                min = diff;
        }
        
        return min;
    }
}

/*
// other's code

// The min difference between highest and lowest values after changing three elements to any value
//  can be determined by removing three elements from among the largest 3 or smallest 3 values
// Algorithm: 
//  1) Sort array
//  2) build window excluding 3 elements from beginning 
//  3) slide the window back to include those at the beginning and exclude those at the end
//  4) difference of each window is nums[lastIndex] - nums[firstIndex]
//  5) return the min diff
class Solution {
  public int minDifference(int[] nums) {
    int n = nums.length;
    if (n <= 4)
      return 0;
    
    Arrays.sort(nums);
    int minDiff = Integer.MAX_VALUE;
    for (int i = 0; i < 4; i++)
      minDiff = Math.min(minDiff, nums[n - 1 - i] - nums[3 - i]);

    return minDiff;
  }
}
 */