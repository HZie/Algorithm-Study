import java.util.*;

class Program {
	static int diff;
	static int answer = -1;
  public static int findClosestValueInBst(BST tree, int target) {
		diff = Integer.MAX_VALUE;
		BST node = tree;
			
		dfs(tree, target);
		
    return answer;
  }
	
	public static void dfs(BST node, int target){
		if(diff == 0)
			return;
		if(node == null)
			return;
		int currDiff = Math.abs(node.value - target);
				
		if(diff > currDiff){
			diff = currDiff;
			answer = node.value;
		}
		
		dfs(node.left, target);
		dfs(node.right, target);
	}

  static class BST {
    public int value;
    public BST left;
    public BST right;

    public BST(int value) {
      this.value = value;
    }
  }
}
