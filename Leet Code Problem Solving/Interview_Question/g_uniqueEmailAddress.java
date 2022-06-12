import java.util.*;

class Solution {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> mails = new HashSet<>();
        
        for(String str: emails){
            String[] splited = str.split("@");
            String name = splited[0];
            String domain = splited[1];
            name = name.replaceAll("\\.","");
            int plusIndex = name.indexOf("+");
            if(plusIndex != -1){
                name = name.substring(0,plusIndex);
            }
            String m = name + "@"+domain;
            System.out.println(m);
            mails.add(m);
        }
        
        return mails.size();
    }
}