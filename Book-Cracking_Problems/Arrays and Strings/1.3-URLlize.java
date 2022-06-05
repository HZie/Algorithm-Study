
// 아래 방법은 메소드를 사용한 다소 양아치같은 방법이기는 해서 바꿔보려고 한다.
public String urlLize(String str){
  str.replaceAll(" " , "%20");
  return str;
}

public String urlLize(String str){
  char[] strArr = str.toCharArray();
  int blankCount = 0;
  for(int i = 0; i < strArr.length; i++){
    if(strArr[i] == ' ')
      blankCount++;
  }

  int newLength = strArr.length + blankCount*2;
  int nIdx = 0;
  char[] newArr = new char[newLength];

  for(int i = 0; i < strArr.length; i++){
    if(strArr[i] == ' '){
      newArr[nIdx++] = '%';
      newArr[nIdx++] = '2';
      newArr[nIdx++] = '0';
    }
    else{
      newArr[nIdx++] = strArr[i];
    }
  }

  return new String(newArr);
}