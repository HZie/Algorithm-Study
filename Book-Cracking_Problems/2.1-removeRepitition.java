// one way linked list without temp buffer (O(N^2))
// in case of using temp buffer, it wil be more efficient by using hash set(O(N))
/*  
class Node{
  int data;
  Node next;
}
 */
public void removeRepetition(Node head){
  // O(N^2)
  Node n = head, prev=head, runner = head.next;
  while(n.next != null){
    if(runner == null){
      n = n.next;
      prev = n;
      runner = n.next;
      continue;
    }

    if(n.data == runner.data){
      remove(prev, runner);
    }
    prev = prev.next;
    runner = runner.next;
  }
}

public void removeNode(Node prev, Node curr){
  prev.next = curr.next;
}

// two way linke list without temp buffer (O(N^2))
// in case of using temp buffer, it will be more efficient by using hash set (O(N))
/*
class Node{
  int data;
  Node prev;
  Node next;
}
 */
public void removeRepetition(Node head){
  Node n = head, runner = head.next;
  while(n.next != null){
    if(runner == null){
      n = n.next;
      runner = n.next;
    }
    if(n.data == runner.data){
      remove(runner);
    }
  }
}

public void removeNode(Node node){
  node.prev.next = node.next;
  node.next.prev = node.prev;
}