ArrayList<String> permWithDups(String str){
	ArrayList<String> res = new ArrayList<>();
	//HashSet<String> contains = new HashSet<>();
	
	for(i = 0; i < str.length(); i++){
		perm(str.charAt(i), res);
	}
	return res;
}

void perm(char c, ArrayList<String> list){
	if(list.size() == 0){
		list.add(c+"");
		return;
	}

	ArrayList<String> newList = new ArrayList<>();
	StringBuilder sb;

	for(int k = 0; k < list.size(); k++){
		sb = (StringBuilder) list.get(i);
		
		for(int i = 0; i <= sb.length(); i++){
			if(i > 0 && sb.charAt(i-1) == c){
				continue;
			}
			
			sb.insert(c, i);
			newList.add(sb.toString());
			sb.deleteCharAt(i);
		} 

	}
	list.clear();
	list.addAll(newList);		
}


// Solution
ArrayList<String> printPerms(String s){
	ArrayList<String> result = new ArrayList<>();
	HashMap<Chacter,Integer> map = buildFreqTable(s);
	printPerms(map, "", s.length(), result);
	return result;
}

HashMap<Character, Integer> buildFreqTable(String s){
	HashMap<Character, Integer> map = new HashMap<>();
	for(int i = 0; i < s.length(); i++){
		char c = s.charAt(i);
		map.put(c, map.getOrDefault(c, 0)+1);
	}

	return map;
}

void printPerms(HashMap<Character, Integer> map, String prefix, int rem, ArrayList<String> res){
	if(rem == 0){
		res.add(prefix);
		return;
	}
	
	for(char c: map.keySet()){
		int count = map.get(c);
		if(count > 0){
			map.put(c, count-1);
			printPerms(map, prefix+c, rem-1, res);
			map.put(c, count);
		}
	}
}
