// https://leetcode.com/problems/possible-bipartition/description/
// Medium
import java.util.*;

class Solution {
    public int[] visit;
    public boolean possibleBipartition(int n, int[][] dislikes) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        visit = new int[n+1];
        Arrays.fill(visit, -1);
        
        for(int i = 0; i < dislikes.length; i++){
            ArrayList<Integer> list;
            list = map.getOrDefault(dislikes[i][0], new ArrayList<>());
            list.add(dislikes[i][1]);
            map.put(dislikes[i][0], list);
            list = map.getOrDefault(dislikes[i][1], new ArrayList<>());
            list.add(dislikes[i][0]);
            map.put(dislikes[i][1], list);
        }
        
        for(int i = 1; i <= n; i++){
            if(visit[i] == -1){
                if(!dfs(i, 1, map, visit))
                    return false;
            }
        }

        return true;
    }

    public boolean dfs(int node, int groupNum, HashMap<Integer, ArrayList<Integer>> map, int[] visit){
        visit[node] = groupNum;
        if(!map.containsKey(node)){
            //System.out.println("escape node: " + node);
            return true;
        }
            
        for(int adj: map.get(node)){
            //System.out.println("node: " + node +", visit[adj]: " + visit[adj] +"\n");
            if(visit[adj] == visit[node])
                return false;
            if(visit[adj] == -1){
                if(!dfs(adj, 3-groupNum, map, visit))
                    return false;
            }
        }
        //System.out.println("node: " + node);
        return true;
    }

}