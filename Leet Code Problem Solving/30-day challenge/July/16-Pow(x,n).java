// Time Complexity: O(1)
// Space Complexity: O(n)

class Solution {
    public double pow(double x, int n){
        if(n == 0) return 1;
        if(n == 1) return x;
        if(n % 2 == 0)
            return pow(x * x, n/2);
        else
            return x * pow(x * x, n/2);
    }
    public double myPow(double x, int n) {
        if(n < 0)
            return pow(1/x, -n);
        return pow(x, n);
    }
}

        
        /* TLE
        while(pow < n){
            if(pow * 2 <= n){
                pow *= 2;
                ans *= ans;
            }
            else{
                pow++;
                ans *= x;
            }
        }
        */