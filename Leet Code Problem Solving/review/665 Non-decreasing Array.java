// https://leetcode.com/problems/non-decreasing-array/submissions/
// Easy
class Solution {
    public boolean checkPossibility(int[] nums) {
        int fixed = 0;
        int preNum = 0;
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] > nums[i+1]){
                fixed++;
                if(fixed > 1){
                    return false;
                }
                if(preNum >= nums[i+1]){
                    nums[i+1] = nums[i];
                }
                else{
                    nums[i] = nums[i+1];
                }
            }
            preNum = nums[i];
        }
        return true;
    }
}

// time complexity: O(n)
// space complexity: O(1)