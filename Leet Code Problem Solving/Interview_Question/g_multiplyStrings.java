// first idea
/*
  1. store each result digit into the mult list
  2. multiply digits and store float number into mult list
 */

 // time: O(M*N) where num1 length = M, num2 length = N
 // space: O(M+N)
import java.util.*;

class Solution {
  public String multiply(String num1, String num2) {
    ArrayList<Integer> mult = new ArrayList<>();

    if(num1.compareTo("0") == 0 || num2.compareTo("0") == 0)
      return "0";
    for(int i = num1.length()-1; i >=0; i--){
      int digitOne = num1.length() - i -1;
      int n1 = num1.charAt(i) - '0';
      for(int j = num2.length()-1; j >= 0; j--){
        int digitTwo = num2.length() - j -1;
        int n2 = num2.charAt(j) - '0';
        int result = n1 * n2;
        int digit = digitOne + digitTwo;
        
        //System.out.println("n1: "+ n1 + ", n2: " + n2 + ", result: " + result);
        insertNum(mult, digit, result % 10);

        if(result >= 10){
          insertNum(mult, digit+1, result/10);
        }

      }
    }

    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < mult.size(); i++){
      sb.insert(0, mult.get(i)+"");
    }

    return sb.toString();
  }


  public void insertNum(ArrayList<Integer> list, int digit, int val){
    //System.out.println("before - list: " +list + ", digit: " + digit +", val: " + val);
    if(digit >= list.size()){
      list.add(val);
    }
    else {
      int num = list.get(digit) + val;

      if(num >= 10){
        insertNum(list, digit+1, num /10);
      }
      list.set(digit, num%10);
    }

    //System.out.println("after - list: " +list + ", digit: " + digit +", val: " + val+"\n");
  }

}