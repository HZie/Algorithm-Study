// Time Complexity : O(N)
// Space Complexity: O(1)
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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> pque = new LinkedList<TreeNode>();
        Queue<TreeNode> qque = new LinkedList<TreeNode>();
        int pqsize = 0;
        int qqsize = 0;
        
        pque.add(p);
        pqsize++;
        qque.add(q);
        qqsize++;
        
        // O(N)
        while(pqsize > 0 && qqsize > 0){
            TreeNode pnode, qnode;

            pnode = pque.poll();
            pqsize--;
            qnode = qque.poll();
            qqsize--;
            if(pnode == null && qnode == null)
                continue;
            else if(pnode == null || qnode == null)
                return false;

            if(pnode.val != qnode.val)
                return false;
            pque.add(pnode.left);
            pqsize++;
            pque.add(pnode.right);
            pqsize++;
            qque.add(qnode.left);
            qqsize++;
            qque.add(qnode.right);
            qqsize++;
        }
        if(pqsize > 0 || qqsize > 0)
            return false;
        return true;
    }
}