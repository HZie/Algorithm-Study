import java.util.*;

class Program {
  public static int[] twoNumberSum(int[] array, int targetSum) {
    int p1 = 0, p2 = array.length-1;
		
		Arrays.sort(array);
		
		while(p1 < p2){
			int num1 = array[p1];
			int num2 = array[p2];
			if(num1 + num2 < targetSum){
				p1++;
				continue;
			}
			else if(num1 + num2 > targetSum){
				p2--;
				continue;
			}
			else{
				int[] ans = new int[2];
				ans[0] = num1; 
				ans[1] = num2;
				return ans;
			}
		}
    return new int[0];
  }
}
