class Node{
  int data;
  Node next;
}

public Node findIntersection(Node h1, Node h2) {
  // O(AB) where A = size of list 1, B = size of list 2
  Node n1 = h1, n2 = h2;

  while(n1 != null){
    while(n2 != null){
      if(n1 == n2)
        return n1;
      n2 = n2.next;
    }
    n1 = n1.next;
  }

  return null;
}

// O(A+B) where A = size of list 1, B = size of list 2
public Node findIntersection(Node h1, Node h2){
  Node n1 = h1, n2 = h2;
  int n1Len = 0, n2Len = 0;

  while(n1.next != null){
    n1 = n1.next;
    n1Len++;
  }
  while(n2.next != null){
    n2 = n2.next;
    n2Len++;
  }
  
  if(n1 != n2)
    return null;
  
  n1 = h1; n2 = h2;
  if(n1Len != n2Len){
    if(n1Len > n2Len){
      while(n1Len > n2Len){
        n1Len--;
        n1 = n1.next;
      }
    }
    else{
      while(n2Len > n1Len){
        n2Len--;
        n2 = n2.next;
      }
    }
  }

  while(n1 != n2){
    n1 = n1.next;
    n2 = n2.next;
  }

  return n1;
}
