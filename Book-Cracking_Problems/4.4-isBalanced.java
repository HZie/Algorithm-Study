/*
 *          1
 *      2       3
 *        4         5
 *      6   7         8
 * 
 * getHeight(2) - getHeight(3) = 3-3 = 0
 * 
 * getHeight(2) --> 3
 *    height = max(getHeight(null), getHeight(4))+1   --> 3
 *         getHeight(null) --> 0
 *         getHeight(4)
 *            height = max(getHeight(6), getHeight(7)) +1 --> 2
 *                getHeight(6)
 *                    height = max(getHeight(null), getHeight(null)) + 1 --> 1
 *                getHeight(7)
 *                    height = 1
 * 
 * getHeight(3) --> 3
 *    height = max(0, getHeight(5)) + 1 --> 3
 *        getHeight(5)
 *            height = max(0, getHeight(8)) + 1 --> 2
 *              getHeight(8) --> 0 + 1 --> 1
 *              
 * 
 */


public boolean isBalanced(Node root) {
  if(root == null)
    return true;
  int left = getHeight(root.left);
  if(left == -1)
    return false;
  int right = getHeight(root.right);
  if(right == -1)
    return false;
    
  if(Math.abs(left-right) > 1)
    return false;
  return true;
}

public int getHeight(Node node){
  if(node == null)
    return 0;
  
  int left = getHeight(node.left);
  if(left == -1)
    return -1;
  int right = getHeight(node.right);
  if(right == -1)
    return -1;

  if(Math.abs(left-right) > 1)
    return -1;

  int height = Math.max(left, right) + 1;
  
  return height;
}