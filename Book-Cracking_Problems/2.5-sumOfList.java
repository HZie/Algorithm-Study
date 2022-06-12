class Node{
  int data;
  Node next;

  public Node(){}
  public Node(int data){
    this.data = data;
    this.next = null;
  }
}

public Node sumOfList(Node h1, Node h2) {
  int carry = 0;

  Node num1 = h1, num2 = h2;
  Node ansHead = new Node();
  Node curr = ansHead;
  while(num1 != null && num2 != null){
    int sum = carry + num1.data + num2.data;
    
    if(sum >= 10){
      carry = sum / 10;
    }
    curr.data = sum % 10;
    curr.next = new Node();

    curr = curr.next;
    num1 = num1.next;
    num2 = num2.next;
  }

  return ansHead;
}

// if the list was not reversed
// it would be better use two way linked list and do the same thing like before.
// but if it is one way linked list, then make the list as a number and then make list

// one way linked list and list is not reversed
class Node{
  int data;
  Node next;
  public Node(){}
}

public Node sumOfList(Node h1, Node h2){
  int num1 = 0, num2 = 0;
  
  Node ansHead = new Node();
  Node curr = h1;
  while(curr != null){
    num1 *= 10;
    num1 += curr.data;
    curr = curr.next;
  }

  curr = h2;
  while(curr != null){
    num2 *= 10;
    num2 += curr.data;
    curr = curr.next;
  }
  int sum = num1 + num2;

  curr = ansHead;
  int digit = 1;
  while(curr != null){
    curr = curr.next;
    digit *= 10;
  }

  while(digit > 0){
    curr.data = sum / digit;
    sum %= digit;
    curr.next = new Node();
    curr = curr.next;
  }
  
  return ansHead;
}
