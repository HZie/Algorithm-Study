// 카카오 테크 블로그에서 설명해준 바에 따르면 Trie 자료 구조를 사용하면 되는 듯 하다


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