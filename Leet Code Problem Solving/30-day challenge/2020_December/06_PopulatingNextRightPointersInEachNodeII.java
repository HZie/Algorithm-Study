// need review
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        Queue<Node> q = new LinkedList<>();
        if(root == null)
            return root;
        q.offer(root);

        while(!q.isEmpty()){
            int size = q.size();
            Node curr = q.peek();
            
            for(int i = 0; i < size; i++){
                curr = q.poll();
                curr.next = q.peek();
                
                if(curr.left != null)
                    q.offer(curr.left);
                
                if(curr.right != null)
                    q.offer(curr.right);
            }
            curr.next = null;
        }
        return root;
    }
    
    
}