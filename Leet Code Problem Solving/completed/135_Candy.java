class Solution{
	public int candy(int[] ratings){
		int[] candies = new int[ratings.length];
		int bigStartIdx = 0;
		int count = 0;
        
		for(int i = 0; i < ratings.length; i++){
			if(i == 0){
				candies[i] = 1;
				count++;
			}
			else if(ratings[i-1] > ratings[i]){
				candies[i] = 1;
				for(int j = i-1; j >= bigStartIdx; j--){
					if(candies[j+1] + 1 <= candies[j]){
						break;
					}
					candies[j]++;
					count++;
				}
				count++;
			}
			else if(ratings[i-1] == ratings[i]){
				count++;
        	candies[i] = 1;
				bigStartIdx = i;
			}
			else{
				candies[i] = candies[i-1]+1;
				count += candies[i];
        	bigStartIdx = i;
			}
		}
		return count;
	}
}

// Solution
class Solution {
  public int candy(int[] ratings) { 
      int peak = 0 , valley = 0 , size = ratings.length,candy_count = size ;
      for(int i = 1 ; i< size ;){
          if(ratings[i] == ratings[i-1]){ i++ ; continue;}
          peak = 0 ;
          valley = 0;
          while( i< size && ratings[i] > ratings[i-1]){
              peak++;
              i++;
              candy_count += peak;
          }
             
          
          while(i<size && ratings[i] < ratings[i-1]){
              valley++;
              i++;
              candy_count += valley;
          }
             
          candy_count -= Math.min(peak,valley);
      }
      return candy_count;
  }
}

// easier solution
class Solution{
  public int candy(int[] ratings){
    int[] ans = new int[ratings.length];
    ans[0] = 1;
    for(int i = 1; i < ratings.length; i++){
      if(ratings[i] > ratings[i-1]) ans[i] = ans[i-1] + 1;
      else ans[i] = 1;
    }

    for(int i = ratings.length-2; i >= 0; i--){
      if(ratings[i] > ratings[i+1] && ans[i] <= ans[i+1])
        ans[i] = ans[i+1] + 1;
    }

    int res = 0;
    for(int n: ans) res+= n;
    return res;
  }
}