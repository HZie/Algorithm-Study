// Need to be reviewed
// Time: O(n)
// Space: O(1)

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
    
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList();
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        queue.add(null);
        
        while(queue.peek() != null){
          List<Integer> aList = new ArrayList();
          while(queue.peek() != null){
            TreeNode node = queue.poll();
            aList.add(node.val);
            if(node.left != null) queue.add(node.left);
            if(node.right != null) queue.add(node.right);
          }
          ans.add(aList);
          queue.poll();
          queue.add(null);
        }
      
        Collections.reverse(ans);
        return ans;
    }
}

/* Different Answer - Wrong answer
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        // It seems using BFS is right
        ArrayList<TreeNode> que = new ArrayList<TreeNode>();
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        Stack<List<Integer>> reverse = new Stack<List<Integer>>();
        List<Integer> child = new ArrayList<Integer>();

        TreeNode cur;
        
        que.add(root);
        child.add(root.val);
        reverse.push(child);
        int idx = 0;
        idx++;
        
        while(que.size() != 0){
            child = new ArrayList<Integer>();
            cur = que.remove(0);
            

            if(cur.left != null){
                que.add(cur.left);
                child.add(cur.left.val);
            }
            if(cur.right != null){
                que.add(cur.right);
                child.add(cur.right.val);
            }
            if(!child.isEmpty())
               reverse.push(child);
        }
        while(!reverse.empty()){
            ans.add(reverse.pop());
        }
        return ans;
        
    }
}
*/