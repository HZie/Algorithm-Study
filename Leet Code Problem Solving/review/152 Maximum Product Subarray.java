// https://leetcode.com/problems/maximum-product-subarray/
// medium
// time complexity: O(n)
// space complexity: O(1)
// without looking case #2, try to solve it by yourself

class Solution {
    public int maxProduct(int[] nums) {
       //case 2: dynamic programming
        
        int max = nums[0];
        int prod_max = 1;
        int prod_min = 1;
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] < 0){
                //swap
                int temp = prod_max;
                prod_max = prod_min;
                prod_min = temp;
            }
            
            prod_max = max(prod_max * nums[i], nums[i]);
            prod_min = min(prod_min * nums[i], nums[i]);
            
            if(max < prod_max){
                max = prod_max;
            }
            
        }
        
        return max;
    }
    
    
    public int max(int a, int b){
        if(a > b)
            return a;
        return b;
    }
    
    public int min(int a, int b){
        if(a < b)
            return a;
        return b;
    }
    
}

/*
case #1: brute force
time complexity: O(n^2)
space complexity: O(1)

   public int maxProduct(int[] nums) {
        
        int max = nums[0];
        int product;
        
        for(int i = 0; i < nums.length; i++){
            product = 1;
            for(int j = i; j < nums.length; j++){
                product *= nums[j];
                if(max < product){
                    max = product;
                }
            }   
        }
        
        return max;
    }
*/