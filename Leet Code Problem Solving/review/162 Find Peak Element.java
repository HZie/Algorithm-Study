// https://leetcode.com/problems/find-peak-element/
// medium
// try to use binary search and to make it better
class Solution {    
    public int findPeakElement(int[] nums) {      
        for(int i = 0; i < nums.length; i++){
            if( i == 0 && i == nums.length - 1)
                return i;
            if( i == 0){
                if(nums[i] > nums[i+1])
                    return i;
            }
            else if(i == nums.length - 1){
                if(nums[i] > nums[i-1])
                    return i;
            }
            else{
                if(nums[i] > nums[i-1] && nums[i] > nums[i+1])
                    return i;
            }
                
        }
        return -1;
    }
}
