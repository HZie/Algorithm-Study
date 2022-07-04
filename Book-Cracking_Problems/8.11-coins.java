/*
	쿼터(25센트), 다임(10센트), 니켈(5센트), 페니(1센트)의 네 가지 동전이 무한히 주어졌을 때, n센트를 표현하는 모든 방법의 수를 계산하는 코드를 작성하라.
	힌트: #200, #324, #343, #380, #394
	정답: 481쪽
*/

/*
	First Idea:
	by using recursion, add numOfPaying(n-1), numOfPaying(n-5), numOfPaying(n-10), numOfPaying(n-25)
	escape condition is when n == 0 (returns 1) or n < 0
*/

// time complexity: 4^N since each method calls 4 method and the depth of tree of recursion is N (when numOfPaying(n-1) is called every time

int numOfPaying(int n){
	if(n < 0)	// no such way
		return 0;
	if(n == 0)	// found one way
		return 1;	

	return numOfPaying(n-1) + numOfPaying(n-5) + numOfPaying(n-10) + numOfPaying(n-25);
}

// Second Idea: use Memoization

int numOfPaying(int n){
	HashMap<Integer, Integer> map = new HashMap<>();
	numOfPaying(n, map);	
	return map.get(n);
}

int numOfPaying(int n, HashMap<Integer, Integer> map){
	if(n < 0)	// no way
		return 0;
	if(n == 0)
		return 1;
	if(map.containsKey(n))
		return n;
	
	int count = numOfPaying(int n-1, map) + numOfPaying(n-5, map) + numOfPaying(n-10, map) + numOfPaying(n-25, map);
	map.put(n, count);
	return count;
}



// Third Idea after watch hint #343

int numOfPaying(int n){
	return numOfPaying(n, 25);
}

int numOfPaying(int n, int coin){
	if(coin == -1 && n > 0)
		return 0;

	int nextCoin=-1;

	switch(coin){
		case 25: nextCoin = 10; break;
		case 10: nextCoin = 5; break;
		case 5: nextCoin = 1; break;
	}	
	int rem = n;
	int count = 0;
	while(	rem > 0){
		rem -= coin;
		if(rem == 0){
			count++;
			break;
		}
		count += numOfPaying(rem, nextCoin);
	}

	return count;
}

// Fourth Idea: Using memoization

int numOfPaying(int n){
	HashMap<Integer, Integer> map = new HashMap<>();
	return numOfPaying(n, 25, map);
}

int numOfPaying(int n, int coin, HashMap<Integer, Integer> map){
	if(coin == -1)
		return 0;
	if(map.containsKey(n)){
		return map.get(n);
	}

	int nextCoin=-1;

	switch(coin){
		case 25: nextCoin = 10; break;
		case 10: nextCoin = 5; break;
		case 5: nextCoin = 1; break;
	}	
	int rem = n;
	int count = 0;
	while(	rem > 0){
		rem -= coin;
		if(rem == 0){
			count++;
			break;
		}
		count += numOfPaying(rem, nextCoin);
	}

	map.put(n, count);
	return count;
}

// Solution

// no memoization

int makeChange(int n){
	int[] denoms = {25, 10, 5, 1};
	return makeChange(n, denoms, 0);
}

int makeChange(int amount, int[] denoms, int index){
	if(idex >= denoms.length-1)	return 1;	// last index
	int denomAmount = denoms[index];
	int ways = 0;
	for(int i = 0; i * denomAmount <= amount; i++){
		int remaining = amount - i * denomAmount;
		ways += makeChange(remaining, denoms, index+1);
	}
	return ways;
}

// using memoization

int makeChange(int n){
	int[] denoms = {25, 10, 5, 1};
	int[][] map = new int[n+1][denoms.length];	// memory
	return makeChange(n, denoms, 0, map);
}

int makeChange(int amount, int[] denoms, int index, int[][] map){
	if(map[amount][index] > 0){	// return already calculated one
		return map[amount][index];
	}
	if(index >= denoms.length-1)	return 1;	// last index
	int denomAmount = denoms[index];
	int ways = 0;	
	for(int i = 0; i * denomAmount <= amount; i++){
		int remaining = amount - i * denomAmount;
		ways += makeChange(remaining, denoms, index+1, map); 
	}
	map[amount][index] = ways;
	return ways;
} 
