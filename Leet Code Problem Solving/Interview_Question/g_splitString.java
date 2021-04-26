// https://leetcode.com/discuss/interview-question/553399/

// Given a string S, we can split S into 2 strings: S1 and S2.
// Return the number of ways S can be split such that the number of unique characters between S1 and S2 are the same.

// ex1
// input: "aaaa"
// output: 3

// ex2
// input: "bac"
// output: 0

// ex3
// input: "ababa"
// output: 2


// Time: O(n^2)
// TLE
class Solution {
    public int numSplits(String s) {
     
        int count = 0;
        String str1, str2;
        
        for(int i = 1; i < s.length(); i++){
            str1 = s.substring(0,i);
            str2 = s.substring(i, s.length());

            if(isUniqSame(str1, str2))
                count++;
        }

        return count;
    }

    public boolean isUniqSame(String s1, String s2){
        int count1 = 0, count2 = 0;
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();

        Arrays.sort(ch1);
        Arrays.sort(ch2);

        for(int i = 0; i < ch1.length-1; i++){
            if(ch1[i] != ch1[i+1])
                count1++;
        }
        for(int i = 0; i < ch2.length-1; i++){
            if(ch2[i] != ch2[i+1])
                count2++;
        }

        
        return (count1 == count2);
        

    }
}

/*
// 다른 사람 코드 
// Time: O(n)

    private static int splitStringUniqueChars(String input) {
        HashMap<Character, Integer> left = new HashMap<>();
        HashMap<Character, Integer> right = new HashMap<>();
        int ans = 0;

        // 먼저 string의 모든 문자를 오른쪽으로 옮긴다
        for(char c : input.toCharArray()) right.put(c, right.getOrDefault(c, 0) + 1);
        
        // input의 순서대로 하나씩 왼쪽으로 보낸다
        for(char c : input.toCharArray()) {
            // Move character from right to left
            right.put(c, right.getOrDefault(c, 0) - 1);
            left.put(c, left.getOrDefault(c, 0) + 1);

            // 이 부분이 잘 이해가 안되지만 그래도 대략적인 알고리즘 동작 원리는 이해했다
            if(right.get(c) == 0) break;
            
            // Compare unique characters
            // 유니크 캐릭터들의 수를 배교한다(keyset을 비교하면 됨)
            if(right.keySet().equals(left.keySet())) ans++;
        }
        return ans;
    }


    // 위 hashmap을 쓴 코드가 잘못된 부분이 있어서 고쳤다
class Solution {
    public int numSplits(String s) {
       HashMap<Character, Integer> left = new HashMap<>();
        HashMap<Character, Integer> right = new HashMap<>();
        int ans = 0;

        // 먼저 string의 모든 문자를 오른쪽으로 옮긴다
        for(char c : s.toCharArray()) right.put(c, right.getOrDefault(c, 0) + 1);
        
        // input의 순서대로 하나씩 왼쪽으로 보낸다
        for(char c : s.toCharArray()) {

            if(right.containsKey(c)){
                // right에서 하나 뺐을 때 해당 키의 count값이 0이면 아예 키를 빼버린다
                int val = right.get(c);
                if((val-1) == 0)
                    right.remove(c);
                else
                    right.put(c, val-1);
            }
            
            // left에 뺀 것을 넣는다
            left.put(c, left.getOrDefault(c, 0) + 1);
                        
            // 유니크 캐릭터들의 수를 배교한다(keyset의 크기를 비교하면 됨)
            if(right.keySet().size() == left.keySet().size()) ans++;
        }
        return ans;
    }
}





// 이건 hashmap을 쓰지 않은 경우
class Solution {
    public int numSplits(String s) {
        char[] arr = s.toCharArray();
        int res=0;
        int[] left = new int[26];
        int[] right = new int[26];
        int leftcount=0;   //will store number of unique characters in left string. 
        int rightcount=0;   //will store number of unique characters in right string.
		
		//store frequency of each character in right array.
        for(int i=0; i<arr.length;i++){
            right[arr[i]-'a']++;
            if(right[arr[i]-'a']==1) rightcount++;
        }
		
        for(int i=0;i<arr.length;i++){
            right[arr[i]-'a']--;
			left[arr[i]-'a']++;
            if(right[arr[i]-'a']==0) rightcount--; //decrement unique character on right side
            if(left[arr[i]-'a']==1) leftcount++; // increment unique character on left side.
            if(leftcount == rightcount) res++; // if unique characters are same on both side, its good split. 
        }
        
        return res;
    }
}
*/

// 비슷한 문제: https://leetcode.com/problems/number-of-good-ways-to-split-a-string/