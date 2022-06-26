// NO DUPLICATES
// Brute Force
// O(N)
// -1 0 2 5 6 7 8 9
int findMagicIndex(int[] list){
	int idx = 0;
	for(idx = 0; idx < list.size; idx++){
		if(list[idx] == idx)
			return idx;
	} 
	return -1;
}

// Binary Search
// O(logN)
int findMagicIndex(int[] list){
	return findMagicIndex(list, 0, list.length);
}

int findMagicIndex(int[] list, int start, int end){
	int mid = (start+end)/2;

	if(list[mid] == mid)
		return mid;
	if(list[mid] < mid)
		return findMagicIndex(list, mid+1, end);
	else
		return findMagicIndex(list, start, mid-1);	
	return -1;
}


// Solution
// With Duplicates
int findMagicIndex(int[] list){
	return findMagicIndex(list, 0, list.length);
}

int findMagicIndex(int[] list, int start, int end){
	if(end < star)	return -1;

	int mid = (start+end)/2;
	if(list[mid] == mid)
		return mid;
	
	int leftIdx = Math.min(list[mid], mid-1);
	int left = findMagicIndex(list, start, leftIdx);
	if(left >= 0)	return left;

	int rightIdx = Math.max(list[mid], mid+1);
	int right = findMagicIndex(list, rightIdx, end);
	if(right >= 0)	return right;

	return -1;
}
