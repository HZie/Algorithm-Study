/*
	Given a boolean expression consisting of the symbols 0 (false), 1 (true), & (AND), | (OR), and ^ (XOR), and a desired boolean result value result, implement a function to count the number of ways to parenthesizing the expression such that it evaluates to result.
	EXAMPLE
	countEval("1^0|0|1", false) -> 2
	countEval("0&0&0&1^1|0", true) -> 10
	Hints: #148, #168, #197, #305, #327
*/


// First Idea
// Giving up

int countEval(String expression, Boolean desiredResult){
	int count;
	
	
}

int countEval(String expression, Boolean desiredResult, int splitIndex){
	if(expression.size() == 1){
		if((desiredResult && expression.compareTo("1") == 0	) || (!desiredResult && expression.compareTo("0") == 0))
			return 1;
		return 0;
	}

	char op = expression.charAt(splitIndex);
	String leftExp = expression.split(0, splitIndex);
	String rightExp = expression.split(splitIndex+1);

	byte left = expressionResult(leftExp);
	byte right = expressionResult(rightExp);

	byte result = expressionResult(left+""+op+""+right);
	if((desiredResult && result == 1) || (!desiredResult && result == 0))
		count++;

	return count;
}

byte expressionResult(String expression){
	byte first = expression.charAt(i) - '0';
	for(int i = 1; i < expression.length()-1; i+=2){
		byte second = expression.charAt(i+1)-'0';
		switch(expression.charAt(i)){
			case '&':
				first = first & second;
				break;
			case '|':
				first = first | second;
				break;
			case '^':
				first = first ^ second;
				break;
			default:
				System.out.println("error");
				break;
		}
	}
	return first;
}






// Solution
int countEval(String s, boolean result){
	if(s.length() == 0)	return 0;
	if(s.length() == 1)	return stringToBool(s) == result ? 1:0;

	int ways = 0;
	for(int i = 1; i < s.length(); i+= 2){
		char c = s.charAt(i);
		String left = s.substring(0,i);
		String right = s.substring(i+1, s.length());
		
		/* Evaluate each side for each result */
		int leftTrue = countEval(left, true);
		int leftFalse = countEval(left, false);
		int rightTrue = countEval(right, true);
		int rightFalse = countEval(right, false);
		int total = (leftTrue + leftFalse) * (rightTrue + rightFalse);
		
		int totalTrue = 0;
		if(c =='^'){	// required: one true and one false
			totalTrue = leftTrue * rightFalse + leftFalse * rightTrue;
		}
		else if( c == '&'){	// required: both true
			totalTrue = leftTrue * rightTrue;
		}
		else if( c == '|'){	// required: anything but both false;
			totalTrue = total - (leftFalse * rightFalse);
		}

		int subWays = result ? totalTrue : total - totalTrue;
		ways += subways;
	}
	return ways;
}

boolean stringToBool(Stirng c){
	return c.equals("1") ? true : false;
}



// optimized using memoization

int countEval(String s, boolean result, HashMap<String, Integer> memo){
	if(s.length() == 0) return 0;
	if(s.length() == 1)	return stringToBool(s) == result ? 1 : 0;
	if(memo.containsKey(result+s))	return memo.get(result+s);

	int ways = 0;
	
	for(int i = 0; i < s.length(); i+= 2){
		char c = s.charAt(i);
		String left = s.substring(0,i);
		String right = s.substring(i+1, s.length());
		
		int leftTrue = countEval(left, true, memo);
		int leftFalse = countEval(left, false, memo);
		int rightTrue = countEval(right, true, memo);
		int rightFalse = countEval(right, false, memo);
		int total = (leftTrue + leftFalse) * (rightTrue + rightFalse);
		
		int totalTrue = 0;
		if(c =='^'){	// required: one true and one false
			totalTrue = leftTrue * rightFalse + leftFalse * rightTrue;
		}
		else if( c == '&'){	// required: both true
			totalTrue = leftTrue * rightTrue;
		}
		else if( c == '|'){	// required: anything but both false;
			totalTrue = total - (leftFalse * rightFalse);
		}

		int subways = result ? totalTrue : total - totalTrue;
		ways += subsways;
	}

	memo.put(result+s, ways);
	return ways;
}
