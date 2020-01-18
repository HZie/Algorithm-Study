// https://leetcode.com/problems/binary-prefix-divisible-by-5/
// Easy
// Try to think to make it better
class Solution {
    public List<Boolean> prefixesDivBy5(int[] A) {
        int lastDigit = 0;
        int i = 0;
        List <Boolean> answer = new ArrayList <Boolean>();
        do{
            lastDigit = lastDigit *2 + A[i];
            if(lastDigit % 5 == 0 )
                answer.add(true);
            else
                answer.add(false);
            lastDigit %= 10;
            i++;
        }while(i < A.length);
        
        return answer;
    }
}

// if A[0] is divisible A[0] == 0
// next should be 0101 or ...
// if A[i] is divisible than A[2i+1] is possible
// N_i = 2*N_(i-1) + A[N_i]