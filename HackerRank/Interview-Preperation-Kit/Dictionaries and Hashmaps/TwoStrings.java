import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // 중복을 없애기 위해 hashset에 일단 넣어준다.
    // 그러면 중복되는 것이 없어지기 때문에 중복이 많을 경우 비교 횟수가 줄어든다.
    // Complete the twoStrings function below.
    static String twoStrings(String s1, String s2) {
        HashSet<String> set = new HashSet<>(Arrays.asList(s1.split("")));
        set.remove("");
        ArrayList<String> list = new ArrayList<>(set);
        
        for(int i = 0; i < list.size(); i++){
            if(s2.contains(list.get(i)))
                return "YES";
        }
        return "NO";
    }
    
    /*
    // TLE substring 크기가 1인게 들어있지 않으면 그거보다 큰 사이즈의 
    // substring도 들어있지 않기 때문에 가능
    static String twoStrings(String s1, String s2) {
        
        for(int i = 0; i < s1.length(); i++){
            if(s2.contains(s1.substring(i,i+1)))
                return "YES";
        }
        return "NO";
    }
    */
    
    /*
    // TLE
    static String twoStrings(String s1, String s2) {
        int size = 1;
        
        while(size <= s1.length()){
            for(int i = 0; i <= s1.length()-size; i++){
                if(s2.contains(s1.substring(i, i+size))){
                    return "YES";
                }
            }
            size++;
        }
        return "NO";

    }
    */
    
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s1 = scanner.nextLine();

            String s2 = scanner.nextLine();

            String result = twoStrings(s1, s2);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
