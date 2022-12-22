// https://leetcode.com/problems/sum-of-distances-in-tree/
// Hard
// Need to write code myself

// My Code
// TLE
class Solution {
  boolean[] visit;
  public int[] sumOfDistancesInTree(int n, int[][] edges) {
      int[][] mem = new int[n][n];
      visit = new boolean[n];
      HashMap<Integer, ArrayList<Integer>> child = new HashMap<>();
      
      for(int i = 0; i < n; i++){
          Arrays.fill(mem[i], -1);
      }
      
      for(int i = 0; i < n; i++){
          mem[i][i] = 0;
      }

      for(int i = 0; i < edges.length; i++){
          mem[edges[i][0]][edges[i][1]] = 1;
          mem[edges[i][1]][edges[i][0]] = 1;
      }

      for(int i = 0; i < n; i++){
          for(int j = i+1; j < n; j++){
              if(mem[i][j] < 0){
                  Arrays.fill(visit, false);
                  int res = search(mem, 0, Integer.MAX_VALUE, i, j);
                  mem[i][j] = res;
                  mem[j][i] = res;
              
                  //System.out.println("mem["+i+"]["+j+"]: " + mem[i][j]);
              }
          }
      }

      int[] ans = new int[n];
      for(int i = 0; i < n; i++){
          //System.out.print(i+": ");
          int sum = 0;
          for(int j = 0; j < n; j++){
              //System.out.print(mem[i][j]+" ");
              sum += mem[i][j];
          }
          //System.out.println();
          ans[i] = sum;
      }

      return ans;
  }

  int search(int[][] mem, int sum, int min, int start, int target){
      if(mem[start][target] >= 0){
          return mem[start][target];
      }

      visit[start] = true;
      for(int i = 0; i < mem.length; i++){
          if(!visit[i] && mem[start][i] > 0){
              int res = search(mem, sum, min, i, target);
              if(res > 0){
                  sum = mem[start][i] + res;
                  min = Math.min(sum, min);
              }
          }
      }
      visit[start] = false;
      if(min == Integer.MAX_VALUE)
          return -1;
      return min;
  }
}


// Solution
// https://leetcode.com/problems/sum-of-distances-in-tree/solutions/130611/sum-of-distances-in-tree/
class Solution {
  int[] ans, count;
  List<Set<Integer>> graph;
  int N;
  public int[] sumOfDistancesInTree(int N, int[][] edges) {
      this.N = N;
      graph = new ArrayList<Set<Integer>>();
      ans = new int[N];
      count = new int[N];
      Arrays.fill(count, 1);

      for (int i = 0; i < N; ++i)
          graph.add(new HashSet<Integer>());
      for (int[] edge: edges) {
          graph.get(edge[0]).add(edge[1]);
          graph.get(edge[1]).add(edge[0]);
      }
      dfs(0, -1);
      dfs2(0, -1);
      return ans;
  }

  public void dfs(int node, int parent) {
      for (int child: graph.get(node))
          if (child != parent) {
              dfs(child, node);
              count[node] += count[child];
              ans[node] += ans[child] + count[child];
          }
  }

  public void dfs2(int node, int parent) {
      for (int child: graph.get(node))
          if (child != parent) {
              ans[child] = ans[node] - count[child] + N - count[child];
              dfs2(child, node);
          }
  }
}