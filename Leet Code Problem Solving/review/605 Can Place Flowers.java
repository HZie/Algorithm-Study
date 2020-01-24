// https://leetcode.com/problems/can-place-flowers/submissions/
// Easy
// Try to shorten the code
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        
        for(int i = 0; i < flowerbed.length; i+=2){
            if(flowerbed[i]==1){
                continue;
            }
            else if(flowerbed[i]==0){
                if(i == flowerbed.length-1){
                    if(i == 0){
                        count++;
                    }
                    else if(flowerbed[i-1] == 0){
                    count++;
                    }
                }
                else if(i == 0){
                    if(flowerbed[i+1] == 0)
                        count++;
                }
                else if(i+1 < flowerbed.length){
                    if(flowerbed[i+1] == 0 && flowerbed[i-1] == 0){
                        count++;
                    }
                    else if(flowerbed[i+1] == 1){
                        i--;
                    }
                }
            }
        }
        
        if(n <= count)
            return true;
        else
            return false;
       
        
    }
}