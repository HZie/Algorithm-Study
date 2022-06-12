import java.util.*;

public class Solution {
  public void nextPermutation(int[] nums) {
      int i = nums.length - 2;
      while (i >= 0 && nums[i + 1] <= nums[i]) {
          i--;
      }
      if (i >= 0) {
          int j = nums.length - 1;
          while (nums[j] <= nums[i]) {
              j--;
          }
          swap(nums, i, j);
      }

      reverse(nums, i + 1);

      int j = i+1, k = nums.length - 1;
      while (j < k) {
          swap(nums, j, k);
          j++;
          k--;
      }
  }

  private void swap(int[] nums, int i, int j) {
      int temp = nums[i];
      nums[i] = nums[j];
      nums[j] = temp;
  }
}


// solve it again

// 1. find first decreasing part
// 2. find next large value and swap
// 3. reverse rest of the values

public class Solution{
  public void nextPermutation(int[] nums){
    int i;
    for(i = nums.length-2; i >= 0; i--){
      if(nums[i] < nums[i+1]){
        int nextBig = findNextBig(nums, i, nums[i]);
        swap(nums, i, nextBig);
        break;
      }
    }
    reverse(nums, i+1, nums.length-1);
  }

  public int findNextBig(int nums[], int start, int val){
    for(int i = start; i < nums.length-1; i++){
      if(nums[i+1] <= val){
        return i;
      }
    }
    return nums.length-1;
  }

  public void reverse(int[] nums, int start, int end){
    
    while(start <= end){
      swap(nums, start, end);
      start++; end--;
    }
  }

  public void swap(int[] nums, int i, int j){
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }
}