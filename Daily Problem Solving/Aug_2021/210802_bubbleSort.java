import java.util.*;

class Program {
  public static int[] bubbleSort(int[] array) {
    // Write your code here.
		boolean isSorted = false;
		while(!isSorted){
			isSorted = true;
			for(int i = 0; i < array.length-1; i++){
				if(array[i] > array[i+1]){
					swap(array, i, i+1);
					isSorted = false;
				}
			}
		}
		
    return array;
  }
	
	public static void swap(int[] array, int idx1, int idx2){
		int temp = array[idx1];
		array[idx1] = array[idx2];
		array[idx2] = temp;
		return;
	}
	
}
