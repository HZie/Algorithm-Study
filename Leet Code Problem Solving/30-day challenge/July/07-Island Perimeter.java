class Solution {
    public void dfs(int i, int j){
        
    }
    public int islandPerimeter(int[][] grid) {
        int count = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                int cellPer = 0;
                if(grid[i][j] == 1){
                    cellPer = 4;
                    if(i-1 >= 0 && grid[i-1][j] == 1)
                        cellPer--;
                    if(i+1 < grid.length && grid[i+1][j] == 1)
                        cellPer--;
                    if(j-1 >= 0 && grid[i][j-1] == 1)
                        cellPer--;
                    if(j+1 < grid[i].length && grid[i][j+1] == 1)
                        cellPer--;
                }
                count+=cellPer;   
            }
        }
        return count;
    }
}