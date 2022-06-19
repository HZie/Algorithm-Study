import java.util.Queue;

class Node{
  public String name;
  public Node[] adj;
}

class Graph{
  public Node[] nodes;
}

public boolean isPathExist(Graph g, Node n1, Node n2) {
  // BFS를 사용하고 양방향 탐색을 하여 충돌하는 지점이 있는지 확인한다.

  Queue<Node> q1 = new Queue<>();
  Queue<Node> q2 = new Queue<>();
  HashSet<Node> visit1 = new HashSet<>();
  HashSet<Node> visit2 = new HashSet<>();
  visit1.add(n1);
  visit2.add(n2);
  q1.add(n1);
  q2.add(n2);

  while(!q1.isEmpty() && !q2.isEmpty()){
    Node cur1 = q1.poll();
    for(Node n: cur1.adj){
      if(visit2.contains(n)){
        return true;
      }
      if(visit1.contains(n))
        continue;
      visit1.add(n);
      q1.add(n);
    }

    Node cur2 = q2.poll();
    for(Node n: cur2.adj){
      if(visit1.contains(n))
        return true;
      if(visit2.contians(n))
        continue;
      visit2.add(n);
      q2.add(n);
    }
  }

  return false;
}
