// https://leetcode.com/problems/greatest-sum-divisible-by-three/submissions/
// Medium
// Try to make it more efficiently

class Solution {
    public int maxSumDivThree(int[] nums) {
        int sum = 0;
        ArrayList<Integer> rem_one = new ArrayList<Integer>();
        ArrayList<Integer> rem_two = new ArrayList<Integer>();
        
        for(int i = 0; i < nums.length; i++){
            int rem = nums[i] % 3;
            sum += nums[i];
            switch(rem){
                case 1:
                    rem_one.add(nums[i]);
                    break;
                case 2:
                    rem_two.add(nums[i]);
                    break;
                default:
                    break;
            }
        } 
        
        Collections.sort(rem_one); 
        Collections.sort(rem_two); 

        int sumRem = sum % 3;
        int remLeast = 0;
        int remSum = 0;
        
        switch(sumRem){
            case 1:
                if(!rem_one.isEmpty()){
                    remLeast = rem_one.get(0);
                }
                else{
                    remLeast = sum+1;
                }
                
                if(rem_two.size() > 2){
                    remSum = rem_two.get(0) + rem_two.get(1);
                }
                else{
                    remSum = sum+1;
                }
                break;
            
            case 2:
                if(!rem_two.isEmpty()){
                    remLeast = rem_two.get(0);
                }
                else{
                    remLeast = sum+1;
                }
                
                if(rem_one.size() > 2){
                    remSum = rem_one.get(0) + rem_one.get(1);
                }
                else{
                    remSum = sum+1;
                }
                break;
            default:
                break;
                
        }
        
        
        if(remLeast == sum+1 && remSum == sum+1){
            remLeast = 0;
        }
        else{
            if(remLeast > remSum)
                remLeast = remSum;
        }
        sum -= remLeast;
        
        return sum;
        
    }
}


/*
 public int maxSumDivThree(int[] nums) {
        ArrayList<Integer> rem_one = new ArrayList<Integer>();
        ArrayList<Integer> rem_two = new ArrayList<Integer>();
        int sum = 0;
        
        for(int i = 0; i < nums.length; i++){
            int rem = nums[i] % 3;
            switch(rem){
                case 0:
                    sum += nums[i];
                    break;
                case 1:
                    rem_one.add(nums[i]);
                    break;
                case 2:
                    rem_two.add(nums[i]);
                    break;
                default:
                    break;
            }
        }
        
        Collections.sort(rem_one);
        Collections.reverse(rem_one);
        Collections.sort(rem_two);
        Collections.reverse(rem_two);

        while( !rem_one.isEmpty() && !rem_two.isEmpty() ){
            sum += (rem_one.get(0) + rem_two.get(0));
            rem_one.remove(0);
            rem_two.remove(0);
        }
        
        return sum;
    }
*/