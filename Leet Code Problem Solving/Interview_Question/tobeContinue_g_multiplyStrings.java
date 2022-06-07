import java.util.*;

class Solution {
    public String multiply(String num1, String num2) {
      String top, bot;
      
      if(num1.length() > num2.length()){
        top = num1;
        bot = num2;
      }
      else{
        top = num2;
        bot = num1;
      }

      int topIdx = 0;
      StringBuilder answer = new StringBuilder();

      ArrayList<Integer> rest = new ArrayList<>();

      while(topIdx < top.length()){
        int topNum = top.charAt(top.length()-1-topIdx) - '0';
        
        int currCalc = 0;
        for(int i = 0; i < bot.length(); i++){
          int botNum = bot.charAt(i) - '0';
          currCalc += botNum * topNum;
          currCalc *= 10;
        }

        insertToList(rest, currCalc/10, topIdx);
        answer.insert(0, rest.get(topIdx));
        topIdx++;
      }

      for(int i = topIdx; i < rest.size(); i++){
        answer.insert(0, rest.get(i));
      }

      return answer.toString();
    }

    public void insertToList(ArrayList<Integer> list, int num, int lastIndex){
      int currIdx = lastIndex;
      while(num > 0){
        if(list.size() <= currIdx){
          list.add(num%10);
        }
        else{
          list.set(currIdx, list.get(currIdx) + num % 10);
        }
        currIdx++;
        num /= 10;
      }

      int flow = 0;
      int i = 0;
      for(i = 0; i < list.size(); i++){
        int n = list.get(i) + flow;
        if(n > 10){
          list.set(i, n % 10);
          flow = n/10;
        }
      }

      while(flow > 0){
        list.add(i, flow%10);
        i++;
      }
    }


}