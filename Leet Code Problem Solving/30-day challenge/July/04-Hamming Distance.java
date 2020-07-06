// Time: O(n)
// Space: O(1)
// bit 연산을 쓰면 linear하게 나온다.

class Solution {
    public int[] toBinary(int num, int size){
        int bin[] = new int[size];
        int i = size - 1;
        while(i >= 0){  // O(n)
            bin[i] = num % 2;
            num /= 2;
            i--;
        }
        return bin;
    }
    
    public int hammingDistance(int x, int y) {
        int count = 0;
        int size = 0;
        int tmp = Math.max(x,y);
        while(tmp != 0){
            size++;
            tmp /= 2;
        }
        int[] arrX = toBinary(x,size);
        int[] arrY = toBinary(y,size);
        
        for(int i = 0; i < size; i++){  // O(n)
            if(arrX[i] != arrY[i])
                count++;
        }
        return count;
    }
}