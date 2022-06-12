class Node{
  int data;
  Node next;
}

public Node getKFromBack(Node head, int k) {
  Node ans = head, runner = head;
  for(int i = 0; i < k; i++){
    runner = runner.next;
  }

  while(runner != null){
    ans = ans.next;
    runner = runner.next;
  }

  return ans;
}
