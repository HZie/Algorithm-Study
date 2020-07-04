// length of array : k, length of iteration: n
// time complexity : O(nk)
// space complexity: O(1)

class Solution {
    public int[] prisonAfterNDays(int[] cells, int N) {
        int[] cur_cells = Arrays.copyOf(cells,cells.length);
        int[] new_cells = new int[8];
        
        if(N % 14 == 0){
            N = 14;
        }
        else
            N = N % 14;
        
         
        for(int j = 0; j < N; j++){ // O(8n)
            for(int i = 0; i < cells.length; i++){  
                if(i == 0 || i == cells.length-1 || cur_cells[i-1] != cur_cells[i+1])
                    new_cells[i] = 0;
                else 
                    new_cells[i] = 1;
                if(i!=0 && i!=cells.length-1){
                }
            }
            cur_cells = Arrays.copyOf(new_cells,new_cells.length);
  
        }
        return cur_cells;
    }
}

// Brute Force
// Time Limit Exceeded
/*
class Solution {
 public int[] prisonAfterNDays(int[] cells, int N) {
     int[] cur_cells = cells;
     int[] new_cells = cells;

     for(int j = 0; j < N; j++){ // O(8n)
         for(int i = 0; i < cells.length; i++){  
             if(i == 0 || i == cells.length-1 || cur_cells[i-1] != cur_cells[i+1])
                 new_cells[i] = 0;
             else 
                 new_cells[i] = 1;
         }
         cur_cells = new_cells;
     }
     return cur_cells;
 }
}
*/