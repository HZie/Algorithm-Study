import java.util.*;

class Program {
  public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
    // Write your code here.
		int arrIdx = 0;
		int seqIdx = 0;
		
		while(seqIdx < sequence.size()){
			if(arrIdx >= array.size())
				return false;
			if(array.get(arrIdx) == sequence.get(seqIdx)){
				seqIdx++;
			}
			arrIdx++;
		}
		
    return true;
  }
}
