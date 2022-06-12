// two way linked list

class Node{
  int data;
  Node prev;
  Node next;
}

public void sortWithPivot(Node head, int pivot) {
  Node left = head, right = head;
  while(right.next != null){
    right = right.next;
  }

  while(right.next != left){
    if(left.data >= pivot && right.data < pivot){
      swap(left, right);
    }
    if(left.data < pivot){
      left = left.next;
    }
    if(right.data >= pivot){
      right = right.prev;
    }
  }
}

public swap(Node n1, Node n2){
  n1.prev.next = n2;
  n1.next.prev = n2;

  n2.prev.next = n1;
  n2.next.prev = n1;
}
