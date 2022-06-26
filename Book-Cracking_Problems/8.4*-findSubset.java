// Brute Force
// 1 2 3 4 5
// 2 3 4 5 / 1 3 4 5 / 1 2 4 5 / 1 2 3 5
// 3 4 5, 2 4 5, 
List<List<Integer>> findSubset(int[] list){
	ArrayList<List<Integer>> ans = new ArrayList<>();
	findSubset(Arrays.toList(list), ans);
	return ans;
}

void findSubset(ArrayList<Integer> list, List<List<Integer>> ans){
	for(int i = 0; i < list.size(); i++){
		ArrayList<Integer> newL = list.clone();
		newL.remove(i);
		if(!contains(list, ans)
			ans.add(list);
		findSubset(newL, ans);
	}
}

void contains(List<Integer> list, List<List<Integer>> set){
	for(List<Integer> l: set){
		if(list.containsAll(l))
			return true;
	}
	return false;
}


// Solution

// Recursion
List<List<Integer>> findSubset(ArrayList<Integer> list, int index){
	ArrayList<List<Ineger>> subsets;	
	// init
	if(list.size() == index){
		subsets = new ArrayList<>();
		subsets.add(new ArrayList<>());
	}
	else{
		subsets = findSubset(list, index+1);
		int item = list.get(index);
		ArrayList<ArrayList<Integer>> moreSub = new ArrayList<>();
		for(ArrayList<Integer> s : subsets){
			ArrayList<Integer> newS = s.clone();
			newS.add(item);
			moreSub.add(newS);
		}
		subsets.addAll(moreSub);
	}
	return subsets;
}

//Combinatorics
ArrayList<ArrayList<Integer>> findSubset(ArrayList<Integer> list){
	ArrayList<ArrayList<Integer>> res = new ArrayList<>();
	int max = 1 << list.size();
	for(int i = 0; i < max; i++){
		ArrayList<Integer> subset = intToList(i, list);
		res.add(subset);
	}

	return res;
}

ArrayList<Integer> intToList(int num, ArrayList<Integer> list){
	ArrayList<Integer> res = new ArrayList<>();
	int idx = 0;
	for(int i = num; i > 0; i >>= 1){
		if(i & 1) == 1)
			res.add(list.get(idx));
		index++;
	}
	return res;
}
