// Time Complexity: O(N^2)
// Space Complexity: O(N) 

/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node findTail(Node head){
        Node cur = head;
        while(cur.next != null){    
            cur = cur.next;
        }
        return cur;
    }
    
    
    public Node flatten(Node head) {
        Node cur = head;
        
        while(cur != null){ 
            if(cur.child != null){
                Node p1 = flatten(cur.child);
                Node p2 = findTail(p1);
                
                if(cur.next != null){
                    p2.next = cur.next;
                    cur.next.prev = p2;
                }
                p1.prev = cur;
                cur.next = p1;                
                cur.child = null;
                
            }
            cur = cur.next;
        }
        return head;
        
    }
}