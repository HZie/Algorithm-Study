// Try to solve it without hints
// Time: O(n)
// Space: O(1)
class Solution {
    
    public int nthUglyNumber(int n) {
        int idx2 = 0;
        int idx3 = 0;
        int idx5 = 0;
        ArrayList<Integer> uglyNum = new ArrayList<Integer>();
        uglyNum.add(1);
        
        for(int i = 1; i < n; i++){	
            while(uglyNum.get(idx2)*2 <= uglyNum.get(i-1))
                idx2++;
            while(uglyNum.get(idx3)*3 <= uglyNum.get(i-1))
                idx3++;
            while(uglyNum.get(idx5)*5 <= uglyNum.get(i-1))
                idx5++;
            
            int prod2 = uglyNum.get(idx2)*2;
            int prod3 = uglyNum.get(idx3)*3;
            int prod5 = uglyNum.get(idx5)*5;
            
            int fin = Math.min(prod2, Math.min(prod3,prod5));
            uglyNum.add(fin);
            
        }
        return uglyNum.get(n-1);
        
    }
}