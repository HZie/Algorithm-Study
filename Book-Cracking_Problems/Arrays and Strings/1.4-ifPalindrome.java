public boolean ifPalindrome(String str){
  char[] cSet = new char[128];

  for(int i = 0; i < str.length(); i++){
    int c = str.charAt(i);
    cSet[c]++;
  }

  boolean ifMidFound = false;
  for(int i = 0; i < cSet.length; i++){
    if(cSet[i] == 1){
      if(!ifMidFound)
        ifMidFound = true;
      else 
        return false;
    }
  }
  return true;
}
