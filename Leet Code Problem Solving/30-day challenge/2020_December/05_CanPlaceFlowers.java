// 더 똑똑하게 짜면 좋을 듯
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int max = 0;
        
        
        if(n == 0)
            return true;
        
        if(flowerbed.length == 1){
            if(flowerbed[0] == 1)
                return false;
            else
                return true;
        }
        
        for(int i = 0; i < flowerbed.length; i++){
            if(flowerbed[i] == 0){
                if(i-1 >= 0 && i+1 < flowerbed.length && flowerbed[i-1] == 0 && flowerbed[i+1] == 0){
                    max++;
                    flowerbed[i] = 1;
                }
                else if(i == 0 && i+1 < flowerbed.length && flowerbed[i+1] == 0){
                    max++;
                    flowerbed[i] = 1;
                }
                else if(i == flowerbed.length-1 && i-1 >= 0 && flowerbed[i-1] == 0){
                    max++;
                    flowerbed[i] = 1;
                }
            }
        }
        
        if(max < n)
            return false;
        return true;
        
    }
}