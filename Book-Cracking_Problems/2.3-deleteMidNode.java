class Node{
  int data;
  Node next;
}

public void deleteMidNode(Node head) {
  int node = head, prev = head, runner = head;
  
  while(runner.next != null){
    prev = node;
    node = node.next;
    runner = runner.next.next;
  }
  remove(prev, node);
}

public void remove(Node prev, Node node){
  prev.next = node.next;
}
