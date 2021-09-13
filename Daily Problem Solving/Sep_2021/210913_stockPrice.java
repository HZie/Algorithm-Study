import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> idxStack = new Stack<>();
        
        int i = 0;
        idxStack.push(i);
        
        for(i = 1; i < prices.length; i++){
            
            while(!idxStack.isEmpty() && prices[i] < prices[idxStack.peek()]){
                int idx = idxStack.pop();
                answer[idx] = i-idx;
            }
            idxStack.push(i);
        }
        
        while(!idxStack.isEmpty()){
            int idx = idxStack.pop();
            answer[idx] = i - idx - 1;
        }
        
        return answer;
    }
}