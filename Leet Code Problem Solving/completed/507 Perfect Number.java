class Solution {
  public boolean checkPerfectNumber(int num) {
      if(num == 1)
          return false;
      int curr = num-1;
      int divisor = 2;

      while(divisor <= Math.sqrt(num)){
          if(num % divisor == 0){
              curr -= divisor;
              if(num/divisor != divisor){
                  curr -= num/divisor;
              }
          }
          divisor++;
      }
      if(curr != 0 && divisor > Math.sqrt(num))
          return false;
      return true;
  }
}
