// 1. using data structure hash table
public boolean isRepeated(String str){
  HashSet<Character> set = new HashSet<>();
  
  for(int i = 0; i < str.length(); i++){
    char c = str.charAt(i);
    if(set.contains(c))
      return fasle;
    set.put(c);
  }
  return true;
}

// 2. not using data structure
public boolean isRepeated(String str){
  if(str.length() > 128)
    return false;
    
  boolean[] isSeen = new boolean[128];

  for(int i = 0; i < str.length; i++){
    int c = str.charAt(i);
    if(isSeen[c])
      return false;
    isSeen[c] = true;
  }
  return true;
}