class TreeNode {
  int val;
  TreeNode left, right;
}

class Tree{
  TreeNode root;
}

public TreeNode firstAncester(TreeNode root, TreeNode node1, TreeNode node2) {
  
  if(root == null || root == node1 || root == node2)
    return root;

  boolean onLeft1 = contains(root.left, node1);
  boolean onLeft2 = contains(root.left, node2);

  // 더 깊은 곳에 부모가 있음
  if(onLeft1 != onLeft2){
    return root;
  }

  int next = onLeft1 ? root.left:root.right;
  return firstAncester(next, node1, node2);
}

public boolean contains(TreeNode root, TreeNode node){
  if(root == null)
    return false;
  if(root == node)
    return true;
  
  return(contains(root.left, node) || contains(root.right, node));
}
