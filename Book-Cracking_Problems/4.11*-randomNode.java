// First Idea
/*
	inside of Tree class, make arraylist and store all the nodes inside of it.
	When getting random node, get random index and return node of that index
	It makes space comlexity large and makes insert and delete slower
*/

// After the hints
/*
	inside of node class store number of children
*/

TreeNode getRandomNode(){
	return getRandomNode(root);
}

TreeNode getRandomNode(TreeNode node){
	int random = (Int)(Math.random() * (node.size+1)+1);
	if(node == 1)
		return node;
	if(random <= node.left.size)
		return getRandomNode(node.left);
	return getRandomNode(node.right);
}

void add(TreeNode node){
	Queue<TreeNode> q = new LinkedList<>();
	q.add(root);
	
	while(!q.isEmpty()){
		TreeNode curr = q.poll();
		if(curr.left == null){
			curr.size++;
			curr.left = node;	
			return;
		}
		if(curr.right == null){
			curr.size++;
			curr.right = node;	
			return;
		}
		q.add(curr.left);
		q.add(curr,right);
	}

	// update size
	updateSize(root);
}

int updateSize(TreeNode node){
	if(node == null)
		return 0;
	int leftSize = updateSize(node.left);
	int rightSize = updateSize(node.right);
	
	node.size = leftSize + rightSize;
}

void remove(){
	TreeNode curr = root;
	Queue<TreeNode> q = new LinkedList<>();
	q.add(root);
	
	while(!q.isEmpty()){
		curr = q.poll();
		if(curr.left != null)	q.poll(curr.left);
		if(curr.right != null) q.poll(curr.right);
	}
	if(curr.parent.left == curr)	curr.parent.left = null;
	if(curr.parent.right == curr)	curr.parent.right = null;
	curr.parent.size--;
	updateSize(root);
}




// Solution 
class Tree{
	TreeNode root = null;
	public size(){
		return root == null ? 0 : root.size();
	}

	public TreeNode getRandomNode(){
		if(root == null)	return null;
		
		Random random = new Random();
		int i = random.nextInt(size());
		return root.getIthNode(i);
	}

	public void insertInOrder(int value){
		if(root == null){
			root = new TreeNode(value);
		}
		else{
			root.insertInOrder(value);
		}
	}
}

class TreeNode{
	public TreeNode getIthNode(int i){
		int leftSize = left == null ? 0 : left.size();
		if(i < leftSize)
			return left.getIthNode(i);
		else if (i == leftSize)
			return this;
		else
			return right.getIthNode(i-(leftSize+1));
	}

	public int size(){return this.size;}
}
