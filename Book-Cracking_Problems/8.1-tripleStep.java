// bottom up
int tripleStep(int num){
	if(num == 1)	return 1;
	if(num == 2)	return 2;
	if(num == 3)	return 4;

	int a = 1, b = 2, c = 4;
	int res = 0;	

	for(int i = 4; i < num; i++){
		res = a + b + c;
		a = b;
		b = c;
		c = res;
	}
	return a + b + c;
}

// top down
int tripleStep(int num){
	return tripleStep(int num, new int[num+1]);
}

int tripleStep(int num, int[] mem){
	if(num == 1)	return 1;
	if(num == 2)	return 2;
	if(num == 3)	return 4;

	if(mem[num] == 0){
		mem[num] = tripleStep(num-1, mem) + tripleStep(num-2, mem) + tripleStep(num-3, mem);
	}

	return mem[num];
}


// solution
int tripleStep(int num){
	int[] mem = new int[num+1];
	Arrays.fill(memo, -1);
	return tripleStep(num, mem);
}
int tripleStep(int num, int[] mem){
	if(num <= 0) return 0;
	if(num == 0)	return 1;

	if(mem[num] == -1){
		mem[num] = tripleStep(num-1, mem) + tripleStep(num-2, mem) + tripleStep(num-3,mem);
	}
	return mem[num];
}
