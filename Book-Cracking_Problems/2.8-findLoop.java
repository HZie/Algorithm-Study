class Node{
  int data;
  Node next;
}

public Node findLoop(Node h) {
  Node slow = h, runner = h;

  while(fast != null && fast.next != null){
    fast = fast.next.next;
    slow = slow.next;
    if(fast == slow)
      break;
    if(fast == null || fast.next == null)
      return null;
  }
  slow = head;

  while(slow != fast){
    slow = slow.next;
    fast = fast.next;
  }

  return fast;
}
