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
// 최대 넓이를 구하지 못했다.
// 그렇게 하기 위해서는 처음노드와 끝 노드의 위치를 안 다음에 계산해야할 것 같다.
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        TreeNode cur;
        int ans = 0;
        
        if(root == null)
            return 0;
        else if(root.left == null && root.right == null)
            return 1;
        
        q.add(root);
        int count = 1;
        
        while(q.peek() != null){
        	int prevCount = count;
        	count = 0;
            while(prevCount > 0){
                prevCount--;
                boolean hasChild = false;
                cur = q.poll();
                if(cur == null)
                	continue;
                if(cur.left != null || cur.right != null)
                	hasChild = true;
                q.add(cur.left);
                q.add(cur.right);
                if(hasChild){
                    count+=2;
                }
            }
            ans = Math.max(ans,count);


        }
        
        return ans;
    }
}
