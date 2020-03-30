// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/
// Medium

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
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        TreeNode root = new TreeNode();
        TreeNode curLeft = root;
        TreeNode curRight = root;
        
        int endNum;
        int height = 0;
        int compBinaryNodeNum = 1;
        
        while(pre.length > compBinaryNodeNum){
            height++;
            compBinaryNodeNum *= 2;
        }
                        
        for(int i = 0; i < height; i++){
            curLeft.val = pre[i];
            curLeft.left = new TreeNode();
            curLeft = curLeft.left;
            
            curRight.val = post[post.length-1 - i];
            curRight.left = new TreeNode();
            curRight = curRight.right;
            
        }
        
        
        
    }
}