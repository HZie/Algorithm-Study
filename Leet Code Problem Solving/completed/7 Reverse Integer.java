// https://leetcode.com/problems/reverse-integer/
// Easy

class Solution {
    public int reverse(int x) {
        int answer = 0;
        int temp = x;
        boolean negative = false;
        
        if(x < 0){
            negative = true;
            temp = 0-x;
        }   
        
        while(temp > 0){
            if(!negative && (long)answer * 10 > Integer.MAX_VALUE)
                return 0;
            if(negative && (long)answer * (-10) < Integer.MIN_VALUE)
                return 0;
            
            int r = temp % 10;
            temp /= 10;
            
            answer = answer * 10 + r;
        }
        
        if(negative)
            answer = 0-answer;
        
        return answer;
        
        
    }
}