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