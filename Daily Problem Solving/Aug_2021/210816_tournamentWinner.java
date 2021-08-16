import java.util.*;

class Program {

  public String tournamentWinner(
      ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {
    // Write your code here.
		HashMap<String, Integer> map = new HashMap<>();
		String winner = "";
		int maxPoint = -1;
		
		for(int i = 0; i < results.size(); i++){
			String compWinner = "";
			int compResult = results.get(i);
			int score = 0;
			
			if(compResult == 1){ // home team wins
				compWinner = competitions.get(i).get(0);
			}
			else{	// home team loses
				compWinner = competitions.get(i).get(1);
			}
			
			score = map.getOrDefault(compWinner, 0)+3;
			map.put(compWinner, score);
			
			if(score > maxPoint){
				winner = compWinner;
				maxPoint = score;
			}
			
		}
		
    return winner;
  }
}
