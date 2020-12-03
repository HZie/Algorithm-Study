// Time complexity: O(n)
// Space complexity: O(1)
// 두 자리수는 요소 2개가 됨
class Solution {
    public int[] plusOne(int[] digits) {
        int lastIdx = digits.length - 1;
        int i = lastIdx;        
        digits[lastIdx]++;
        
        while(digits[i] == 10 && i > 0){
            digits[i] = 0;
            digits[i-1]++;
            i--;
        }
        
        int[] ans;
        if(digits[0] == 10){
            ans = new int[digits.length+1];
            ans[0] = 1;
        }
        else{
            ans = digits;
        }
        
        return ans;
    }
}