import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
        int result = -1000;
        for(int i = 0; i <= arr.length-3; i++){
            for(int j = 0; j <= arr[i].length-3; j++){
                int sum = hourglass(arr, i, j);
                result = result < sum ? sum : result;
            }
        }
        return result;
    }
    
    static int hourglass(int[][] arr, int startX, int startY){
        int sum = 0;
        sum = arr[startX][startY] + arr[startX][startY+1] + arr[startX][startY+2];
        sum = sum + arr[startX+1][startY+1];
        sum = sum + arr[startX+2][startY] + arr[startX+2][startY+1] + arr[startX+2][startY+2];
        return sum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
