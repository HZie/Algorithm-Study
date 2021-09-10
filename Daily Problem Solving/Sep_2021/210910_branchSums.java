import java.util.*;

class Program {
  // This is the class of the input root. Do not edit it.
  public static class BinaryTree {
    int value;
    BinaryTree left;
    BinaryTree right;

    BinaryTree(int value) {
      this.value = value;
      this.left = null;
      this.right = null;
    }
  }

  public static List<Integer> branchSums(BinaryTree root) {
    // Write your code here.
		ArrayList<Integer> answer = new ArrayList<>();
		
		dfs(root, 0, answer);
		
    return answer;
  }
	
	public static void dfs(BinaryTree node, int sum, List<Integer> answer){
		if(node.left == null && node.right == null){
			answer.add(sum+node.value);
			return;
		}
		
		sum += node.value;
	
		if(node.left != null)
			dfs(node.left, sum, answer);
		
		if(node.right != null)
			dfs(node.right, sum, answer);
		
	}
	
}
