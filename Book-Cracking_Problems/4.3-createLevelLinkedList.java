import java.util.LinkedList;
import java.util.Queue;

class Node{
  int val;
  Node left;
  Node right;
  public Node(){}
  public Node(int val){this.val = val;}
}

/*
 *            1
 *       2          3
 *    4     5   6     
 * 
 * q: [1, null]
 * res: []
 * lvl: 0
 * 
 * while
 *    list: []
 * res:[ { 0: [] } ]
 *    while
 *      n = 1
 *      list: [1]
 *      q: [null, 2, 3]
 * 
 * 
 * q: [2,3,null]
 * res: [
 *        {0: [1]},
 *      ] 
 * lvl: 1
 * 
 * while
 *    list: []
 * res: [
 *        {0: [1]},
 *        {1: []}
 *      ]
 *    while - 1
 *      n = 2
 *      list: [2]
 *      q:[3, null, 4, 5]
 *    while - 2
 *      n = 3
 *      list: [2,3]
 *      q: [null, 4, 5, 6]
 * 
 * 
 * q: [4, 5, 6, null]
 * res: [{0: [1]}, {1: [2,3]}]
 * lvl: 2
 * 
 * while
 *    list: []
 * res: [ {0: [1]}, {1: [2,3]}, {2: []}]
 *    while - 1
 *      n = 4
 *      list: [4]
 *      q: [5, 6, null]
 *    while - 2
 *      n = 5
 *      list: [4, 5]
 *      q: [6, null]
 *    while - 3
 *      n = 6
 *      list: [4, 5, 6]
 *      q: [null, null]
 *      
 * 
 * 
 */

public HashMap<Integer, LinkedList<Node>> createLevelLinkedList(Node root) {
  // BFS 사용
  Queue<Node> q = new Queue<>();
  HashMap<Integer, LinkedList<Node>> res = new HashMap<>();
  q.add(root);
  q.add(null);
  int lvl = 0;

  while(!q.isEmpty()){
    LinkedList<Node> list = new LinkedList<>();
    while(q.peek() != null){
      Node n = q.poll();
      list.add(n);
      if(n.left != null)
        q.add(n.left);
      if(n.right != null)
        q.add(n.right);
      if(q.peek() == null)
        q.add(null);
    }
    if(!list.isEmpty())
      res.put(lvl, list);
    q.poll();
    lvl++;
  }
  
  return res;
}
