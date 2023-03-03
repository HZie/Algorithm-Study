/*  player1의 경우
    n이 홀수인 경우 하나를 1로 만들어버리는 것이 유리 (n을 하나 줄이기)
    n이 짝수인 경우 여지를 만들어야 함 (가능한 자잘하게 나누기)
    
    player2의 경우
    n이 홀수인 경우 여지를 만들어야 함 (가능한 자잘하게 나누기)
    n이 짝수인 경우 하나를 1로 만들어버리는 것이 유리 (n을 하나 줄이기)
*/

4 4 4
2 2


// Brute Force
// TLE
public static int towerBreakers(int n, int m) {
  // Write your code here
      
      if(m == 1)
          return 2;

      PriorityQueue<Integer> highest = new PriorityQueue<>(Collections.reverseOrder());
      for(int i = 0; i < n; i++){
          // System.out.println("add");
          highest.add(m);
      }        

      int playerTurn = 1;  // true: player1, false: player2
      
      while(highest.size() > 0){
          int size = highest.size();
          int num = highest.poll();
          System.out.println("playerTurn: " + playerTurn+", size: "+size+", num: " + num);

          if((playerTurn == 1 && size % 2 == 0) || (playerTurn == 2 && size % 2 != 0)){
              System.out.println("Hit");
              remove_small(num, highest);
          }
      
          playerTurn  = 3-playerTurn;
      }
      
      return 3-playerTurn;
  }
  
  public static void remove_small(int num, PriorityQueue<Integer> q){
      for(int i = (int)Math.sqrt(num); i > 1; i--){
          if(num % i == 0){
              System.out.println("num-i: " + (num-i));
              q.add(i);
              return;
          }
      }
  }

  //...너무 deep하게 생각한듯...
  public static int towerBreakers(int n, int m) {
    // Write your code here
        if(m == 1 || n % 2 == 0)
            return 2;
        return 1;
    }