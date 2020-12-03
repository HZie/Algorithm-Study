/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode increasingBST(TreeNode root) {
        Queue<Integer> q = new LinkedList<>();
        inorder(root, q);
    
        TreeNode new_root = new TreeNode();
        TreeNode curr = new_root;
        
        new_root.val = q.poll();
        while(!q.isEmpty()){
            curr.right = new TreeNode(q.poll());
            curr = curr.right;
        }
        return new_root;
    }
    
    public void inorder(TreeNode node, Queue<Integer> q){
        if(node == null)
            return;
        inorder(node.left, q);
        q.offer(node.val);
        inorder(node.right, q);
    }
}