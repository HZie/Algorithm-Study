

// BST
class Node{
	int val;
	Node left;
	Node right;
	public Node(int val){
		this.val = val;
		left = null;
		right = null;
}
}

class binarySearchTree{
	Node root = null
	
	public void insert(int val){
		if(root == null){
			root = new Node(val);
			return;
}

Node curr = root;
Node parent;

while(true){
	parent = curr;

	if(head.val > val){
		curr = curr.left;
		if(curr == null){
			parent.left = new Node(val);
			return;
}
}
else{
	curr = curr.right;
	if(curr == null){
		parent.right = new Node(val);
		return;
}
}
}

}
}

// To make the BST’s height minimal, we have to make root’s value as a value in middle index of sorted array.

class Node{
	int val;
	Node left;
	Node right;
	public Node(int val){
		this.val = val;
		left = null;
		right = null;
}
}

// at the end return root Node
public Node buildBST(int[] arr, int start, int end){
	if(end > start)
		return null;
int mid = (start + end) / 2;
Node curr = new Node(arr[mid]);
	
	curr.left = buildBST(arr, start, mid-1);
	curr.right = buildBST(arr, mid+1, end);

	return curr;
}
