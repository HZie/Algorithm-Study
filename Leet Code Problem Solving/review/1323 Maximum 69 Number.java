class Solution {
  public int maximum69Number (int num) {
      int maxSixDigit = -1;
      int curr = 0;
      int temp = num;
      ArrayList<Integer> number = new ArrayList<>();

      while(temp > 0){
          int n = temp % 10;
          temp /= 10;
          number.add(n);
          if(n == 6){
              maxSixDigit = curr;
          }
          curr++;
      }

      if(maxSixDigit == -1)
          return num;
      
      number.set(maxSixDigit, 9);
      temp = 0;
      for(int i = number.size()-1; i > 0; i--){
          temp += number.get(i);
          temp *= 10;
      }

      temp += number.get(0);

      return temp;
  }
}