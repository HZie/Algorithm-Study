// 다른 분의 코드를 참고하여 작성한 것
import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 1;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int temp:priorities){
            pq.add(temp);
        }
        
        while(!pq.isEmpty()){
            for(int i = 0; i < priorities.length; i++){
                if(priorities[i] == pq.peek()){
                    if(i == location)
                        return answer;
                    
                    pq.poll();
                    answer++;
                }
            }
        }
        
        return answer;
    }
}

/*
// 프로그래머스에 올라와있는 코드
// 애초에 이게 내가 생각했던 코드긴 하다
// 근데 위의 코드가 더 깔끔하고 좋아보여서 위에꺼로 공부했다

import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int l = location;

        Queue<Integer> que = new LinkedList<Integer>();
        for(int i : priorities){
            que.add(i);
        }

        Arrays.sort(priorities);
        int size = priorities.length-1;



        while(!que.isEmpty()){
            Integer i = que.poll();
            if(i == priorities[size - answer]){
                answer++;
                l--;
                if(l <0)
                    break;
            }else{
                que.add(i);
                l--;
                if(l<0)
                    l=que.size()-1;
            }
        }

        return answer;
    }
}

*/