class Node{
  int val;
  Node left;
  Node right;
}

boolean flag = true;

public boolean isBST(Node root){
  int flag = true;
  int[] minMax = {Integer.MAX_VALUE, Integer.MIN_VALUE};
  isBST(root, minMax);

  return flag;
}

// in order if something decrease then it is not bst
public void isBST(Node node, int[] minMax) {
  if(!flag)
    return;

  if(node.left == null && node.right == null){
    minMax[0] = Math.min(minMax[0], node.val);
    minMax[1] = Math.max(minMax[1], node.val);
    return;
  }

  isBST(node.left, minMax);
  if(node.val > minMax[1]){
    flag = false;
    return;
  }
  minMax[0] = Math.min(minMax[0], node.val);
  minMax[1] = Math.max(minMax[1], node.val);

  isBST(node.right, minMax);

  if(node.val < minMax[0]){
    flag = false;
    return;
  }
}


// Solution

boolean checkBST(Node n){
  return checkBST(n, null, null);
}

boolean checkBST(Node n, Integer min, Integer max){
  if(n == null) 
    return true;
  
  if((min != null && n.data <= min) || (max != null && n.data > max)){
    return false;
  }

  if(!checkBST(n.left, min, n.data) || !checkBST(n.right, n.data, max)){
    return false;
  }

  return true;
}