import java.util.*;

class Solution {
    public int solution(String numbers) {
        int answer = 0;
        int[] nums = new int[numbers.length()];
        
        for(int i = 0; i < nums.length; i++){
            nums[i] = numbers.charAt(i) - '0';
        }
        
        int[] comp = composeNum(nums);
        
        for(int i = 0; i < comp.length; i++){
            if(isPrime(comp[i]))
                answer++;
        }
        
        return answer;
    }
    
    // 여기 famous_algorithm/permutation.java 참고해서 작성하기 - 210419/16:25
    public int[] composeNum(int[] nums){
        
    }
    
    public ArrayList<Integer> composeNum(int[] nums, boolean[] visited, int depth, int n, int r){
        if(depth == r){
            
        }
    }
    
    public boolean isPrime(int num){
        int divider = 2;
        while( divider < num){
            if(num%divider == 0)
                return false;
        }
        return true;
    }
    
}