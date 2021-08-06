import java.util.*;

class Program {
  public static int binarySearch(int[] array, int target) {
    // Write your code here.
		int startIdx = 0, endIdx = array.length-1;
		while(startIdx < endIdx){
			int midIdx = (startIdx + endIdx)/2;
			int mid = array[midIdx];
			if(mid == target){
				return midIdx;
			}
			else if(mid < target){
				startIdx = midIdx+1;
			}
			else{
				endIdx = midIdx-1;
			}
		}
		
		if(startIdx == endIdx && array[startIdx] == target){
			return startIdx;
		}
		
    return -1;
  }
	
}
