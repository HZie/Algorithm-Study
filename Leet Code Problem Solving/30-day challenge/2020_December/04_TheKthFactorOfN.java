class Solution {
    public int kthFactor(int n, int k) {
        // brutal force
        // accepted
        HashSet<Integer> set = new HashSet<>();
        
        for(int i = 1; i <= n/2+1; i++){
            if(n % i == 0){
                set.add(i);
                set.add(n/i);
            }
        }
        
        ArrayList<Integer> factors = new ArrayList<>(set);
        
        Collections.sort(factors);
        
        if(k > factors.size())
            return -1;
        
        return factors.get(k-1);
    }
}