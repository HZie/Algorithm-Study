import java.util.*;

class Program {

  public int firstNonRepeatingCharacter(String string) {
    // Write your code here.
		HashMap<Character, Integer> frequency = new HashMap<>();
		
		for(int i = 0; i < string.length(); i++){
			char ch = string.charAt(i);
			frequency.put(ch, frequency.getOrDefault(ch,0)+1);
		}
		
		for(int i = 0; i < string.length(); i++){
			char ch = string.charAt(i);
			if(frequency.get(ch) == 1)
				return i;
		}
		
    return -1;
  }
}
