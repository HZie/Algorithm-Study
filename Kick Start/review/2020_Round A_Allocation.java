import java.util.*;

public class Solution{
    
    public static void main(String args[]){
        int t;  // test case
        Scanner sc = new Scanner(System.in);
        
        t = sc.nextInt();
        
        for(int j = 1; j <= t; j++){
            int n = sc.nextInt();   // num of house
            int b = sc.nextInt();   // budget
            int[] a = new int[n];   // cost of ith house
            
            for(int i = 0; i < a.length; i++){
                a[i] = sc.nextInt();
            }
            
            Arrays.sort(a);
            
            int ans = 0;
            for(int i = 0; i < a.length; i++){
                b -= a[i];
                
                if(b < 0){
                    break;
                }
                else{
                    ans++;
                }
            }
            
            System.out.println("Case #"+j+": " + ans);
        }
    }
}