/*
You have a stack of n boxes, with widths wi, heights hi, and depths di. The boxes cannot be rotated and can only be stacked on top of one another if each box in the stack is strictly larger than the box above it in width, height, and depth. Implement a method to compute the height of the tallest possible stack. The height of a stack is the sum of the heights of each box.
*/


/*
	Example:
	Box = [
		{w = 10, h = 5, d = 2},
		{w = 4, h = 2, d = 1},
		{w = 13, h = 10, d = 4}
	]
*/
class Box{
	int w, h, d;
	public Box(){}
	public Box(int w, int h, int d){
		this.w = w; this.h = h; this.d = d;
	}
}

int highestBoxTower(Box[] boxes){
	Collections.sort(boxes, (b1, b2) -> {retrun Integer.compare(b1.w, b2.w)});	// O(NlogN);
	int[] mem = new int[boxes.length];
	return highestBoxTower(boxes, new Box(0,0,0), 0, 0, mem);
}

int highestBoxTower(Box[] boxes, Box lastBox, int idx, int sum, int[] mem){
	if(idx >= boxes.length){
		return 0;
	}
	Box currBox = boxes[idx];
	int start = currBox.h;
	// stack
	if(currBox.h > lastBox.h && currBox > lastBox.d){
		if(mem[idx] > 0){
			sum += mem[idx];
		}
		else{
	sum += currBox.h;	
	sum = highestBoxTower(boxes, currBox, idx+1, sum);
		}
	}
	else{
		sum = highestBoxTower(boxes, lastBox, idx+1, sum);
		start = highestBoxTower(boxes, currBox, idx+1, start);
		mem[idx] = start;
	}

	
	return Math.max(start, sum);
}


// Solution
int createStack(ArrayList<Box> boxes){
	Collections.sort(boxes, new BoxComparator());
	int maxHeight = 0;
	for(int i = 0; i < boxes.size(); i++){
		int height = createStack(boxes, i);
		maxHeight = Math.max(maxHeight, height);
	}
	return maxHeight;
}

int createStack(ArrayList<Box> boxes, int bottomIndex){
	Box bottom = boxes.get(bottomIndex);
	int maxHeight = 0;
	for(int i = bottomIndex+1; i < boxes.size(); i++){
		if(boxes.get(i).canBeAbove(bottom)){
			int height = createStack(boxes, i);
			maxHeight = Math.max(height, maxHeight);
		}
	}
	maxHeight += bottom.height;
	return maxHeight;
}

class BoxComparator implements Comparator<Box>{
	@Override	
	public int compare(Box b1, Box b2){
		return b2.height - b1.height;
	}
}


// Using memoization not seeing solution (but using above solution)
int createStack(ArrayList<Box> boxes){
	Collections.sort(boxes, new BoxComparator());
	Box[] mem = new Box[boxes.size()];
	int maxHeight = 0;
	for(int i = 0; i < boxes.size(); i++){
		int height = mem[i];
		if(height <= 0){
			height = createStack(boxes, i, mem);
		}
		maxHeight = Math.max(maxHeight, height);
	}
	return maxHeight;
}

int createStack(ArrayList<Box> boxes, int bottomIndex, Box[] mem){
	Box bottom = boxes.get(bottomIndex);
	int maxHeight = 0;
	for(int i = bottomIndex+1; i < boxes.size(); i++){
		if(boxes.get(i).canBeAbove(bottom)){
			int height = mem[i];
			if(height <= 0){
				height = createStack(boxes, i, mem);
			}
			maxHeight = Math.max(height, maxHeight);
		}
	}
	maxHeight += bottom.height;
	mem[bottomIndex] = maxHeight;
	return maxHeight;
}

class BoxComparator implements Comparator<Box>{
	@Override	
	public int compare(Box b1, Box b2){
		return b2.height - b1.height;
	}
}

// Solution using Memoization
int createStack(ArrayList<Box> boxes){
	Collections.sort(boxes, new BoxComparator());
	int maxHeight = 0;
	int[] stackMap = new int[boxes.size()];
	for(int i = 0; i < boxes.size(); i++){
		int height = createStack(boxes, i, stackMap);
		maxHeight = Math.max(height, maxHeight);
	}
	return maxHeight;
}

int createStack(ArrayList<Box> boxes, int bottomIndex, int[] stackMap){
	if(bottomIndex < boxes.size() && stackMap[bottomIndex] > 0){
		return stackMap[bottomIndex];
	}
	
	Box bottom = boxes.get(bottomIndex);
	int maxHeight = 0;
	for(int i = bottomIndex+1; i < boxes.size(); i++){
		if(boxes.get(i).canBeAbove(bottom)){
			int height = createStack(boxes, i, stackMap);
			maxHeight = Math.max(height, maxHeight);
		}
	}
	maxHeight += bottom.height;
	stackMap[bottomIndex] = maxHeight;
	return maxHeight;
}


// Another Solution
int createStack(ArrayList<Box> boxes){
	Collections.sort(boxes, new BoxComparator());
	int[] stackMap = new int[boxes.size()];
	return createStack(boxes, null, 0, stackMap);
}

int createStack(ArrayList<Box> boxes, Box bottom, int offset, int[] stackMap){
	if(offset >= bodes.size()) return 0;
	
	/* height with this bottom */
	Box newBottom = boxes.get(offset);
	int heightWithBottom = 0;
	if(bottom == null || lnewBottom.canBeAbove(bottom)){
		if(stackMap[offset] == 0){
			stackMap[offset] = createStack(boxes, newBottom, offset+1, stackMap);
			stackMap[offset] += newBottom.height;
		}
		heightWithBottom = stackMap[offset];
	}

	/* Without this bottom */
	int heightWithoutBottom = createStack(boxes, bottom, offset+1, stackMap);

	return Math.max(heightWithBottom, heightWithoutBottom);
}
