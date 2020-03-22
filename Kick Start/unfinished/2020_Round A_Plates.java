import java.util.*;


public class Solution{
    
    public static int cmpMax(int a, int b){
        if(a > b){
            return a;
        }
        return b;
    }
    
    public static int getMax(int[][] bv, int p, int index, int stack, int max){
        if(p = 0){
            return max;
        }
        int sum = 0;
        
        sum = bv[stack][index] + bv[stack+1][p - (index+1) -1]
        
        
        return getMax(bv, index, stack, n, max);
    }
    
    
    
    public static void main(String args[]){
        int t;  // test case
        Scanner sc = new Scanner(System.in);
        
        t = sc.nextInt();
        
        for(int j = 1; j <= t; j++){
            int n = sc.nextInt();   // stacks of plates
            int k = sc.nextInt();   // each stack contains k plates
            int p = sc.nextInt();   // take p plates
            
            int[][] bv = new int[n][k];  // beatuy balue of each stack of plates

            
            for(int h = 0; h < n; h++){
                bv[h][0] = sc.nextInt();
                for(int i = 1; i < k; i++){
                    bv[h][i] = bv[h][i-1] + sc.nextInt();
                }
            }
           
           int max = 0;
           
           for(int i = 0; i <= n*k - p + 1; i++){
               int stack = i/k;
               int index = i;
               if(i >= k){
                   index = i - k;
               }
               
               int last_p = p - index + 1;
               int sum = bv[stack][index] + bv[ind]
               
               
           }

            
            
            
            
            
            
            System.out.println("Case #"+j+": " + ans);
        }
    }
}