import java.util.*;

class Solution {
    
    
    public String solution(String p) {
        String answer = "";
        String str;
        
        // 빈 문자열이거나 올바른 문자열일 경우 그대로 반환
        if(p.length() == 0 || isCorrect(p))
            return p;
        str = toBalanced(p);    // 일단 균형잡힌 문자열로 변환
        answer = toCorrect(str);    // 올바른 문자열로 변환
        return answer;
    }
    
    // 균형잡힌 문자열로 변환하는 함수
    public String toBalanced(String p){
        int leftCount = 0;
        int rightCount = 0;

        // 문자열 전체를 돌면서 왼쪽 괄호, 오른쪽 괄호 수를 계산
        for(int i = 0; i < p.length(); i++){
            char curr = p.charAt(i);
            if(curr == '(')
                leftCount++;
            else
                rightCount++;
        }

        // 왼쪽과 오른쪽의 괄호수 차이
        int diff = Math.abs(leftCount - rightCount);

        // 왼쪽이 크면 오른쪽에 차이만큼 )를 붙임
        if(leftCount > rightCount){
            for(int i = 0; i < diff; i++)
                p = p + ")";
        }
        // 오른쪽이 크면 왼쪽에 차이만큼 (를 붙임
        else if (leftCount < rightCount){
            for(int i = 0; i < diff; i++)
                p = "(" + p;
        }
        return p;
    }
    
    // 올바른 문자열로 변환하는 함수
    public String toCorrect(String w){
        // 빈 문자열이면 그대로 반환
        if (w.equals(""))
            return w;
        String u, v;

        // u는 최소한의 균형잡힌 문자열, v는 나머지
        int uLastIndex = lastIndexOfBalanced(w);
        u = w.substring(0, uLastIndex);
        v = w.substring(uLastIndex);
        
        // u가 올바른 문자열이라면 재귀적으로 v를 toCorrect하게 하고 u에 붙임
        if(isCorrect(u)){
            u += toCorrect(v);
            return u;
        }
        else{   // u가 올바르지 않다면
            String newStr = "";
            newStr = "(" + toCorrect(v) + ")";
            u = u.substring(1);
            u = u.substring(0, u.length()-1);
            u = flip(u);
            return newStr + u; 
        }
    }
    
    // 최고한의 균형잡힌 문자열의 마지막 index(+1)을 반환
    public int lastIndexOfBalanced(String w){
        int leftCount = 0;
        int rightCount = 0;
        int i = 0;
        // leftCount와 rightCount가 같고 leftCount가 0이 아닐 때 i 반환
        while(leftCount != rightCount || leftCount == 0){
            if(w.charAt(i) == '(')
                leftCount++;
            else
                rightCount++;
            i++;
        }
        return i;
    }
    
    // 올바른 문자열인지 판별하는 함수
    public boolean isCorrect(String s){
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < s.length(); i++){
            char curr = s.charAt(i);
            // 왼쪽 괄호일 경우 스택에 push()
            if(curr == '(')
                stack.push(curr);
            else{
                // 오른쪽 괄호가 있는데 stack이 비어있으면 올바르지 않음
                if(stack.empty())
                    return false;
                // 오른쪽 괄호가 있으므로 왼쪽 괄호 pop()
                stack.pop();
            }

        }

        // 모두 검사했는데 스택이 비어있지 않으면 올바르지 않음
        if(!stack.empty())
            return false;
        else return true;
    }
    
    // 왼쪽 괄호를 오른쪽 괄호로, 오른쪽 괄호를 왼쪽 괄호로 바꿈
    public String flip(String s){
        String flipped = "";
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(')
                flipped += ")";
            else if(s.charAt(i) == ')')
                flipped += "(";
        }
        return flipped;
    }
    
}