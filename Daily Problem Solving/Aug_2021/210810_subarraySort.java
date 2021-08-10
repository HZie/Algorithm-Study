import java.util.*;

class Program {
  public static int[] subarraySort(int[] array) {
    // Write your code here.
		int unordered_min = Integer.MAX_VALUE;
		int unordered_max = Integer.MIN_VALUE;
		
		
		for(int i = 1; i < array.length; i++){
			if(unordered_min == Integer.MAX_VALUE && array[i-1] > array[i]){
				unordered_min = array[i];
			}
			else if(unordered_min != Integer.MAX_VALUE){
				unordered_min = Math.min(unordered_min, array[i]);
			}
			if(unordered_max == Integer.MIN_VALUE && array[array.length-i] < array[array.length-i-1]){
				unordered_max = array[array.length-i-1];
			}
			else if(unordered_max != Integer.MIN_VALUE){
				unordered_max = Math.max(unordered_max, array[array.length-i-1]);
			}
			
		}
		
		int startIndex = -1;
		int endIndex = -1;
		
		for(int i = 0; i < array.length; i++){
			if(startIndex != -1 && endIndex != -1)
				break;
			if(startIndex == -1 && array[i] > unordered_min)
				startIndex = i;
			if(endIndex == -1 && array[i] > unordered_max)
				endIndex = i-1;
		}
		
		
		int[] answer = new int[2];
		
		if(startIndex == -1)
			endIndex = -1;
		else if(startIndex != -1 && endIndex == -1)
			endIndex = array.length-1;
		
		answer[0] = startIndex;
		answer[1] = endIndex;
		
    return answer;
  }
}
