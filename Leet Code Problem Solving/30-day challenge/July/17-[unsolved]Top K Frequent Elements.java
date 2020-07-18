class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int ans[] = new int[k];
        HashMap<Integer, Integer> hs = new HashMap<Integer,Integer>();
        
        for(int i = 0; i < nums.length; i++){
            int count;
            if(!hs.containsKey(nums[i])){
                count = 1;
            }
            else{
                count = hs.get(nums[i]);
                num++;
            }
            hs.put(nums[i],count);
        }
        
}