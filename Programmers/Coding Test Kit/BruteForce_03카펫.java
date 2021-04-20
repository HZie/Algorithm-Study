import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        // (brown - 4) / 2 -> 노란색을 감싸는 갈색 가로 세로 하나씩 합친 것
        // yellow를 소인수분해 한 후 인수들을 더했을 때 위의 값과 같은 것이 나오면 (그거+2)가 답
        // 단, 가로가 더 길다는 것을 염두에 두어야 함
        int sum = (brown - 4) / 2;
        
        for(int i = 1; i <= Math.sqrt(yellow); i++){
            if(yellow % i!= 0)
                continue;
            int a = i;
            int b = yellow / i;
            if((a+b) == sum){
                answer[0] = b+2;
                answer[1] = a+2;
                break;
            }
        }
        return answer;
    }
}