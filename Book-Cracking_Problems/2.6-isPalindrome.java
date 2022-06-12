// two way linked list
class Node{
  int data;
  Node prev;
  Node next;
}

public boolean isPalindrome(Node head) {
  Node left = head, right = head;
  
  while(right.next != null){
    right = right.next;
  }

  while(right.next != left){
    if(left.data != right.data){
      return false;
    }
    left = left.next;
    right = right.prev;
  }

  return true;
}
