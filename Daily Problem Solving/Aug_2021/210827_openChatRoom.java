import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        ArrayList<String> ans_list = new ArrayList<>();;
        HashMap<String, String> idMap = new HashMap<>();
        
        for(int i = 0; i < record.length; i++){
            String[] r_split = record[i].split(" ");
            if(r_split.length == 2)
                continue;
            idMap.put(r_split[1], r_split[2]);
        }
        
        for(int i = 0; i < record.length; i++){
            String[] r_split = record[i].split(" ");
            char stat = r_split[0].charAt(0);
            String nickname = idMap.get(r_split[1]);
            
             switch(stat){
                case 'E':
                    ans_list.add(nickname+"님이 들어왔습니다.");
                    break;
                case 'L':
                    ans_list.add(nickname+"님이 나갔습니다.");
                    break;
            }
        }
        
        String[] answer = new String[ans_list.size()];
        for(int i = 0; i < answer.length; i++){
            answer[i] = ans_list.get(i);
        }
        
        return answer;
    }
}