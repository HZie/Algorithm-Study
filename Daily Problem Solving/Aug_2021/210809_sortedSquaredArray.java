import java.util.*;

class Program {

  public int[] sortedSquaredArray(int[] array) {
    // Write your code here.
		
		int len = array.length;
		int[] answer = new int[len];
		int frontIdx = 0, tailIdx = len-1;
		int answerIdx = len-1;
		
		int frontSq = array[0] * array[0];
		int tailSq = array[len-1] * array[len-1];
				
		while(frontIdx <= tailIdx){
			if(frontSq > tailSq){
				answer[answerIdx] = frontSq;
				frontIdx++;
			 	frontSq = array[frontIdx] * array[frontIdx];
			}
			else{
				answer[answerIdx] = tailSq;
				tailIdx--;
				if(tailIdx < 0)
					tailSq = -1;
				else
					tailSq = array[tailIdx] * array[tailIdx];

			}
			answerIdx--;
		}
    return answer;
  }
}
