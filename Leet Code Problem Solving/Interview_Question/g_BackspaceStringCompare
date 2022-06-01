// First Idea:
// O(N) time complexity, O(N) space complexity
import java.util.*;

class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> s_stack = new Stack<>();
        Stack<Character> t_stack = new Stack<>();

        makeStack(s, s_stack);
        makeStack(t, t_stack);

        // O(N)
        while(!s_stack.isEmpty() && !t_stack.isEmpty()){
          if(s_stack.pop() != t_stack.pop())
            return false;
        }
        return true;
    }

    // O(N) --> N: length of string s
    public void makeStack(String s, Stack<Charcter> stack){
      for(int i = 0; i < s.length(); i++){
        char curr = s.charAt(i);
          if(curr == '#') {
            // backspace
            if(stack.isEmpty())
              continue;
            stack.pop();
          }
          stack.put(s.charAt(i));
      }
    }
}

// Second Idea:
// time complexity O(N), space complexity: O(1)
class Solution{
  public boolean backspaceCompare(String s, String t){
    
    // compare from the behind
    // if there's , then delete before one that is not #
    s = deleteChar(s);
    t = deleteChar(t);
    
    if(s.compareTo(t) != 0)
      return false;
    
    return true;
    
  }

  // O(N) --> length of string s
  public String deleteChar(String s){
    StringBuilder sb = new StringBuilder(s);

    int delCount = 0;
    for(int i = sb.length()-1; i >= 0; i--){
      if(sb.charAt(i) == '#'){
        delCount++;
        sb.deleteCharAt(i);
      }
      else if(delCount > 0){
        delCount--;
        sb.deleteCharAt(i);
      }
    }
    return sb.toString();
  }
}

// Solution with Approach #2: Two Pointer

/*
Intuition

When writing a character, it may or may not be part of the final string depending on 
how many backspace keystrokes occur in the future.
If instead we iterate through the string in reverse, 
then we will know how many backspace characters we have seen, 
and therefore whether the result includes our character.

Algorithm
Iterate through the string in reverse. 
If we see a backspace character, the next non-backspace character is skipped. 
If a character isn't skipped, it is part of the final answer.
See the comments in the code for more details.
*/

/*
내 접근법은 스트링을 만들고 비교해서 시간이 조금 걸리지만 이 경우 다음 포지션을 찾고 
그 포지션에 있는 스트링이 같은지 아닌지 비교하여 같지 않으면 바로 return해버리기 때문에
내 솔루션보다 더 시간이 적게 걸린다.
또한 내 경우 compareTo()를 사용하여 string을 하나하나 비교하는 단계가 있기 때문에
조금 더 시간이 오래 걸린다.
*/

// Time Complexity: O(M+N) where M,N are the lengths of s and t
// Space Complexity: O(1)

class Solution {
  public boolean backspaceCompare(String S, String T) {
      int i = S.length() - 1, j = T.length() - 1;
      int skipS = 0, skipT = 0;

      while (i >= 0 || j >= 0) { // While there may be chars in build(S) or build (T)
          while (i >= 0) { // Find position of next possible char in build(S)
              if (S.charAt(i) == '#') {skipS++; i--;}
              else if (skipS > 0) {skipS--; i--;}
              else break;
          }
          while (j >= 0) { // Find position of next possible char in build(T)
              if (T.charAt(j) == '#') {skipT++; j--;}
              else if (skipT > 0) {skipT--; j--;}
              else break;
          }
          // If two actual characters are different
          if (i >= 0 && j >= 0 && S.charAt(i) != T.charAt(j))
              return false;
          // If expecting to compare char vs nothing
          if ((i >= 0) != (j >= 0))
              return false;
          i--; j--;
      }
      return true;
  }
}