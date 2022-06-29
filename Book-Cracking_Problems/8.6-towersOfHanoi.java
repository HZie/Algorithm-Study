void moveHanoi(int size, Stack<Integer> first, Stack<Integer> second, Stack<Integer> third){
	if(size == 1){
		int curr = first.pop();
		third.push(curr);
		return;
	}
	
	moveHanoi(size-1, first, third, second);
	int last = first.pop();
	third.push(last);
	moveHanoi(size-1, second, first, third);
	return;
}
