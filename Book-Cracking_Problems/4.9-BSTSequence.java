// Hint: #39, #48, #66 , #82
// Answer: p362

 // pre-order

 public List<List<Integer>> bstSequence(TreeNode root){
	ArrayList<List<Integer>> ans = new ArrayList<>();
	list.put(root.val);

	return ans;
}

public void readTree(TreeNode root, List<Integer> list, List<List<Integer>> ans){
	if(root == null)
		return;
	list.put(root.val);

	List<Integer> leftList = list.clone();
	List<Integer> rightList = list.clone();
	// from left to right
	readTree(root.left, leftList);
	readTree(root.right, leftList);

	// from right to left
	readTree(root.right, rightList);
	readTree(root.left, rightList);

	
}


// solution

//	make left and right sequence and weave
ArrayList<LinkedList<Integer>> allSequences(TreeNode node){
	ArrayList<LinkedList<Integer>> result = new ArrayList<>();
	if(node == null){
		result.add(new LinkedList<>());
		return result;
	}
	
	LinkedList<Integer> prefix = new LinkedList<>();
	prefix.add(node.val);

	// recursion
	ArrayList<LinkedList<Integer>> leftList = allSequences(node.left);
	ArrayList<LinkedList<Integer>> rightList = allSequences(node.right);

	// weave left and right list
	for(LinkedList left: leftList){
		for(LinkedList right: rightList){
			ArrayList<LinkedList<Integer>> weaved = new ArrayList<>();
			weaveLists(left, right, weaved, prefix);
			result.addAll(weaved);
		}
	}
	return result;
}

// make all possible results
void weaveLists(LinkedList first, LinkedList second, ArrayList<LinkedList<Integer>> results, LinkedList prefix){
	// escape condition	
	if(first.size() == 0 || second.size() == 0 ){
		LinkedList<Integer> result = (LinkedList)prefix.clone();
		result.addAll(first);
		result.addAll(second);
		results.add(result);
		return;
	}

	// slice first list
	int headFirst = first.removeFirst();
	prefix.addLast(headFirst);
	weaveLists(first, second, results, prefix);
	prefix.removeLast();
	first.addFirst(headFirst);

	// slice second list
	int headSecond = second.removeFirst();
	prefix.addLast(headSecond);
	weaveLists(first, second, results, prefix);
	prefix.removeLast();
	second.addFirst(headSecond);
}
