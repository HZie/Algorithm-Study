import java.util.*;

class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        // dfs를 써볼까
        answer = dfs(0, numbers, target, 0);
        return answer;
    }
    
    public int dfs(int i, int[] numbers, int target, int curr){
        int answer = 0;
        //System.out.println("i: " + i + ", curr: "+curr);
        if(i >= numbers.length){
            if(target == curr){
                return 1;
            }
            return 0;
        }
        
        answer += dfs(i+1, numbers, target, curr + numbers[i]);
        answer += dfs(i+1, numbers, target, curr - numbers[i]);
        
        return answer;
    }
}