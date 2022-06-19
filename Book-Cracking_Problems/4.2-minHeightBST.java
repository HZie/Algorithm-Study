class Node{
  int val;
  Node left;
  Node right;
}

class Tree{
  Node root;
}

public Tree minHeightBST(int[] arr){
  Tree t = new Tree();
  Node root = new Node();
  t.root = root;
  minHeightBST(root, arr, 0, arr.length);
  return t;
}

// sorted array
public void minHeightBST(Node node, int[] arr, int start, int end) {
  if(end < start)
    return null;
  int len = end-start;
  if(len == 1){
    node.val = arr[start];
    return;
  }
  node.val = arr[start+len/2];
  node.left = new Node();
  node.right = new Node();
  minHeightBST(node.left, arr, start, start+len/2);
  minHeightBST(node.right, arr, start+len/2, end);
}
