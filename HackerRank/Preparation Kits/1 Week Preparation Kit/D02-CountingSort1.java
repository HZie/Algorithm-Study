/*
 * input이 
 * [100
63 54 17 78 43 70 32 97 16 94 74 18 60 61 35 83 13 56 75 52 70 12 24 37 17 0 16 64 34 81 82 24 69 2 30 61 83 37 97 16 70 53 0 61 12 17 97 67 33 30 49 70 11 40 67 94 84 60 35 58 19 81 16 14 68 46 42 81 75 87 13 84 33 34 14 96 7 59 17 98 79 47 71 75 8 27 73 66 64 12 29 35 80 78 80 6 5 24 49 82] 
 * 인경우에
 * 왜 이렇게 하면 expected output이
 * 
 * [2 0 1 0 0 1 1 1 1 0 0 1 3 2 2 0 4 4 1 1 0 0 0 0 3 0 0 1 0 1 2 0 1 2 2 3 0 2 0 0 1 0 1 1 0 0 1 1 0 2 0 0 1 1 1 0 1 0 1 1 2 3 0 1 2 0 1 2 1 1 4 1 0 1 1 3 0 0 2 1 2 3 2 2 2 0 0 1 0 0 0 0 0 0 2 0 1 3 1 0]
 * 이렇게 나오지?
 * 
 */
public static List<Integer> countingSort(List<Integer> arr) {
  // Write your code here
      List<Integer> ans = new ArrayList<>();
      int maxNum = -1;
      
      
      for(int num: arr){
          if(num > maxNum){
              int count = 0;
              System.out.println("num: " + num);
              for(int i = maxNum; i < num; i++){
                  count++;
                  ans.add(0);
              }
              System.out.println("Hit count: " +count);
              maxNum = num;
          }
          ans.set(num, ans.get(num)+1);
      }
      return ans;
  }

  /*
   * 이렇게 하면 
   * [2 0 1 0 0 1 1 1 1 0 0 1 3 2 2 0 4 4 1 1 0 0 0 0 3 0 0 1 0 1 2 0 1 2 2 3 0 2 0 0 1 0 1 1 0 0 1 1 0 2 0 0 1 1 1 0 1 0 1 1 2 3 0 1 2 0 1 2 1 1 4 1 0 1 1 3 0 0 2 1 2 3 2 2 2 0 0 1 0 0 0 0 0 0 2 0 1 3 1]
   * 이렇게 나오고.. 이해가 안되네..
   * 
   * 1번으로 하나 2번으로 하나 결과값은 똑같은데..
   */
  public static List<Integer> countingSort(List<Integer> arr) {
    List<Integer> result = new ArrayList<>();
    for (int i = 0; i < 100; i++) {
        result.add(Collections.frequency(arr, i));
    }
    return result;
}