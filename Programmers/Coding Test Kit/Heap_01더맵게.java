import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        Arrays.sort(scoville);
        
        for(int s:scoville)
            pq.add(s);
        
        while(!pq.isEmpty()){
            int a = pq.poll();
            if(a > K)
                return answer;
            if(pq.peek() == null){
                return -1;
            }
            int b = pq.poll();
            
            int new_s = a + b*2;
            answer++;
            pq.add(new_s);
        }
        
        return -1;
    }
}