ArrayList<String> makeBracket(int num){
	HashSet<String> set = new HashSet<>();
	ArrayList<String> res = new ArrayList<>();
	makeBracket(num, "", res);
	return res;
}

void makeBracket(int num, String prev, ArrayList<String> res){
	if(num == 0){
		if(set.conatins(prev)
			return;
		set.add(prev);
		res.add(prev);
		return;
	}

	makeBracket(num-1, "()"+prev, res);
	makeBracket(num-1, "("+prev+")", res);
	makeBracket(num-1, prev+"()", res);
}

// 위의 방법은 중복을 만들고 체크하기때문에 그다지 효율적이지 않음

// SOLUTION

ArrayList<String> generateParens(int count){
	char[] str = new char[count*2];
	ArrayList<String> list = new ArrayList<>();
	addParen(list, count, count, str, 0);
	return list;
}

void addParen(ArrayList<String> list, int leftRem, int rightRem, char[] str, int index){
	if(leftRem < 0 || rightRem < leftRem)	return;	// error
	
	if(leftRem == 0 && rightRem == 0){	// complete
		list.add(String.copyValueOf(str));
	}	
	else{
		str[index] = '(';		// add left bracket
		addParen(list, leftRem-1, rightRem, str, index+1);
		str[index] = ')';
		addParen(list, lefrRem, rightRem-1, str, index+1);
	}
}
