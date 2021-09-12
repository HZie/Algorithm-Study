import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        int num = n;
        int rem = 0;
        int exp = 0;
        
        while(true){
            int r = num % k;
            
            if(r == 0){
                if(isPrime(rem)){
                    answer++;
                }
                rem = 0;
                exp = 0;
            }
            else{
                rem += r*Math.pow(10, exp);
                exp++;
            }
            if(num == 0)
                break;
            num /= k;
            
        }
        
        return answer;
    }
    
    public boolean isPrime(int num){
        if(num == 0 || num == 1)
            return false;
        int div = 2;
        while(div <= Math.sqrt(num)){
            if(num % div == 0)
                return false;
            div++;
        }
        return true;
    }
}