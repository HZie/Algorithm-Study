import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

// 시작하는 인덱스에 +k를 하고 끝나는 인덱스 바로 뒤에 -k를 함
// 이렇게 만든 sum 배열을 가지고 sum에 들어있는 값을 차례차례 더해나가면
// 정답이 나옴

// Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] queries) {
        long[] sum = new long[n+1];
        int a,b,k;
        
        for(int[] q: queries){
            a = q[0]-1;
            b = q[1]-1;
            k = q[2];
            sum[a] += k;
            sum[b+1] -= k;
        }
        
        long max = 0;
        long curr = 0;
        for(int i = 0; i < n; i++){
            curr += sum[i];
            max = Math.max(curr, max);
        }

        return max;
    }


/*
    // TLE 
    // Brutal Force
    static long arrayManipulation(int n, int[][] queries) {
        long[] sum = new long[n];
        int a,b,k;
        long max = 0;
        
        for(int[] q: queries){
            a = q[0];
            b = q[1];
            k = q[2];
            for(int i = a-1; i < b; i++){
                sum[i] += k;
                max = Math.max(sum[i], max);
            }
        }

        return max;
    }
*/
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        long result = arrayManipulation(n, queries);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

