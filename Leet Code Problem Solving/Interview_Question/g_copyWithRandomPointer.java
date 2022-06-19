import java.util.*;

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
  public Node copyRandomList(Node head) {
    HashMap<Node, Integer> listMap = new HashMap<>();
    HashMap<Integer, Node> map = new HashMap<>();
    Node curr = head;
    Node ans=null, ansCurr=ans;
    int index = 0;

    if(head == null)
      return null;
    while(curr != null){
      listMap.put(curr, index);
      if(ans == null){
        ans = new Node(curr.val);
        ansCurr = ans;
      }
      else{
        ansCurr.next = new Node(curr.val);
        ansCurr = ansCurr.next;
      }
      map.put(index, ansCurr);
      index++;
      curr = curr.next;
    }

    curr = head;
    ansCurr = ans;
    while(curr != null){
      if(curr.random == null){
        ansCurr.random = null;
      }
      else{
        int randIdx = listMap.get(curr.random);
        ansCurr.random = map.get(randIdx);
      }
      curr = curr.next;
      ansCurr = ansCurr.next;
    }

    return ans;
  }
}


// Iterative with O(1) space

/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/
public class Solution {
  public Node copyRandomList(Node head) {

    if (head == null) {
      return null;
    }

    // Creating a new weaved list of original and copied nodes.
    Node ptr = head;
    while (ptr != null) {

      // Cloned node
      Node newNode = new Node(ptr.val);

      // Inserting the cloned node just next to the original node.
      // If A->B->C is the original linked list,
      // Linked list after weaving cloned nodes would be A->A'->B->B'->C->C'
      newNode.next = ptr.next;
      ptr.next = newNode;
      ptr = newNode.next;
    }

    ptr = head;

    // Now link the random pointers of the new nodes created.
    // Iterate the newly created list and use the original nodes' random pointers,
    // to assign references to random pointers for cloned nodes.
    while (ptr != null) {
      ptr.next.random = (ptr.random != null) ? ptr.random.next : null;
      ptr = ptr.next.next;
    }

    // Unweave the linked list to get back the original linked list and the cloned list.
    // i.e. A->A'->B->B'->C->C' would be broken to A->B->C and A'->B'->C'
    Node ptr_old_list = head; // A->B->C
    Node ptr_new_list = head.next; // A'->B'->C'
    Node head_old = head.next;
    while (ptr_old_list != null) {
      ptr_old_list.next = ptr_old_list.next.next;
      ptr_new_list.next = (ptr_new_list.next != null) ? ptr_new_list.next.next : null;
      ptr_old_list = ptr_old_list.next;
      ptr_new_list = ptr_new_list.next;
    }
    return head_old;
  }
}