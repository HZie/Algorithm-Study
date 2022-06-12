
// 아래 방법은 String builder 라이브러리를 사용했으니 그걸 사용하지 않고 하는 방법을 찾아보려고 한다.
public boolean checkPermutation(String s1, String s2){
  if(s1.length() != s2.length())  return false;

  StringBuilder sb1 = new StringBuilder(s2);

  for(int i = 0; i < s1.length(); i++){
    Stirng c = s1.substring(i, i+1);

    if(sb1.length() == 0) return false;
    int cIdx = sb1.indexOf(c);
    if(cIdx == -1)  return false;

    sb1.delete(cIdx, cIdx+1);
  }
  return true;
}

public boolean checkPermutation(String s1, String s2){
  if(s1.length() != s2.length())  return false;
  int[] cSet = new int[128];
  int length = s1.length();

  for(int i = 0; i < length; i++){
    int c1 = s1.charAt(i);
    cSet[c1]++;
    int c2 = s2.charAt(i);
    cSet[c2]--;
  }

  for(int n: cSet){
    if(n != 0)
      return false;
  }

  return true;
}