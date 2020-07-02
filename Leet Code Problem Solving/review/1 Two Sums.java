// https://leetcode.com/problems/two-sum/
// time: O(n)
// space: O(1)
// Need to solve it by myself

class Solution {
    public int[] twoSum(int[] arr, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0 ; i < arr.length ; i ++){
            if(map.containsKey(target - arr[i])) 
                return new int[] {map.get(target - arr[i]) , i};
            else map.put(arr[i], i );
        }

        return new int[] { -1, -1 };
    }
}