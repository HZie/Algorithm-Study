import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        String[] answer = {};
        HashMap<String, String> map = new HashMap<>();
        ArrayList<String> log = new ArrayList<>();


        for(int i = 0; i < record.length; i++){
            String[] parsed = record[i].split(" ");
            String text = "";
            if(!map.containsKey(parsed[1])){
                map.put(parsed[1], parsed[2]);
            }

            switch(parsed[0]){
                case "Enter":
                    if(map.get(parsed[1]).compareTo(parsed[2])!=0){
                        map.put(parsed[1], parsed[2]);
                    }
                    text = parsed[1]+"/님이 들어왔습니다.";
                    log.add(text);
                    break;
                case "Leave":
                    text = parsed[1] +"/님이 나갔습니다.";
                    log.add(text);
                    break;
                case "Change":
                    map.put(parsed[1], parsed[2]);
                    break;
                default:
                    break;
            }
        }

        answer = new String[log.size()];
        for(int i = 0; i < log.size(); i++){
            String[] parsed = log.get(i).split("/");
            answer[i] = map.get(parsed[0])+parsed[1];
            //System.out.println(answer[i]);
        }

        return answer;
    }
}
