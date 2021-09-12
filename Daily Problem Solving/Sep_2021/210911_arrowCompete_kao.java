import java.util.*;

class Solution {
    int maxDiff = 0;
    public int[] solution(int n, int[] info) {
        int[] answer = new int[11];
        answer[10] = n;
        int a_score = 0;
        int l_score = 0;
        
        for(int i = 0; i < info.length; i++){
            if(info[i] > 0)
                a_score += (10-i);
        }
        
        dfs(info, 0, 0, a_score, l_score, n, answer);
        
        if(answer[10] == n){
            int[] nope = {-1};
            return nope;
        }
        
        return answer;
    }
    
    public void dfs(int[] info, long curr, int currIdx, int a_score, int l_score, int remArrow, int[] answer){
        if(remArrow <= 0 || currIdx >= 10){
            int diff = l_score - a_score;
            if(diff <= 0)
                return;
            if(remArrow<=0)
                curr *= Math.pow(10, 10-currIdx);
            else
                curr += remArrow;
            if(maxDiff < diff){
                for(int i = 10; i >= 0; i--){
                    answer[i] = (int)(curr % 10);
                    curr /= 10;
                }
                maxDiff = diff;
            }
            return;
        }
        
        int s = 10-currIdx;
        dfs(info, curr*10, currIdx+1, a_score, l_score, remArrow, answer);
        if(remArrow >= info[currIdx]+1){
            curr += info[currIdx]+1;
            remArrow -= (info[currIdx]+1);
            if(info[currIdx] != 0)
                a_score -= s;
            dfs(info, curr*10, currIdx+1, a_score, l_score+s, remArrow, answer);
        }
    }
}