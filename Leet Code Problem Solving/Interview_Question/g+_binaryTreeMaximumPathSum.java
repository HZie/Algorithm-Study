import java.util.*;

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
  public int maxPathSum(TreeNode root) {
    HashMap<TreeNode, Integer> pathSum = new HashMap<>();
    return maxPathSum(pathSum, root);
  }

  public int maxPathSum(HashMap<TreeNode, Integer> pathSum, TreeNode node){
    if(node == null){
      pathSum.put(node, Integer.MIN_VALUE);
      return Integer.MIN_VALUE;
    }
    if(node.left == null && node.right == null){
      pathSum.put(node, node.val);
      return node.val;
    }

    int max = Integer.MIN_VALUE;
    max = Math.max(max,maxPathSum(pathSum, node.left));
    max = Math.max(max, maxPathSum(pathSum, node.right));

    putPath(pathSum, node);
    int sum = node.val;
    int leftPath = pathSum.get(node.left);
    int rightPath = pathSum.get(node.right);
    if(leftPath > 0)
      sum += leftPath;
    if(rightPath > 0)
      sum += rightPath;
    max = Math.max(max, sum);

    // max는 전체 max
    return max;
  }

  public void putPath(HashMap<TreeNode, Integer> pathSum, TreeNode node){
    int sum = node.val;
    int left = 0;
    if(node.left != null){
        left = Math.max(node.left.val, pathSum.get(node.left));
    }
    int right = 0;
    if(node.right != null)
      right = Math.max(node.right.val, pathSum.get(node.right));
    sum += Math.max(right, left);
    pathSum.put(node, sum);
  }
}


// Solution
// max_sum을 전체 변수로 설정해놓음으로써 매번 highest인 상태의 것을 저장할 필요가 없음
class Solution {
  int max_sum = Integer.MIN_VALUE;

  public int max_gain(TreeNode node) {
    if (node == null) return 0;

    // max sum on the left and right sub-trees of node
    int left_gain = Math.max(max_gain(node.left), 0);
    int right_gain = Math.max(max_gain(node.right), 0);

    // the price to start a new path where `node` is a highest node
    int price_newpath = node.val + left_gain + right_gain;

    // update max_sum if it's better to start a new path
    max_sum = Math.max(max_sum, price_newpath);

    // for recursion :
    // return the max gain if continue the same path
    return node.val + Math.max(left_gain, right_gain);
  }

  public int maxPathSum(TreeNode root) {
    max_gain(root);
    return max_sum;
  }
}