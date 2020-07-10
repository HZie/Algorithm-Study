// My Code
// 엄청 많은 양의 데이터에 대해서는 Time Limit Exceed가 난다.
// 더 빠르게 찾는 방법을 생각해보아야 한다.
// Time Complexity: O(nlogn)
// Space Complexity: O(n)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>> ans = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        
        // since there should be both positive and negative integer to make sum = 0
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
