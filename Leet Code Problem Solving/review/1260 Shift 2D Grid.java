// https://leetcode.com/problems/shift-2d-grid/
// easy
class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        int m = grid.length;
        int n = grid[0].length;
        
        int row_move = (k / n) % m;
        int column_move = k % n;
        
        for(int i = 0; i < m; i++){
            List<Integer> sub = new ArrayList<Integer>();
            for(int j = 0; j < n; j++){
                int row_index = i;
                int column_index = j;
                
                row_index = row_index - row_move;
                column_index = column_index - column_move;
                
                if(column_index < 0){
                    column_index = n + column_index;
                    row_index--;
                }
                if(row_index < 0){
                    row_index = m + row_index;
                }
                sub.add(grid[row_index][column_index]);
            }
            ans.add(sub);
        }
        
        return ans;
    }
}
// time complexity: O(m*n)
// space complexity: O(1)