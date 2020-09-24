


// 카카오 테크 블로그에서 설명해준 바에 따르면 Trie 자료 구조를 사용하면 되는 듯 하다
// trie를 썼다. 효율성 테스트 12는 이제 통과 하는데 3,4,5가 통과되지 않는다
// 아무래도 arraylist 때문인 것 같다.
import java.util.*;

class Solution {
    public int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];
        Trie trie = new Trie();
        for(int i = 0; i < words.length; i++) {
        	trie.add(words[i]);
        }
        
        for(int i = 0; i < queries.length; i++) {
        	if(queries[i].startsWith("?")) {
        		answer[i] = trie.contains(queries[i], true);
        	}
        	else {
        		answer[i] = trie.contains(queries[i], false);
        	}
        	
        }
        
        return answer;
    }
    
    
}

class TrieNode{
    private HashMap<Character, TrieNode> children = new HashMap<>();
    private boolean isLastChar;
    private ArrayList<Integer> restLength = new ArrayList<>();
    
    public HashMap<Character,TrieNode> getChildren(){ return this.children; }
    public ArrayList<Integer> getRestLength(){ return this.restLength; }
    
    public boolean isLastChar(){ return this.isLastChar; }
    public void setIsLastChar(boolean isLastChar){ this.isLastChar = isLastChar; }
}

class Trie{
    private TrieNode root;
    private TrieNode revRoot;
    Trie(){ 
        root = new TrieNode();
        revRoot = new TrieNode();
    }
    
    public void add(String word){
        TrieNode curr = root;
        HashMap<Character, TrieNode> children = curr.getChildren();
        
        for(int i = 0; i < word.length() ; i++){
            char c = word.charAt(i);
            if(!children.containsKey(c)){
                curr = new TrieNode();
                children.put(c, curr);
            }
            else{
                curr = children.get(c);
            }
            curr.getRestLength().add(word.substring(i+1).length());
            children = curr.getChildren();
        }
        curr.setIsLastChar(true);
        
        curr = revRoot;
        children = curr.getChildren();
        for(int i = word.length()-1; i >= 0 ; i--){
            char c = word.charAt(i);
            if(!children.containsKey(c)){
                curr = new TrieNode();
                children.put(c, curr);
            }
            else{
                curr = children.get(c);
            }
            curr.getRestLength().add(word.substring(0,i).length());
            children = curr.getChildren();
        }
        curr.setIsLastChar(true);
        
        
    }
    
    public int contains(String word, boolean reverse){
    	TrieNode curr;
        if(reverse) {
        	curr = revRoot;
            int count = 0;
            
            for(int i = word.length()-1; i >= 0; i--){
                char c = word.charAt(i);
                if(c == '?'){
                    count = 0;
                    int rest = word.substring(0,i+1).length();
                    for(int len : curr.getRestLength()){
                        if(len == rest)
                            count++;
                    }
                    return count;
                }
                TrieNode node = curr.getChildren().get(c);
                
                if(node == null)
                    return count;
                
                curr = node;
            }
            return count;
        }
        
        else {
        	curr = root;
            int count = 0;
            
            for(int i = 0; i < word.length(); i++){
                char c = word.charAt(i);
                if(c == '?'){
                    count = 0;
                    int rest = word.substring(i).length();
                    for(int len : curr.getRestLength()){
                        if(len == rest)
                            count++;
                    }
                    return count;
                }
                TrieNode node = curr.getChildren().get(c);
                
                if(node == null)
                    return count;
                
                curr = node;
            }
            return count;
        }
    }
        	

    
    
}



/*
// 정규 표현식을 사용하였다
// 정답은 모두 나왔는데 여전히 효율성 테스트 1~3을 통과하지 못했다.
// 아무래도 O(n^2) 외에 더 좋은 방법이 있는 것 같다.
class Solution {
    public int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];
        String qRegx;
        for(int i = 0; i < queries.length; i++){
            qRegx = getRegx(queries[i]);
            for(int j = 0; j < words.length; j++){
                if(words[j].matches(qRegx))
                    answer[i]++;
            }
        }
        
        return answer;
    }
    
    public String getRegx(String q){
        String regx="*";
        if(q.startsWith("?")){
            int len = q.lastIndexOf("?") + 1;
            String subQ = q.substring(len);
            regx = "^.{"+len+"}"+subQ+"$";
        }
        else if(q.endsWith("?")){
            int len = q.length() - q.indexOf("?");
            String subQ = q.substring(0, q.indexOf("?"));
            regx = "^"+subQ+".{"+len+"}$";
        }
        return regx;
    }
    
}

*/

/*
// 정답은 나오나 효율성 테스트를 통과하지 못함
class Solution {
    public int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];
        for(int i = 0; i < queries.length; i++){
            int[] position = getWCPosition(queries[i]);
            answer[i] = isMatch(words, queries[i], position);
        }
        
        return answer;
    }
    
    public int[] getWCPosition(String q){
        int[] position = {-1,-1};   // head일 경우 1, tail일 경우 2
        char[] strCharArray = q.toCharArray();
        for(int i = 0; i < strCharArray.length; i++){
            if(strCharArray[i] == '?'){
                if(position[0] == -1){
                    if(i == 0)
                        position[0] = 1;
                    else{
                        position[0] = 2;
                        position[1] = i;
                    }
                }
                else if(position[0] == 1){
                    if(i == strCharArray.length - 1 || strCharArray[i+1] != '?')
                        position[1] = i+1;
                }
            }
        }
        return position;
    }
    
    public int isMatch(String[] words, String query, int[] p){
        int count = 0;
        String subQuery;
        int wcLength = 0;
        if(p[0] == 1) {
            subQuery = query.substring(p[1]);
            wcLength = query.substring(0,p[1]).length();
        }
        else {
            subQuery = query.substring(0, p[1]);
            wcLength = query.substring(p[1]).length();
        }
        for(int i = 0; i < words.length; i++){
            String subWord;
            int wordWCLength;
            try{
            	
                if(p[0] == 1) {
                    subWord = words[i].substring(p[1]);
                    wordWCLength = words[i].substring(0,p[1]).length();
                }
                else {
                    subWord = words[i].substring(0, p[1]);
                    wordWCLength = words[i].substring(p[1]).length();
                }
                
                if(wcLength != wordWCLength)
                	continue;
                
                if(subWord.equals(subQuery))
                    count++;
            }
            catch(Exception e){}

        }
        return count;
    }
}
*/