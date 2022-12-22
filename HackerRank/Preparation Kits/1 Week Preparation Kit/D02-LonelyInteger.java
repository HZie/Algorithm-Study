public static int lonelyinteger(List<Integer> a) {
  // Write your code here
      HashSet<Integer> set = new HashSet<>();
      
      for(int i = 0; i < a.size(); i++){
          int num = a.get(i);
          if(set.contains(num)){
              set.remove(num);
          }
          else{
              set.add(num);
          }
      }
      Integer[] res = set.toArray(new Integer[set.size()]);
      
      return res[0];
  }