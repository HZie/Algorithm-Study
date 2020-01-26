// https://leetcode.com/problems/sum-of-even-numbers-after-queries/submissions/
// Easy
class Solution {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int[] ans = new int[queries.length];
        int evenSum = 0;
        
        // A length = n --> time complexity: O(n)
        for(int i = 0; i < A.length; i++){  
            if(A[i] % 2 == 0)
                evenSum += A[i];
        }
        
        int val, index;
        
        // ans length = k --> time complexity: O(k)
        for(int i = 0; i < ans.length; i++){
            val = queries[i][0];
            index = queries[i][1];
            
            if(A[index] % 2 == 0){
                evenSum -= A[index];
            }
            
            A[index] = val + A[index];
            
            if(A[index] % 2 == 0){
                evenSum += A[index];
            }
            
            ans[i] = evenSum;
        }
        
        return ans;
        
    }
}

// time complexity: O(k);
// space complexity: O(1);