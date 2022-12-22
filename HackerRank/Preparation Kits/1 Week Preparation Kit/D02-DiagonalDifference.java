public static int diagonalDifference(List<List<Integer>> arr) {
  // Write your code here
  int maxIdx = arr.size()-1;
  int sum = 0;
  
  for(int i = 0; i < arr.size(); i++){
      sum += arr.get(i).get(i);
      sum -= arr.get(i).get(maxIdx-i);
  }
  
  return Math.abs(sum);
  }