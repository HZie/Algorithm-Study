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