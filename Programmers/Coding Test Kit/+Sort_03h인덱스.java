// 문제 이해가 안돼서 좀 애먹었다
// 다음번엔 merge sort를 직접 작성해서 풀어봐야겠다
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

/*
// 프로그래머스 다른 사람 풀이
import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);

        int max = 0;
        for(int i = citations.length-1; i > -1; i--){
            int min = (int)Math.min(citations[i], citations.length - i);
            if(max < min) max = min;
        }

        return max;
    }
}
 */