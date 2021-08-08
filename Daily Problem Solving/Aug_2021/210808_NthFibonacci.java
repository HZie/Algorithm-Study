import java.util.*;

class Program {
  public static int getNthFib(int n) {
		if(n == 1)
			return 0;
		else if(n == 2)
			return 1;
		int[] fib = new int[n+1];
		fib[1] = 0;
		fib[2] = 1;
		
		for(int i = 3; i < fib.length; i++){
			fib[i] = fib[i-1] + fib[i-2];
		}
		
    return fib[n];
  }
}
