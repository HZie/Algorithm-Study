import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        Arrays.sort(citations);
        
        if(citations[citations.length-1] == 0)
            return 0;
        
        for(int i = citations.length - 1; i >= 0; i--){
            if((answer+1) <= citations[i]){
                answer++;
            }
        }
        
        return answer;
    }
}