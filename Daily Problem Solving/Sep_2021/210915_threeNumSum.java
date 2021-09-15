import java.util.*;

class Program {
  public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
    // Write your code here.
		ArrayList<Integer[]> answer = new ArrayList<>();
		
		Arrays.sort(array);
		
		for(int i = 0; i < array.length-2; i++){
			for(int j = array.length-1; j >= i+2; j--){
				int sum = targetSum;
				sum -= array[i];
				sum -= array[j];
				int midNum = findMidNum(sum, i, j, array);
				if(midNum == -1)
					continue;
				else{
					Integer[] n_arr = new Integer[3];
					n_arr[0] = array[i];
					n_arr[1] = array[midNum];
					n_arr[2] = array[j];
					answer.add(n_arr);
				}
			}
		}
		
    return answer;
  }
	
	public static int findMidNum(int target, int s, int e, int[] arr){
		for(int i = s+1; i < e; i++){
			if(arr[i] == target)
				return i;
		}
		return -1;
	}
}
