public boolean isRotateString(String s1, String s2){
  if(s1.length() != s2.length())  return false;
  int startStr = 0;

  char start = s1.charAt(0);
  for(int i = 0; i < s2.length(); i++){
    char c2 = s2.charAt(i);
    if(c2 == start){
      String sub = s2.substring(i);
      if(s1.startsWith(sub)){
        startStr = i;
        break;
      }
    }
  }

  String startSub = s2.substring(0, startStr);
  String endSub = s2.substring(startStr);

  if(s1.compareTo(endSub + startSub) == 0){
    return true;
  }
  return false;
}