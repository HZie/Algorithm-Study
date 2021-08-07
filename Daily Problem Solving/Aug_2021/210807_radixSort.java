import java.util.*;

class Program {

  public ArrayList<Integer> radixSort(ArrayList<Integer> array) {
    // Write your code here.
		ArrayList<Queue<Integer>> qList = new ArrayList<>();
		
		for(int i = 0;i <= 9; i++){
			qList.add(new LinkedList<Integer>());
		}
		
		int max = -1;
		
		for(int i = 0;i  < array.size(); i++){
			if(max < array.get(i))
				max = array.get(i);
		}
		
		int maxDigit = getDigit(max);
		
		int divider = 1;
		for(int i = 0; i < maxDigit; i++){
			for(int j = 0; j < array.size(); j++){
				int currNum = array.get(j);
				if(currNum == 0){
					qList.get(0).add(currNum);
					continue;
				}
				int index = (currNum/divider) % 10;
				qList.get(index).add(currNum);
			}
			
			array = init(qList);
			divider *= 10;
		}
		
    return array;
  }
	
	public int getDigit(int num){
		int temp = num/10;
		int count = 1;
		while(temp > 0){
			temp /= 10;
			count++;
		}
		
		return count;
	}
	
	public ArrayList<Integer> init(ArrayList<Queue<Integer>> list){
		int arrayIndex = 0;
		ArrayList<Integer> newArray = new ArrayList<>();
		for(int i = 0; i < list.size(); i++){
			while(list.get(i).peek() != null){
				newArray.add(list.get(i).poll());
			}
		}
		
		return newArray;
	}
	
}
