// Time Complexity: O(2^n)
// Space Complexity: O(n)
class Solution {
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    
    public List<List<Integer>> subsets(int[] nums) {
        boolean visited[] = new boolean[nums.length];
        recursive(nums,visited,0);
        return ans;
    }
    
    public void recursive (int[] nums, boolean[] visited, int idx){
        if(idx == nums.length){
            List<Integer> sub = new ArrayList<Integer>();
            for(int i = 0; i < nums.length; i++){
                if(visited[i])
                    sub.add(nums[i]);
            }
            ans.add(sub);
            return;
        }
        visited[idx] = false;
        recursive(nums, visited, idx+1);
        visited[idx] = true;
        recursive(nums, visited, idx+1);
        return;
    }
}