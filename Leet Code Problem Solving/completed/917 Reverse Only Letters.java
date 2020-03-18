import java.util.*;

class Solution {
    public String reverseOnlyLetters(String S) {
        int i = 0; int j = S.length() - 1;
        char[] S_Char = S.toCharArray();
        while(j > i){
            // i: check characer starting from front, j: starting from behind
            if(checkLetter(S_Char[i]) && checkLetter(S_Char[j])){
                i++; j--;
            }
            
            else{ 
                if(!checkLetter(S_Char[i])){
                    i++;
                }
                if(!checkLetter(S_Char[j])){
                    j--;
                }
            }
        }
        
        return String.valueOf(S_Char);
        
    }
    
    
    public void swap(char[] S_Char, int i, int j){
        char temp;
        temp = S_Char[i];
        S_Char[i] = S_Char[j];
        S_Char[j] = temp;
    }
    
    public boolean checkLetter(char ch){
        if(((int)ch >= (int)'A' && (int)ch <= (int)'Z') ||
              ((int)ch >= (int)'a' && (int)ch <= (int)'z'))
            return true;
        return false;
    }
}

// time complexity: O(n/2)
// space complexity: O(1)