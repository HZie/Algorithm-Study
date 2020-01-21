// https://leetcode.com/problems/find-largest-value-in-each-tree-row/
// Medium
// Try not to use recursive

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
        
    public void findInRow(TreeNode node, int index, ArrayList<Integer> ans){
        int bigger;
        
        if(node.left != null){
            bigger = node.left.val;
            if(node.right != null && bigger < node.right.val)
                bigger = node.right.val;
            
            
        }
        else {
            if(node.right != null)
                bigger = node.right.val;
            else
              return;  
        }
        
        if(ans.size() == index+1){  // if array is empty
            ans.add(bigger);
        }
        
        if(ans.get(index+1) < bigger)
            ans.set(index+1,bigger);

        if(node.right != null)
            findInRow(node.right, index+1,ans);
        if(node.left != null)
            findInRow(node.left, index+1,ans);
    
    }
    
    public List<Integer> largestValues(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        if(root == null)
            return ans;
        ans.add(root.val);
        findInRow(root,0,ans);
        
        return ans;
    }
}

// Time Complexity = O(n);
// Space Complexity = O(n);