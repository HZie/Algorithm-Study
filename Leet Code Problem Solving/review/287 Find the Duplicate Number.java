// https://leetcode.com/problems/find-the-duplicate-number/
// Medium
// Try to shorten time complexity

class Solution {
    public int findDuplicate(int[] nums) {
        int[] repeat = new int[nums.length + 1];
        
        for(int i = 0; i < nums.length; i++){   //O(n)
            repeat[nums[i]]++;
            if(repeat[nums[i]] > 1)
                return nums[i];
        }
        return -1;
    }
}