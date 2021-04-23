// 이 블로그의 코드를 참고하였음
// https://yujieun.github.io/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-DFSBFS-%EB%8B%A8%EC%96%B4%EB%B3%80%ED%99%98-JAVA/
// 이 DFS/BFS 문제는 DFS로 풀었던 문제는 BFS로, BFS로 풀었던 문제는 DFS로 다시 풀어보는것이 좋을 듯 하다
import java.util.*;

class Solution {
    
    class Node{
        String str;
        int edge;
        
        public Node(String str, int edge){
            this.str = str;
            this.edge = edge;
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        boolean[]visit = new boolean[words.length];
        // 인덱스 번호를 여기다가 저장함
        Queue<Node> q = new LinkedList<>();
        
        q.add(new Node(begin, 0));
        
        while(!q.isEmpty()){
            Node curr = q.poll();

            if(curr.str.equals(target)){
                answer = curr.edge;
                break;
            }
            
            for(int i = 0; i < words.length; i++){
                if(isChangeable(curr.str, words[i]) && !visit[i]){
                    visit[i] = true;
                    q.add(new Node(words[i], curr.edge+1));
                }
            }

        }
        
        if(answer >= words.length)
            return 0;
                
        return answer;
    }
    
    public boolean isChangeable(String curr, String w){
        int diff = 0;
        
        for(int i = 0; i < curr.length(); i++){
            if(curr.charAt(i) != w.charAt(i)){
                diff++;
            }
        }
        
        if(diff == 1)
            return true;
        return false;
    }
}

/*
// 다른 사람의 풀이
import java.util.LinkedList;
import java.util.Queue;

class Solution {

    static class Node {
        String next;
        int edge;

        public Node(String next, int edge) {
            this.next = next;
            this.edge = edge;
        }
    }

    public int solution(String begin, String target, String[] words) {
        int n = words.length, ans = 0;

        // for (int i=0; i<n; i++)
        //  if (words[i] != target && i == n-1) return 0;

        Queue<Node> q = new LinkedList<>();


        boolean[] visit = new boolean[n];
        q.add(new Node(begin, 0));

        while(!q.isEmpty()) {
            Node cur = q.poll();
            if (cur.next.equals(target)) {
                ans = cur.edge;
                break;
            }

            for (int i=0; i<n; i++) {
                if (!visit[i] && isNext(cur.next, words[i])) {
                    visit[i] = true;
                    q.add(new Node(words[i], cur.edge + 1));
                }
            }
        }

        return ans;
    }

    static boolean isNext(String cur, String n) {
        int cnt = 0;
        for (int i=0; i<n.length(); i++) {
            if (cur.charAt(i) != n.charAt(i)) {
                if (++ cnt > 1) return false;
            }
        }

        return true;
    }    
}
*/