import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = s.length();
        
        for(int i = 1; i <= s.length()/2; i++){  // 자를 크기
            String sub = s.substring(0,i);
            int count = 1;
            int compLength = s.length();
            
            // 문자열 비교
            for(int j = i; j + i <= s.length(); j += i ){
                String sub2 = s.substring(j,j+i);
                // 같으면 압축한 횟수 +1
                if(sub.equals(sub2)){
                    count++;
                }
                // 다르면 압축한 횟수가 1번 이상이면 압축한만큼 length에서 빼주고 숫자 자릿수 더하기
                if(!sub.equals(sub2)){
                    if(count > 1){
                        compLength = compLength - (count-1)*i;
                        compLength += unitNum(count);
                    }
                    // 압축한 횟수 초기화
                    count = 1;
                }
                // 다음에 비교할 서브 문자열을 현재 서브문자열로 바꿈
                sub = sub2;
            }
            
            // 마지막까지 중복되는 것이 있었으면 여기서 체크
            if(count > 1){
                compLength = compLength - (count-1)*i;
                compLength += unitNum(count);
                count = 1;
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