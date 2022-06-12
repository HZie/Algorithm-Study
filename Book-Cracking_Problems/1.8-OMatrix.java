
public int[][] OMatrix(int[][] matrix){
  int n = matrix.length;
  HashSet<Integer> rowSet = new HashSet<>();
  HashSet<Integer> colSet = new HashSet<>();

  // O(n^2)
  for(int i = 0; i < n; i++){
    for(int j = 0; j < n; j++){
      if(matrix[i][j] == 0){
        rowSet.put(i);
        colSet.put(j);
      }
    }
  }

  int[][] newMatrix = new int[n][n];

  for(int i = 0; i < n; i++){
    for(int j = 0; j < n; j++){
      if(!rowSet.contains(i) && !colSet.contains(j)){
        newMatrix[i][j] = matrix[i][j];
      }
    }
  }

  return newMatrix;

}