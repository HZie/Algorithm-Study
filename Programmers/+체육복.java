import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0; 
        
        int[] stat = new int[n];
        
        for(int i = 0; i < lost.length; i++){
            stat[lost[i]-1]--;
        }
        for(int i = 0; i < reserve.length; i++){
            stat[reserve[i]-1]++;
        }
        
        for(int i = 0; i < stat.length; i++){
            if(stat[i] == -1){
                if(i == 0){
                    if(stat[i+1] == 1){
                        stat[i] = 0;
                        stat[i+1] = 0;
                    }
                }
                else if (i == stat.length - 1){
                    if(stat[i-1] == 1){
                        stat[i] = 0;
                        stat[i-1] = 0;
                    }
                }
                else{
                    if(stat[i-1] == 1){
                        stat[i] = 0;
                        stat[i-1] = 0;
                    }
                    else if(stat[i+1] == 1){
                        stat[i] = 0;
                        stat[i+1] = 0;
                    }
                }
            }
        }
        
        for(int i = 0; i < stat.length; i++){
            if(stat[i] >= 0)
                answer++;
        }
        
        return answer;
    }
}