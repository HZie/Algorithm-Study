import java.util.*;

public class Solution{
    
    public static void main(String args[]){
        int t;  // test case
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        
        for(int j = 1; j <= t; j++){    // O(t)
            int n,p;    // n: num of students, p: num of students to pick
            
            n = sc.nextInt();
            p = sc.nextInt();
            
            ArrayList<Integer> stdnt_skill = new ArrayList<>();
            
            for(int i = 0; i < n; i++){ // O(n)
                stdnt_skill.add(sc.nextInt());
            }
            
            
            Collections.sort(stdnt_skill, Collections.reverseOrder());
            
            int min = 0;
            for(int i = 1; i <= p-1; i++){   // O(p)
                min += (stdnt_skill.get(0) - stdnt_skill.get(i));
                
            }
            
            int sum = min;
            
            for(int i = 1; i <= n-p; i++){  // O(n-p)
                sum -= (stdnt_skill.get(i-1) - stdnt_skill.get(i)) * (p-1);
                sum += (stdnt_skill.get(i) - stdnt_skill.get(i+p-1));
                
                if(min > sum){
                    min = sum;
                }
            }
            
            
            System.out.println("Case #"+j+": " + min);
        }
    }
}