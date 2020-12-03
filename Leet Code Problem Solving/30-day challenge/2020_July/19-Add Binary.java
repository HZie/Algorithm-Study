// 끝에서부터 하나씩 더하는 코드인데 좀 보기는 더럽다. 더 깔끔하고 좋은 방법이 있을 것 같다.
// Time: O(N) (N = max(a.length, b.length);
// Space: O(1)
class Solution {
    
    public String addBinary(String a, String b) {
        boolean carry = false;
        String ans = "";
        int aIdx = a.length()-1, bIdx = b.length()-1;
        while(aIdx >= 0 || bIdx >= 0){
            int aNum = -1, bNum = -1;
            if(aIdx >= 0)
                aNum = a.charAt(aIdx) - '0';
            if(bIdx >= 0)
                bNum = b.charAt(bIdx) - '0';
            int numSet = 0;
            
            if(aNum != -1 && bNum == -1){
                if(!carry){
                    numSet = aNum;
                }
                else{
                    if(aNum == 1){
                        carry = true;
                        numSet = 0;
                    }
                    else{
                        carry = false;
                        numSet = 1;
                    }
                }
            }
            else if(aNum == -1 && bNum != -1){
                if(!carry){
                    numSet = bNum;
                }
                else{
                    if(bNum == 1){
                        carry = true;
                        numSet = 0;
                    }
                    else{
                        carry = false;
                        numSet = 1;
                    }
                }
            }
            else if(aNum == -1 && bNum == -1)
                break;
            else if(aNum == bNum){
                if(!carry){
                    if(aNum == 1){
                        carry = true;
                    }
                    numSet = 0;
                }
                else{
                    if(aNum == 0){
                        carry = false;
                    }
                    else{
                        carry = true;
                    }
                    numSet = 1;

                }
            }
            else if(aNum != bNum){
                if(carry){
                    numSet = 0;
                    carry = true;
                }
                else{
                    numSet = 1;
                    carry = false;
                }
            }
            ans = Integer.toString(numSet) + ans;
            aIdx--; bIdx--;
        }
        
        if(carry){
            ans = Integer.toString(1) + ans;
        }
        return ans;
        
    }
}
