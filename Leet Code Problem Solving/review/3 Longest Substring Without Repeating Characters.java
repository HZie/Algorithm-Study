// https://leetcode.com/problems/longest-substring-without-repeating-characters/
// Medium
// Need to be optimized
// Time: O(N^2)
// Space: O(1)

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start = 0, end = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int result = 1;
        if(s.length() == 0)
            return 0;
        
        // O(N^2)
        for(int i = 0; i < s.length(); i++){

            int length = 0;
            for(int j = i; j < s.length(); j++){
                if(map.containsKey(s.charAt(j))){
                    if(result < length)
                        result = length;
                    break;
                }
                map.put(s.charAt(j), 1);
                length++;
                if(j == s.length() - 1){
                    if(result < length)
                        result = length;
                }
            }
            map.clear();
        }
        
        return result;
    }
    
    
}