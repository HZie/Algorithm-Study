public String compressString(String str){
  // for more efficiency use string builder
  String compressed = "";

  int count = 1;
  for(int i = 0; i < str.length()-1; i++){
    if(str.charAt(i) == str.charAt(i+1)){
      count++;
    }
    else{
      compressed = compressed + str.charAt(i) + count;
      count = 1;
    }
  }

  return compressed.length() >= str.length() ? str : compressed;
}