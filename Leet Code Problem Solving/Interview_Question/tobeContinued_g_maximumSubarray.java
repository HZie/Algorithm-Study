class Solution {
  public int maxSubArray(int[] nums) {
      int max = Integer.MIN_VALUE;
      for(int i = 0; i < nums.length; i++){
          for(int j = i; j < nums.length; j++){
              int sum = getSum(nums, i, j);
              max = Math.max(sum, max);
          }
      }
      return max;
  }
  
  public int getSum(int[] nums, int start, int end){
      int sum = 0;
      for(int i = start; i <= end; i++){
          sum += nums[i];
      }
      return sum;
  }
}