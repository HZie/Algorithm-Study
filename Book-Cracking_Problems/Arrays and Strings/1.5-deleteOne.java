public boolean deleteOne(String s1, String s2){
  boolean isEdited = false;
  int s1Idx = 0, s2Idx = 0;
  
  while(s1Idx < s1.length() && s2Idx < s2.length()){
    char c1 = s1Idx.charAt(s1Idx);
    char c2 = s2Idx.charAt(s2Idx);

    if(c1 != c2){
      if(isEdited)
        return false;
      isEdited = true;

      if(s1.length() > s2.length()){
        // delete char from c1
        c1++;
      }
      else if(s1.length() < s2.length()){
        // add char into c1
        c2++;
      }
      else{
        // replace character
        c1++; c2++;
      }
    }
    else{
      c1++; c2++;
    }
  }
  return true;
}
