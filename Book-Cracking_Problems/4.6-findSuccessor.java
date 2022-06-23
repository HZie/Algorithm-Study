

/*
 *            1
 *        2       3
 * node: 2
 * ans: 1
 * 
 *             1
 *      2               3
 * 4        5      6        7
 *        8   9
 * 
 * node: 9
 * ans: 1
 * 
 * node: 3
 * ans: 7
 * 
 * node: 1
 * ans: 6
 * 
 * node: 7
 * ans: null
 * 
 * node: 4
 * ans: 2
 */



class Node{
  int val;
  Node parent;
  Node left, right;
}

public Node findSuccessor(Node node) {
  if(node.right != null){
    // next node
    Node curr = node.right;
    while(curr.left != null){
      curr = curr.left;
    }
    return curr;
  }

  // if right node is null then next right tree will be 
  Node curr = node;

  while(curr.parent.left == curr){
    curr = curr.parent;
    if(curr.parent == null)
      return null;
  }

  return curr.parent;
}

