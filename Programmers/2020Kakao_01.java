// 2번이랑 20번 테스트케이스에서 틀린다
// 뭐가 문제지..

import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = s.length();
        
        for(int i = 1; i <= s.length()/2; i++){  // 자를 크기
            String sub = s.substring(0,i);
            int compCount = 0;
            int compLength = s.length();
            
            // 문자열 비교
            for(int j = i; j + i <= s.length(); j += i ){
                String sub2 = s.substring(j,j+i);
                // 같으면 압축한 횟수 +1
                if(sub.equals(sub2)){
                    compCount++;
                }
                // 다르면 압축한 횟수가 1번 이상이면 압축한만큼 length에서 빼주고 숫자 자릿수 더하기
                if(!sub.equals(sub2)){
                    if(compCount > 0){
                        compLength = compLength - compCount*i;
                        compLength += unitNum(compCount);
                    }
                    // 압축한 횟수 초기화
                    compCount = 0;
                }
                // 다음에 비교할 서브 문자열을 현재 서브문자열로 바꿈
                sub = sub2;
            }
            
            // 마지막까지 중복되는 것이 있었으면 여기서 체크
            if(compCount > 0){
                if(compCount > 0){
                        compLength = compLength - compCount*i;
                        compLength += unitNum(compCount);
                    }
                    compCount = 0;
            }
            
            if(answer > compLength)
                answer = compLength;
        }
        return answer;
    }
    
    public int unitNum(int n){
        int count = 0; 
        while(n > 0){
            n/=10;
            count++;
        }
        return count;
    }
}

/*
// 테스트 케이스는 통과하는데 채점 시에는 틀린 경우가 많다
// 알아서 내꺼에 반하는 테스트케이스를 만들어봐야겠다.
import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = s.length();
        
        for(int i = 1; i <= s.length()/2; i++){  // 자를 크기
            String sub = s.substring(0,i);
            int compCount = 0;
            int compLength = s.length();
            for(int j = i; j + i <= s.length(); j += i ){
                String sub2 = s.substring(j,j+i);
                if(sub.equals(sub2)){
                    compCount++;
                }
                if(!sub.equals(sub2) || j+i >= s.length()){
                    if(compCount != 0)
                        compLength = compLength - compCount*i + 1;
                    compCount = 0;
                }
                sub = s.substring(j,j+i);
            }
            if(answer > compLength)
                answer = compLength;
        }
        return answer;
    }
}
*/