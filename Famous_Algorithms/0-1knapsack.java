class Solution{

    int max(int a, int b){
        return (a > b) ? a : b;
    }

    // 아래의 경우는 table을 이용하지 않고 재귀를 사용하기 때문에 비교적 덜 효율적이다
    // w: capacity
    // wt: weight of items
    // val: value of items
    // n: prev_index
    int knapSack_r(int w, int wt[], int val[], int n){
        // Base case
        if(n == 0 || w == 0)
            return 0;

        if(wt[n-1] > w)
            return knapSack(w, wt, val, n-1);
        else
            return max(val[n-1]+knapSack_r(w-wt[n-1], wt, val, n-1), knapSack_r(w, wt, val, n-1));
    }

    int knapsack_t(int w, int[] wt, int[] val, int n)){
        int[][] table = new int[n+1][w+1];
        int max = -1;
        
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= w; j++){
                if(wt[i-1] <= j)
                    table[i][j] = Math.max(val[i-1] + table[i-1][j-wt[i-1]], table[i-1][j]);
                else 
                    table[i][j] = table[i-1][j];
                max = Math.max(table[i][j], max);
            }
        }

        return max;
    }

    public void main(String args[]){
        int[] val = {60, 100, 120};
        int[] wt = {10, 20, 30};
        int w = 50;
        int n = val.length;
        System.out.println(knapSack_r(w, wt, val, n));
    }
}