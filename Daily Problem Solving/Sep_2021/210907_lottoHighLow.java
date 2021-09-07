// https://programmers.co.kr/learn/courses/30/lessons/77484

import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        
        // O(NlogN)
        Arrays.sort(lottos);
        Arrays.sort(win_nums);
        
        int zeroNum = 0;
        int winNumIdx = 0;
        int lottoIdx = 0;
        int exactCorrect = 0;
        
        // O(N)
        while(lottoIdx < lottos.length && winNumIdx < win_nums.length){
            int lNum = lottos[lottoIdx];
            int wNum = win_nums[winNumIdx];
            
            if(lNum == 0){
                zeroNum++;
                lottoIdx++;
                continue;
            }
            
            if(lNum == wNum){
                exactCorrect++;
                lottoIdx++;
            }
            else if(lNum < wNum){
                lottoIdx++;
            }
            else{
                winNumIdx++;
            }
        }
        
        answer[0] = getResult(zeroNum + exactCorrect);
        answer[1] = getResult(exactCorrect);
        
        return answer;
    }
    
    public int getResult(int num){
        if(num > 6)
            num = 6;
        
        int value = 6;
        switch(num){
            case 6:
                value = 1;
                break;
            case 5:
                value = 2;
                break;
            case 4:
                value = 3;
                break;
            case 3:
                value = 4;
                break;
            case 2:
                value = 5;
                break;
            default:
                break;
        }
        
        return value;
    }
}