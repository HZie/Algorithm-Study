// 진심 완전 무식하게 풀었다
import java.util.ArrayList;
class Solution {
    public int[] solution(int[] answers) {
        ArrayList<Integer> anslist = new ArrayList<>();
        int max = 0;
        int[] result = new int[3];
        
        for(int i = 1; i <= 3; i++){
            result[i-1] = correctCount(answers, i);
            max = result[i-1] > max ? result[i-1] : max;
        }
        
        for(int i = 0; i < 3; i++){
            if(result[i] == max)
                anslist.add(i+1);
        }
        
        int[] answer = new int[anslist.size()];
        for(int i = 0; i < anslist.size(); i++){
            answer[i] = anslist.get(i);
        }
        
        return answer;
    }

    public int correctCount(int[] answer, int person){
        int currAns;
        int correct = 0;
        for(int i = 0; i < answer.length; i++){
            switch(person){
                case 1:
                    currAns = rule1(i);
                    break;
                case 2:
                    currAns = rule2(i);
                    break;
                case 3:
                    currAns = rule3(i);
                    break;
                default:
                    currAns = 0;
                    break;
            }
            
            if(answer[i] == currAns)
                correct++;
        }
        return correct;
    }
    
    public int rule1(int pos){
        int ans=0;
        switch((pos%5)+1){
            case 1:
                ans = 1;
                break;
            case 2:
                ans = 2;
                break;
            case 3:
                ans = 3;
                break;
            case 4:
                ans = 4;
                break;
            case 5:
                ans = 5;
                break;
        }
        
        return ans;
    }
    
    public int rule2(int pos){
        int ans=0;
        switch((pos%8)+1){
            case 1:
            case 3:
            case 5:
            case 7:
                ans = 2;
                break;
            case 2:
                ans = 1;
                break;
            case 4:
                ans = 3;
                break;
            case 6:
                ans = 4;
                break;
            case 8:
                ans = 5;
                break;
        }
        return ans;
    }

    public int rule3(int pos){
        int ans=0;
        switch((pos%10)+1){
            case 1:
            case 2:
                ans = 3;
                break;
            case 3:
            case 4:
                ans = 1;
                break;
            case 5:
            case 6:
                ans = 2;
                break;
            case 7:
            case 8:
                ans = 4;
                break;
            case 9:
            case 10:
                ans = 5;
                break;

        }
        return ans;
    }
}