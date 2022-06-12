// First Idea
 // Time: O(N^2), Space: O(1)

/*
1. Make layer and calculate relationship between each indexes that will be rotated
2. Swap 4 numbers
3. loop until the end

end of layer = 1 (N/2-1) if even
end of layer = 0 (N/2 -1) if odd

example: 4*4

(0,0) (0,1) (0,2) (0,3)
(1,0) (1,1) (1,2) (1,3)
(2,0) (2,1) (2,2) (2,3)
(3,0) (3,1) (3,2) (3,3)

if layer = 0 len = 3 --> outside
swap (0,0) => (3,0) / (0,3) => (0,0) / (3,3) => (0,3) / (3,0) => (3,3) 
swap (0,1) => (2,0) / (1,3) => (0,1) / (3,2) => (1,3) / (2,0) => (3,2)


if layer = 1 len = 2 (next layer) --> inside 
swap (1,1) => (2,1) / (1,2) => (1,1) / (2,2) => (1,2) / (2,1) => (2,2)

len = 3 -> 2 -> 1 -> 0
swap(layer, layer+i) => (len-i , layer) / (layer+i, len) => (layer, layer+i) / (len, len-i) => (layer+i, len) / (len-i, layer) => (len, len-i)

unit : 
3*3 --> 1
4*4 --> 3 => 1
5*5 --> 4 => 2 

example: 3*3
1 2 3     7 4 1
4 5 6  => 8 5 2
7 8 9     9 6 3

(0,0) (0,1) (0,2)      (2,0) (1,0) (0,0)
(1,0) (1,1) (1,2)  =>  (2,1) (1,1) (0,1)
(2,0) (2,1) (2,2)      (2,2) (1,2) (0,2)
 */



import java.util.*;

class Solution {
  public void rotate(int[][] matrix) {
  
    int unit = matrix.length -1;  // 2
    int layer = 0;  
    int len = matrix.length-1;  // 2
    while(unit > 1){
      for(int i = 0; i < unit; i++) {
        int temp = matrix[layer][layer + i];
        matrix[layer][layer+i] = matrix[len-i][layer];
        matrix[len-i][layer] = matrix[len][len-i];  
        matrix[len][len-i] = matrix[layer+i][len];  
        matrix[layer+i][len] = temp;  

      }
      unit -= 2;
      layer++;
      len--;
    }
  }
}