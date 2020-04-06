// https://leetcode.com/problems/single-number/
// Easy
// time complexity: O(n)
// space complexity: O(1)

class Solution {
    public int singleNumber(int[] nums) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        for(int i = 0; i < nums.length; i++){
            if(!ans.contains(nums[i])){
                ans.add(nums[i]);
            }
            else{
                ans.remove(ans.indexOf(nums[i]));
            }
        }
        
        return ans.get(0);
    }
}