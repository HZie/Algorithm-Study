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
// [9,20,-10,-1, 7, null,null]
/*
 *                9
 *        20            -10
 *  -1        7
 * 
 * 답: 36
 * 
 * maxPathSum(9, 최하);
 * leftSum = maxPathSum(20, 최하) --> 27
 *            leftSum = maxPathSum(-1, 최하) --> -1
 *                      leftSum = maxPathSum(null, 최하) --> 0
 *                      sum = -1
 *                      rightSum = maxPathSum(null, 최하) --> 0
 *            sum = 20
 *            rightSum = maxPathSum(7, 최하) --> 7
 *            sum = 27
 *            max = 27
 * 
 * sum = 9
 * sum = 36
 * max = 36
 * 
 * rightSum = maxPathSum(-10, 36) --> -10
 * 
 * 36
 * 
 */
class Solution {
  public int maxPathSum(TreeNode root) {
    return maxPathSum(root, Integer.MIN_VALUE);
  }

  public int maxPathSum(TreeNode node, int max){

    if(node == null)
      return 0;
    
    int leftSum = maxPathSum(node.left, max);
    int sum = node.val;

    if(leftSum + sum > sum){
      sum += leftSum;
      max = Math.max(max, sum);
    }

    int rightSum = maxPathSum(node.right, max);
    if(rightSum + sum > sum){
      sum += rightSum;
      max = Math.max(max, sum);
    }

    return sum;
  }

}