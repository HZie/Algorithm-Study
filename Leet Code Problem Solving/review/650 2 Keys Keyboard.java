// https://leetcode.com/problems/2-keys-keyboard/submissions/
// Medium
class Solution {
    public int minSteps(int n) {
        if(n == 1){
            return 0;
        }
        int div = n / 2;
        while(n % div != 0){
            div--;
        }
        if(div == 1){
            return n;
        }
        int quot = n / div;
        return quot+minSteps(div);
    }
}
