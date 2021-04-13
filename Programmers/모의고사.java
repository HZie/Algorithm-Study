import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        
        int s1 = 0, s2 = 0, s3 = 0;
        int max = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        
        for(int i = 0; i < answers.length; i++){
            if(p1(i, answers[i]))
                s1++;
            if(p2(i, answers[i]))
                s2++;
            if(p3(i, answers[i]))
                s3++;
            
            if(max < s1)
                max = s1;
            if(max < s2)
                max = s2;
            if(max < s3)
                max = s3;
        }
        
        if(s1 == max)
            ans.add(1);
        if(s2 == max)
            ans.add(2);
        if(s3 == max)
            ans.add(3);
        
        int[] answer = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++){
            answer[i] = ans.get(i);
        }
        
        return answer;
    }
    
    public boolean p1(int index, int ans){
        int key = (index+1) % 5;
        int studentAns = 0;
        
        switch(key){
            case 1:
                studentAns = 1;
                break;
            case 2:
                studentAns = 2;
                break;
            case 3:
                studentAns = 3;
                break;
            case 4:
                studentAns = 4;
                break;
            case 0:
                studentAns = 5;
                break;
        }
        
        return (studentAns == ans) ? true : false;
    }
    
    public boolean p2(int index, int ans){
        int key = (index+1) % 8;
        int studentAns = 0;
        
        switch(key){
            case 1:
            case 3:
            case 5:
            case 7:
                studentAns = 2;
                break;
            case 2:
                studentAns = 1;
                break;
            case 4:
                studentAns = 3;
                break;
            case 6:
                studentAns = 4;
                break;
            case 0:
                studentAns = 5;
                break;
        }
        
        return (studentAns == ans) ? true : false;
    }
    
    public boolean p3(int index, int ans){
        int key = (index+1) % 10;
        int studentAns = 0;
        
        switch(key){
            case 1:
            case 2:
                studentAns = 3;
                break;
            case 3:
            case 4:
                studentAns = 1;
                break;
            case 5:
            case 6:
                studentAns = 2;
                break;
            case 7:
            case 8:
                studentAns = 4;
                break;
            case 9:
            case 0:
                studentAns = 5;
                break;
        }
        
        return (studentAns == ans) ? true : false;
    }
    
}