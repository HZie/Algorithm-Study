class Solution {
    public int solution(String s) {
        int answer = 0;
        
        String str = "";
        int strStart = 0;
        
        for(int i = 1; i <= s.length(); i++){
            if(strStart >= s.length())
                break;
            if(s.charAt(i-1) >= '0' && s.charAt(i-1) <= '9'){
                answer *= 10;
                answer += s.charAt(i-1) - '0';
                strStart = i;
                continue;
            }
                
            str = s.substring(strStart, i);
            
            if(dictionary(str) != -1){
                answer *= 10;
                answer += dictionary(str);
                strStart = i;
                continue;
            }
            
        }
        
        return answer;
    }
    
    public int dictionary(String s){
        int result = -1;
        switch(s){
            case "zero":
                result = 0;
                break;
            case "one":
                result = 1;
                break;
            case "two":
                result = 2;
                break;
            case "three":
                result = 3;
                break;
            case "four":
                result = 4;
                break;
            case "five":
                result = 5;
                break;
            case "six":
                result = 6;
                break;
            case "seven":
                result = 7;
                break;
            case "eight":
                result = 8;
                break;
            case "nine":
                result = 9;
                break;
            default:
                break;
        }
        
        return result;
    }
}