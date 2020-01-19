// https://leetcode.com/problems/find-peak-element/
// REVIEWING
// medium
// try to use binary search and to make it better
class Solution { 

    public int binarySearch(int[] nums, int l, int r){
        int mid = (l+r) / 2;
        int result  = 0;
        if(nums[mid] == nums[l] || nums[mid] == nums[r])
            return mid;
        else if(nums[mid] < nums[l])
            result = binarySearch(nums, l, mid);
        else
            result = binarySearch(nums,mid,r);
        return result;
    }

    public int findPeakElement(int[] nums) {      
       return binarySearch(nums,0,nums.length - 1);
        /* for(int i = 0; i < nums.length; i++){
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
        return -1;*/
    }
}
