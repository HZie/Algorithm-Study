import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> idxStack = new Stack<>();
        
        // 각 인덱스를 스택에 넣어준다
        int i = 0;
        idxStack.push(i);
        
        for(i = 1; i < prices.length; i++){
            
            // 스택에 들어있는 인덱스가 가리키는 값이 현재 값보다 작으면 answer에 값을 계산해서 넣는다
            while(!idxStack.isEmpty() && prices[i] < prices[idxStack.peek()]){
                int idx = idxStack.pop();
                answer[idx] = i-idx;
            }
            // 현재 인덱스를 스택에 넣는다
            idxStack.push(i);
        }
        
        // price의 끝까지 다 체크했으면 스택에 남아있는 값들을 처리해준다
        while(!idxStack.isEmpty()){
            int idx = idxStack.pop();
            answer[idx] = i - idx - 1;
        }
        
        return answer;
    }
}

/*
// 맞히긴 했는데 스택/큐를 사용하지 않아서 더 효율적인 방법이 있는지 찾아봄
import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        for(int i = 0; i < prices.length; i++){
            for(int j = i+1; j < prices.length; j++){
                answer[i]++;
                if(prices[i] > prices[j])
                    break;
            }
        }
        
        return answer;
    }
}
*/

/*
// 문제 이해를 잘못해서 틀림
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        for(int i = 0; i < prices.length; i++){
            int curr = prices[i];
            for(int j = 0; j < i; j++){
                if(prices[j] <= curr)
                    answer[j]++;
            }
        }
        
        return answer;
    }
}
*/