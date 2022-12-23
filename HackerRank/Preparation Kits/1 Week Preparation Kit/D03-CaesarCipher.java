public static String caesarCipher(String s, int k) {
  // Write your code here
      String ans = "";
      if(k >= 'z'-'a'){
          k %= ('z'-'a'+1);
          //System.out.println("k: " + k);
      }
      for(int i = 0; i < s.length(); i++){
          char c = s.charAt(i);
          //System.out.println("29 c: "+(int)c);
          if(c >= 'a' && c <= 'z'){
              c += k;
              //System.out.println("32 c+k: " + (int)c);
              //System.out.println("33 z: " + (int)'z');
              if(c > 'z'){
                  
                  c -= ('z'+1);
                  c += 'a';
                  
                  //System.out.println("c: " + (int)c);
              }
          }
          else if(c >= 'A' && c <= 'Z'){
              c += k;
              if(c > 'Z'){
                  c = (char)(c-'Z'-1 +'A');
              }
          }
          ans += c;
      }
      return ans;
  }