/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */


// TLE --> Solution : use ternarySearch not binarySearch
// Time: O(logN)
// binarySearch
public class Solution extends GuessGame {
  public int guessNumber(int n) {
      int lo=1, hi=n;
      int g = (lo+hi)/2;
      int res = guess(g);

      while(res != 0){
          if(res < 0){
              hi = g-1;
          }
          else{
              lo = g+1;
          }
          g = (lo+hi)/2;
          res = guess(g);
      }
      return g;
  }

  // using ternarySearch
  public int guessNumber(int n){
    int low = 1,  high = n;
    while(low <= high){
      int mid1 = low+(high-low)/3;
      int mid2 = high-(high-low)/3;
      int res1 = guess(mid1);
      int res2 = guess(mid2);
      if(res1 == 0)
        return mid1;
      if(res2 == 0)
        return mid2;
      
      if(res1 < 0)
        high = mid1-1;
      else if(res2 > 0)
        low = mid2+1;
      else{
        low = mid1+1;
        high = mid2-1;
      }
    }
    return -1;
  }
}