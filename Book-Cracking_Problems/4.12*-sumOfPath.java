int count = 0;
// DFS

void pathOfSum(TreeNode root, int dest){
	pathOfSum(root, 0, dest);
	return count;
}

ArrayList<Integer> pathOfSum(TreeNode node, int sum, int dest){
	if(node == null)
		return new ArrayList<>();

	ArrayList<Integer> res = new ArrayList<>();
	res.add(node.val);

	ArrayList<Integer> leftSum = pathOfSum(node.left, sum, dest);
	ArrayList<Integer> rightSum = pathOfSum(node.right, sum, dest);
	
	if(node.val == dest)
		count++;	

	for(int num: leftSum){
		res.add(num + node.val);
		if(num + node.val == dest)
			count++;
	}
	for(int num: rightSum){
		res.add(num + node.val);
		if(num + node.val == dest)
			count++;
	}
	
	return res;
}


// Solution
int countPathWithSum(TreeNode root, int targetSum){
	return countPathWithSum(root, targetSum, 0, new HashMap<>());
}

// hashmap key: number, value: num of path
int countPathWithSum(TreeNode node, int targetSum, int runningSum, HashMap<Integer, Integer> pathCount){
	if(node == null)	return 0;
	
	runningSum += node.val;
	int sum = runningSum - targetSum;
	int totalPath = pathCount.getOrDefault(sum, 0);
	
	if(runningSum == targetSum)
		totalPath++;

	updateHashMap(pathCount, runningSum, 1);
	countPathWithSum(node.left, targetSum, runningSum, pathCount);
	countPathWithSum(node.right, targetSum, runningSum, pathCount);
	updateHashMap(pathCount, runningSum, -1);

	return totalPath;
}

void updateHashMap(HashMap map, int key, int delta){
	int count = map.getOrDefault(key,0) + delta;
	if(count == 0)
		map.remove(key);
	else
		map.put(key, count);
}
