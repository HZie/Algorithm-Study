// https://leetcode.com/problems/happy-number/
// Easy
// time complexity: O(n)
// space complexity: O(1) 

class Solution {
    public boolean isHappy(int n) {
        ArrayList<Integer> numList = new ArrayList<Integer>();
        boolean happyNumFlag = true;
        int curNum, resNum;
        curNum = n;
        resNum = n;
        
        
        while(true){
            int digit;
            numList.add(resNum);
            curNum = resNum;
            resNum = 0;
            while(curNum != 0){
                digit = curNum % 10;
                curNum /= 10;
                resNum += digit*digit;
            }
            if(resNum == 1){
                happyNumFlag = true;
                break;
            }
            else if(numList.contains(resNum)){
                happyNumFlag = false;
                break;
            }
        }
        
        return happyNumFlag;
    }
}