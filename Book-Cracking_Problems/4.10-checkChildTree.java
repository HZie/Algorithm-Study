// t1 is bigger than t2
// O(N+M*K) where N is number of T1 Nodes, M is number of T2 nodes, K is number of possible nodes
public boolean checkChildTree(TreeNode t1Root, TreeNode t2Root){
	ArrayList<TreeNode> possible = new ArrayList<>();
	
	findNode(t1Root, t2Root, possible);
	if(possible.size() == 0)
		return false;
	for(TreeNode p: possible){
		if(isSame(p, t2Root)
			return true;
	}
	return false;
}

// O(N) where N is number of nodes of T1
public void findNode(TreeNode root, TreeNode node, ArrayList<TreeNode> possible){
	if(root == null)
		return;
	if(root.val == node.val){
		possible.put(root);
	}

	TreeNode left = findNode(root.left, node, possible);
	TreeNode right = findNode(root.right, node, possible);
}

// O(M) where M is number of nodes of T2
public boolean isSame(TreeNode root1, TreeNode root2){
	if(root1 != root2)
		return false;

	if(root1 == null)
		return true;

	return isSame(root1.left, root2.left) && isSame(root1.right, root2.right);
}
