import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Brutal Force 이용
    static int sherlockAndAnagrams(String s) {
        ArrayList<String> substr = new ArrayList<>();
        int size = 1;
        int count = 0;
        
        for(size = 1; size < s.length(); size++){
            for(int i = 0; i <= s.length()-size; i++){
                substr.add(s.substring(i, i+size));
            }
        }
        
        for(int i = 0; i < substr.size(); i++){
            String s1 = substr.get(i);
            for(int j = i+1; j < substr.size(); j++){
                String s2 = substr.get(j);
                if(s1.length() != s2.length())
                    break;
                else if(isAnagram(s1,s2))
                    count++;
            }
        }
        return count;
        
    }
    
    static boolean isAnagram(String s1, String s2){
        char[] s1Array = s1.toCharArray();
        char[] s2Array = s2.toCharArray();
        
        Arrays.sort(s1Array);
        Arrays.sort(s2Array);
        
        return Arrays.equals(s1Array, s2Array);   
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
