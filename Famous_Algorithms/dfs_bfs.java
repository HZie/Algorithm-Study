// pseudo code

// DFS
void DFS(Node root){
    if(root == null) return;
    visit(root);
    root.visited = true;
    for each (Node n in root.adjacent){
        if(n.visited == false){
            dfs(n);
        }
    }
}

// BFS
void BFS(Node root){
    Queue q = new Queue();
    root.visited = true;
    q.enqueue(root);

    while(!q.isEmpty()){
        Node r = q.dequeue();
        visit(r);
        for each (Node n in r.adjacent){
            if(n.visited == false){
                n.visited = true;
                q.enqueue(n);
            }
        }
    }
}
