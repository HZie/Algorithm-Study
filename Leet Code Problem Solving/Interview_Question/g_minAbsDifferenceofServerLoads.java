// https://leetcode.com/discuss/interview-question/356433/

// there's two server, and array of loads.
// dispose loads to two servers and return minimized difference of two servers' sum of loads

// Example
// input: [1, 2, 3, 4, 5]
// output: 1
// explanation: server1 - [1, 2, 4] (sum: 7)
//              server2 - [3, 5]    (sum: 8)
// so the diff = 1 (8-7)

class Solution{
    public int minAbsDiffServerLoad(int[] input){
        Arrays.sort(input);
        int sum = 0;
        for(int n: input)   sum += n;

        // 크기를 전체 값을 반으로 나눈 것으로 함
        int[][] dp = new int[input.length+1][sum/2+1];

        // 아래는 0/1 knapsack의 variation
        for(int i = 1; i <= input.length; i++){
            for(int j = 1; j <= (sum/2); j++){
                if(input[i-1] <= j){
                    dp[i][j] = Math.max(input[i-1] + dp[i-1][j-input[i-1]], dp[i-1][j]);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        
        // 두번째 서버에 들어갈 load
        int answer = sum - 2 * dp[input.length][sum/2];

        return answer;

    }
}


// similar question: https://leetcode.com/problems/last-stone-weight-ii/description/