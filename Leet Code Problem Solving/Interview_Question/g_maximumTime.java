class Solution{
    public String maximumTime(String input){
        String answer = "";

        if(input.charAt(0) == '?')
            answer += "2";
        else
            answer += input.charAt(0);
        
        if(input.charAt(1) == '?'){
            if(answer.charAt(0) == '2')
                answer += '3';
            else
                answer += '9';
        }
        else
            answer += input.charAt(1);

        answer += input.charAt(2);

        if(input.charAt(3) == '?')
            answer += '5';
        else
            answer += input.charAt(3);

        if(input.charAt(4) == '?')
            answer += 9;
        else
            answer += input.charAt(4);

    }
}