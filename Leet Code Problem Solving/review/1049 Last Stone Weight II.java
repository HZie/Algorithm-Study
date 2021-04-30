class Solution {
    public int lastStoneWeightII(int[] stones) {
        
        Arrays.sort(stones);
        
        int sum = 0;
        for(int s:stones)   sum += s;
        
        
        int[][] dp = new int[stones.length+1][sum/2+1];
        
        for(int i = 1; i <= stones.length; i++){
            for(int j = 1; j <= sum/2; j++){
                if(stones[i-1] > j)
                    dp[i][j] = dp[i-1][j];
                else{
                    dp[i][j] = Math.max(stones[i-1] + dp[i-1][j-stones[i-1]], dp[i-1][j]);
                }
            }
        }
        
        int answer = sum - dp[stones.length][sum/2];
        
        return answer;
        
    }
}