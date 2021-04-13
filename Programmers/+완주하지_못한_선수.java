import java.util.*;

class Solution{
    public String solution(String[] participant, String[] completion){
        String answer = "";
        
        Arrays.sort(participant);
        Arrays.sort(completion);
        
        for(int i = 0; i < completion.length; i++){
            if(!participant[i].equals(completion[i])){
                answer = participant[i];
                break;
            }
        }
        
        if(answer.equals("")){
            answer = participant[participant.length - 1];
        }
        
        return answer;
    }
}


// 런타임에러
/*
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        // O(N)
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < completion.length; i++){
            String currName = completion[i];
            
            if(map.containsKey(currName)){
                map.put(currName, map.get(currName+1));
            }
            
            else{
                map.put(currName, 1);
            }
            
        }
        
        for(int i = 0; i < participant.length; i++){
            String currName = participant[i];
            
            if(!map.containsKey(currName)){
                answer = currName;
            }
            
            else {
                if(map.get(currName) == 1){
                    map.remove(currName);
                }
                else{
                    map.put(currName, map.get(currName) - 1);
                }
            }
        }
        
        return answer;
    }
}
*/