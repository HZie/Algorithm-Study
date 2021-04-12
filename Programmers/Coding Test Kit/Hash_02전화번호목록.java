// 왜 해시에 들어있는지 모르겠는 문제

import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        Arrays.sort(phone_book);
        for(int i = 0; i < phone_book.length - 1; i++){


            String curr = phone_book[i];
            String next = phone_book[i+1];

            if(curr.length() <= next.length()){
                if(next.startsWith(curr)){
                    answer = false;
                    break;
                }
            }
        }


        return answer;
    }
}
