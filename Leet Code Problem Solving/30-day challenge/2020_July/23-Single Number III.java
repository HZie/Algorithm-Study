// Time Complexity: O(N)
// Space Complexity: O(1)
class Solution {
    public int[] singleNumber(int[] nums) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        for(int i = 0; i < nums.length; i++){
            if(list.contains(nums[i])){
                list.remove(new Integer(nums[i]));
            }
            else{
                list.add(nums[i]);
            }
        }
        int[] ans = new int[2];
        ans[0] = list.get(0);
        ans[1] = list.get(1);
        
        return ans;
    }
}