import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        HashSet<String> report_withoutDup = new HashSet<>();
        HashMap<String, Integer> reportNum = new HashMap<>();
        HashMap<String, ArrayList<String>> rUsers = new HashMap<>();
        HashMap<String, Integer> uList = new HashMap<>();
        ArrayList<String> reportedUser = new ArrayList<>();

        
        for(int i = 0; i < id_list.length; i++){
            uList.put(id_list[i], i);
        }
        
        for(int i = 0; i < report.length; i++){
            if(report_withoutDup.contains(report[i]))
                continue;
            report_withoutDup.add(report[i]);
            String rUser = report[i].split(" ")[1];
            String mUser = report[i].split(" ")[0];
            
            if(!rUsers.containsKey(rUser)){
                rUsers.put(rUser, new ArrayList<String>());
            }
            
            ArrayList list = rUsers.get(rUser);
            list.add(mUser);
            rUsers.put(rUser, list);
            
            if(reportedUser.contains(rUser))
                continue;
            int rNum = reportNum.getOrDefault(rUser, 0);
            rNum += 1;
            reportNum.put(rUser, rNum);

            if(rNum >= k)
                reportedUser.add(rUser);
        }
        
        for(int i = 0; i < reportedUser.size(); i++){
            ArrayList<String> list = rUsers.get(reportedUser.get(i));
            for(String s: list){
                answer[uList.get(s)]++;
            }
        }
        
        return answer;
    }
}