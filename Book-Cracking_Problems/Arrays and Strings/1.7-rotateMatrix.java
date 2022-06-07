// First Idea
// first layer
public void rotateMatrix(int[][] matrix){
  int layer = 0;
  int n = matrix.length-1;
  int index = 0;
  while(n >= 1){
    
    if(index >= n){
      index = 0;
      layer++;
      n--;
    }

    int temp = matrix[layer][layer+index];
    matrix[layer][layer+index] = matrix[layer+index][n];
    matrix[layer+index][n] = matrix[n][n-index];
    matrix[n][n-index] = matrix[n-index][layer];
    matrix[n-index][layer] = temp;
    index++;

  }

}