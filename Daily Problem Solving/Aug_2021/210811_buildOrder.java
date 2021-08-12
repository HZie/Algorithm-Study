class Node{
	char val;
	boolean visit = false;
	ArrayList<Character> before = new ArrayList<>();
	ArrayList<Character> after = new ArrayList<>();
}

public char[] findBuildOrder(char[] projects, char[][] dependencies){
	Node start;
	HashMap<Character, Node> map = new HashMap<>();
	ArrayList<Character> ans = new ArrayList<>();
	Queue<Node> q = new LinkedList<>();
	
for(int i = 0; i < projects.length; i++){
		Node n = findDependencies(dependencies, projects[i]);
		map.put(projects[i], n);

		if(n.before.size() == 0){
			q.add(n);
			n.visit = true;
}
}

Node curr;

while(!q.isEmpty()){
	if(ans.size() >= projects.length)	return error;
	curr = q.poll();
	ans.add(curr.val);
	for(int i = 0; i < curr.after.size(); i++){
		Node adj = map.get(curr.after.get(i));
		if(adj.visit)	continue;

		adj.before.remove(curr.val);
		if(adj.before.size() == 0){
			q.add(adj);
			adj.visit = true;
}
}
}

if(ans.size() != projects.length)	return error;


	return ans;
}

public Node findDependencies(char[][] dependencies, char curr){
	Node n = new Node();
	n.val = curr;
	
	for(int i = 0; i < dependencies.length; i++){
		if(dependencies[i][0] == curr){
			n.after.add(dependencies[i][1]);
}
else if(dependencies[i][1] == curr){
	n.before.add(dependencies[i][0]);
}
}
return n;
}
