class Solution {
    public int numSplits(String s) {
       HashMap<Character, Integer> left = new HashMap<>();
        HashMap<Character, Integer> right = new HashMap<>();
        int ans = 0;

        // 먼저 string의 모든 문자를 오른쪽으로 옮긴다
        for(char c : s.toCharArray()) right.put(c, right.getOrDefault(c, 0) + 1);
        
        // input의 순서대로 하나씩 왼쪽으로 보낸다
        for(char c : s.toCharArray()) {

            if(right.containsKey(c)){
                // right에서 하나 뺐을 때 해당 키의 count값이 0이면 아예 키를 빼버린다
                int val = right.get(c);
                if((val-1) == 0)
                    right.remove(c);
                else
                    right.put(c, val-1);
            }
            
            // left에 뺀 것을 넣는다
            left.put(c, left.getOrDefault(c, 0) + 1);
                        
            // 유니크 캐릭터들의 수를 배교한다(keyset의 크기를 비교하면 됨)
            if(right.keySet().size() == left.keySet().size()) ans++;
        }
        return ans;
    }
}
