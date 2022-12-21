public static void miniMaxSum(List<Integer> arr) {
  // Write your code here
      long sum = 0;
      for(int i = 0; i < arr.size(); i++){
          sum += arr.get(i);
      }
      arr.sort(Comparator.naturalOrder());
      
      long min = sum-arr.get(arr.size()-1);
      long max = sum-arr.get(0);
      System.out.println(min+" " + max);
  }
