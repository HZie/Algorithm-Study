public static String timeConversion(String s) {
  // Write your code here
      String[] parsed = s.split(":");
      int hour = Integer.parseInt(parsed[0]);

      if(parsed[parsed.length-1].contains("PM")){
          parsed[parsed.length-1] = parsed[parsed.length-1].replace("PM", "");
          
          if(hour < 12)
              hour += 12;
          parsed[0] = hour+"";

      }
      else{
          if(hour ==12)
              parsed[0] = "00";
          parsed[parsed.length-1]=parsed[parsed.length-1].replace("AM","");
      }

      
      String ans = "";
      for(int i = 0; i< parsed.length; i++){
          if(i > 0)
              ans += ":";
          ans += parsed[i];
      } 
      return ans;
  }