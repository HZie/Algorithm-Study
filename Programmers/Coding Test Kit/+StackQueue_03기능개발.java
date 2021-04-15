// 큐를 이용한 다른 사람의 코드
// 아이디어는 전체적으로 비슷하다
// 내가 짠 코드에서 for 루프가 하나 없어진 것과 같기 때문에
// 이 코드가 조금 더 효율적이다

import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();
        List<Integer> answerList = new ArrayList<>();

        for (int i = 0; i < speeds.length; i++) {
            double remain = (100 - progresses[i]) / (double) speeds[i];
            int date = (int) Math.ceil(remain);

            if (!q.isEmpty() && q.peek() < date) {
                answerList.add(q.size());
                q.clear();
            }

            q.offer(date);
        }

        answerList.add(q.size());

        int[] answer = new int[answerList.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }
}


/*
// Brute Force
// 통과는 하였으나 스택/큐를 사용하지 않음

import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> ans = new ArrayList<>();
        int[] remain = new int[progresses.length];
                
        for(int i = 0; i < progresses.length; i++){
            remain[i] = (int)Math.ceil((100.0-progresses[i]) / speeds[i]);
        }
        
        int count = 0;
        int max=remain[0], curr=remain[0];
        
        for(int i = 0; i < remain.length; i++){
            curr = remain[i];
            
            if(curr > max){
                ans.add(count);
                count = 0;
            }
            count++;
            
            max = max < curr ? curr : max;
            
        }
        
        if(count != 0)
            ans.add(count);
        
        int[] answer = new int[ans.size()];
        for(int i = 0; i < answer.length; i++){
            answer[i] = ans.get(i);
        }
        
        return answer;
    }
}

 */

/*
// 테스트케이스 1, 8, 11만 통과
// 문제 이해를 잘못한 거였음
// 이거 보고 이해함: https://programmers.co.kr/questions/9495
import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> ans = new ArrayList<>();
        int[] remain = new int[progresses.length];
                
        for(int i = 0; i < progresses.length; i++){
            remain[i] = (int)Math.ceil((100.0-progresses[i]) / speeds[i]);
        }
        
        int count = 0;
        int prev=remain[0], curr=remain[0];
        
        for(int i = 0; i < remain.length; i++){
            curr = remain[i];
            if(curr > prev){
                ans.add(count);
                count = 0;
            }
            count++;
            
            prev = curr;
        }
        
        if(count != 0)
            ans.add(count);
        
        int[] answer = new int[ans.size()];
        for(int i = 0; i < answer.length; i++){
            answer[i] = ans.get(i);
        }
        
        return answer;
    }
}

 */