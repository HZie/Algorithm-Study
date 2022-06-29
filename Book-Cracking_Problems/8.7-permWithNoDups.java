List<String> permWithNoDups(String str){	
	ArrayList<String> res = new ArrayList<>();

	for(int i = 0; i < str.length(); i++){
		addChar(str.charAt(i), res);
	}
	
	return res;
}

public void addChar(char c, List<String> res){
	if(res.size() == 0){
		res.add(c+"");
		return;
	}
	
	StringBuilder sb = new StringBuilder();	
	ArrayList<String> newList = new ArrayList<>();

	for(int k = 0; k < res.size(); k++){
		sb = (StringBuilder) res.get(i);
		for(int i = 0; i <= sb.length(); i++){
			sb.insert(c, i);
			newList.add(sb.toString());
			sb.deleteCharAt(i);
		}
	}

	res.clear();
	res.addAll(newList);
}
