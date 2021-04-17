// 다음번에는 라이브러리 없이 직접 퀵 정렬을 구현해보는 것으로 해야겠다
import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int i = 0; i < commands.length; i++){
            int start = commands[i][0]-1;
            int end = commands[i][1]-1;
            int thnum = commands[i][2]-1;
            
            int[] temp = new int[end - start + 1];
            for(int t = 0; t < temp.length; t++){
                temp[t] = array[t+start];
            }
            Arrays.sort(temp);
            
            answer[i] = temp[thnum];
        }
        
        return answer;
    }
}

/*
// 다른 사람 코드
import java.util.Arrays;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int i=0; i<commands.length; i++){
            int[] temp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            Arrays.sort(temp);
            answer[i] = temp[commands[i][2]-1];
        }

        return answer;
    }
}
 */