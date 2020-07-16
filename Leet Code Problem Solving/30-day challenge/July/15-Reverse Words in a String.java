class Solution {
    public String reverseWords(String s) {
        String[] reverseStr = s.split(" ");
        String ans = "";

        for(int i = reverseStr.length - 1; i >= 0; i--){
            if(reverseStr[i].equals(""))
                continue;
            ans += " ";
            ans += reverseStr[i];
        }
        if(ans.equals(""))
            return ans;
        return ans.substring(1);
    }
}
