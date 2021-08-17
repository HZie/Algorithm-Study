import java.util.*;

class Program {

  public int nonConstructibleChange(int[] coins) {
    // Write your code here.
		int curr = 0;
		Arrays.sort(coins);
		int answer = 0;
		
		for(int i = 0; i < coins.length; i++){
			if(coins[i] > curr + 1)
				return curr+1;
			curr += coins[i];
		}
		
    return curr+1;
  }
}
