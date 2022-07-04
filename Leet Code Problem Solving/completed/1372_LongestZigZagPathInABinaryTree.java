/*
class TreeNode{
	int val;
	TreeNode left, right;
	TreeNode(){}
	TreeNode(int val){this.val = val;}
	TreeNode(int val, TreeNode left, TreeNode right){
		this.val = val;
		this.left = left;
		this.right = rigth;
	}
}
*/

// First Idea :	 Use DFS
// Time: O(N) where N is number of nodes in tree
class Solution{
	int max;
	public int longestZigZag(TreeNode root){
		max = Integer.MIN_VALUE;
		longestZigZag(root, 0, true);
		longestZigZag(root, 0, false);
		return max;
	}
	
	public void longestZigZag(TreeNode node, int path, boolean isLeft){
		if(node == null){	// exit condition
			max = Math.max(max, path-1);
			return;
		}
		if(isLeft){
			longestZigZag(node.left, 1, true);
			longestZigZag(node.right, path+1, false);
		}
		else{
			longestZigZag(node.left, path+1, true);
			longestZigZag(node.right, 1, false);
		}
	}
}
