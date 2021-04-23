// 다른 사람 코드 참고
import java.util.*;
class Solution{
    boolean[] visit;
    // 아예 루트를 String으로 저장해서 sort한 다음에
    // 가장 먼저 것을 return함
    List<String> list = new ArrayList<>();
    String route = "";

    public String[] solution(String[][] tickets){
        String[] answer = {};
        visit = new boolean[tickets.length];

        for(int i = 0; i < tickets.length; i++){
            String deparature = tickets[i][0];
            String destination = tickets[i][1];

            if(deparature.equals("ICN")){
                visit[i] = true;
                route = deparature + ",";
                dfs(tickets, destination, 1);
                // 모든 변수를 다 찾아보기 위해
                // ex) ["ICN", "COO"], ["ICN", "BOO"]같은 경우
                visit[i] = false;
            }
        }
        Collections.sort(list);
        answer = list.get(0).split(",");

        return answer;
    }

    public void dfs(String[][] tickets, String end, int count){
        route += end + ",";
        
        if(count == tickets.length){
            list.add(route);
            return;
        }

        for(int i = 0; i < tickets.length; i++){
            String depart = tickets[i][0];
            String dest = tickets[i][1];

            if(end.equals(depart) && !visit[i]){
                visit[i] = true;
                dfs(tickets, dest, count+1);
                visit[i] = false;
                // visit[i] = false이므로 넣어줬던 값을 빼줌
                route = route.substring(0, route.length() - 4);
            }
        }
    }
}


/*
// 다른 사람 풀이
import java.util.*;

class Solution {
    List<Stack<String>> result;
    String[][] tickets;

    public String[] solution(String[][] tickets) {
        result = new ArrayList<>();
        this.tickets = tickets;

        boolean[] visited = new boolean[tickets.length];
        Stack<String> st = new Stack<>();
        st.push("ICN");

        dfs(visited, st, 0);

        if (result.size() > 1) {
            Collections.sort(result, new Comparator<Stack<String>>() {
                @Override
                public int compare(Stack<String> o1, Stack<String> o2) {
                    for (int i = 0; i < o1.size(); i++) {
                        String s1 = o1.get(i);
                        String s2 = o2.get(i);

                        if (!s1.equals(s2)) {
                            return s1.compareTo(s2);
                        }
                    }

                    return 0;
                }
            });
        }

        Stack<String> res = result.remove(0);
        String[] answer = new String[res.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = res.get(i);
        }

        return answer;
    }

    public void dfs(boolean[] visited, Stack<String> st, int len) {
        if (len == tickets.length) {
            Stack<String> res = new Stack<>();
            for (String s : st) {
                res.push(s);
            }

            result.add(res);
            return;
        }

        String arrive = st.peek();

        for (int i = 0; i < tickets.length; i++) {
            String[] tic = tickets[i];

            if (!visited[i] && arrive.equals(tic[0])) {
                st.push(tic[1]);
                visited[i] = true;

                dfs(visited, st, len + 1);

                visited[i] = false;
                st.pop();
            }
        }
    }
}
*/


/*
// DFS 사용
// 내가 짠 코드

// 알파벳 검사를 먼저하기 때문에 아래 반례의 경우
// ICN -> BOO -> DOO만 방문하고 모든 장소를 방문하지 않게 된다.
// 이 코드의 반례
// input: [["ICN", "COO"], ["ICN", "BOO"], ["COO", "ICN"], ["BOO", "DOO"]]
// output: ["ICN", "COO", "ICN", "BOO", "DOO"]


import java.util.*;

class Solution {
    public String[] solution(String[][] tickets) {
        ArrayList<String> ans = new ArrayList<>();
        
        ans.add("ICN");
        
        boolean[] used = new boolean[tickets.length];
        
        dfs(tickets, used, 0, 0, ans);
        
        String[] answer = new String[ans.size()];
        
        for(int i = 0; i < ans.size(); i++){
            answer[i] = ans.get(i);
        }
        
        return answer;
    }
    
    public void dfs(String[][] tickets, boolean[] used, int curr, int count,ArrayList<String> ans){
        if(count >= tickets.length){
            return;
        }
        
        System.out.println("curr: " + curr);
        HashMap<String, Integer> map = new HashMap<>();
        ArrayList<String> keylist = new ArrayList<>();
        
        
        for(int i = 0; i < tickets.length; i++){
            
            if(count == 0){
                if(!used[i] && tickets[i][0].equals("ICN")){
                    keylist.add(tickets[i][1]);
                    map.put(tickets[i][1], i);
                    //System.out.println("i: " + i);
                }
            }
            
            else {
                 if(tickets[curr][1].equals(tickets[i][0]) && 
                    !used[i]){
                    keylist.add(tickets[i][1]);
                    map.put(tickets[i][1], i);
                }   
            }
        }
        
        
        if(keylist.size() > 0){
            Collections.sort(keylist);
            String key = keylist.get(0);
            curr = map.get(key);
            used[curr] = true;
            ans.add(key);
            dfs(tickets, used, curr, count+1, ans);     
        }
 
        
    }
    
    
}
*/