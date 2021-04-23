class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        // dfs로 풀 수 있을 것 같다
        boolean[] visited = new boolean[n];

        for(int i = 0; i < n; i++){
            if(visited[i] == false){
                answer++;
                dfs(i, visited, computers);
            }
        }
        
        return answer;
    }
    
    public void dfs(int i, boolean[] visited, int[][] computers){
        if(i >= visited.length) return;
        
        visited[i] = true;
        for(int j = 0; j < computers[i].length; j++){
            if(visited[j] == false && computers[i][j] == 1){
                dfs(j, visited, computers);
            }
        }
        
    }
}