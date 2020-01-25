// https://leetcode.com/problems/fizz-buzz/submissions/
// Easy
class Solution {
    public List<String> fizzBuzz(int n) {
        ArrayList<String> ans = new ArrayList<String>();
        for(int i = 1; i <= n; i++){
            if(i % 15 == 0)
                ans.add("FizzBuzz");
            else if(i % 5 == 0)
                ans.add("Buzz");
            else if(i % 3 == 0)
                ans.add("Fizz");
            else
                ans.add(Integer.toString(i));
        }
        return ans;
            
    }
}