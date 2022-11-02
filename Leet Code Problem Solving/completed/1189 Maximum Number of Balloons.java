// https://leetcode.com/problems/maximum-number-of-balloons/

import java.util.*;

// O(N) where N is length of text
class Solution {
    public int maxNumberOfBalloons(String text) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('b',0);
        map.put('a',0);
        map.put('l',0);
        map.put('o',0);
        map.put('n',0);
        
        for(int i = 0; i < text.length(); i++){
            char c = text.charAt(i);
            if(map.containsKey(c)){
                map.put(c, map.get(c)+1);
            }
        }
        
        map.put('l', map.get('l')/2);
        map.put('o', map.get('o')/2);
        
        int min = Integer.MAX_VALUE;
        
        ArrayList<Integer> val = new ArrayList<>(map.values());
        
        for(int i = 0; i < val.size(); i++){
            if(val.get(i) < min)
                min = val.get(i);
        }
        return min;
        
    }
}