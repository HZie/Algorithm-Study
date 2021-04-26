// https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/
// 난이도: Medium
// 직접 풀었음

class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        // 숫자의 개수ㅡhashmap으로 짜기
        HashMap<Integer, Integer> map = new HashMap<>();
        int length = A.length;  // A와 B의 길이가 같음
        
        for(int i = 0; i < length; i++){
            map.put(A[i], map.getOrDefault(A[i], 0)+1);
            map.put(B[i], map.getOrDefault(B[i], 0)+1);
        }
        
        ArrayList<Integer> candidate = new ArrayList<>();
        
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            if(entry.getValue() >= length){
                candidate.add(entry.getKey());
            }
        }
        
        if(candidate.size() == 0)
            return -1;
        
        int a_change = 0, b_change = 0;
        int min_change = Integer.MAX_VALUE;
        
        for(int c: candidate){
            boolean isPossible = true;
            for(int i = 0; i < length; i++){
                if(A[i] != c && B[i] != c){
                    isPossible = false;
                    continue;
                }
                if(A[i] == c && B[i] != c){
                    b_change++;
                }
                if(B[i] == c && A[i] != c){
                    a_change++;
                }
            }
            
            if(isPossible){
                min_change = Math.min(min_change, Math.min(a_change, b_change));
            }
        }
        
        if(min_change > length)
            return -1;
        
        return min_change;
    }
}

/*
// 다른 사람 코드
//  LOGIC: 2 cases 1)if value of a array are made same
//  			   2)if value of b array are made same
//  			   in both of the above cases arrays can have either a[0] or b[0] value


class Solution {
		public  int minDominoRotations(int[] A, int[] B) {

			int ans = Integer.MAX_VALUE;

			// a same value
			int a1 = countDominoSwaps(A, B, true, A[0]);
			int a2 = countDominoSwaps(A, B, true, B[0]);

			// b same value
			int b1 = countDominoSwaps(A, B, false, B[0]);
			int b2 = countDominoSwaps(A, B, false, A[0]);

			ans = Math.min(a1, Math.min(a2, Math.min(b1, b2)));

			return ans == Integer.MAX_VALUE ? -1 : ans;
		}

		public  int countDominoSwaps(int[] a, int[] b, boolean first, int val) {
			int ans = 0;
			for (int i = 0; i < a.length; i++) {
				if (first) {
					if (a[i] == val) {

					} else if (b[i] == val) {
						ans++;
					} else {
						return Integer.MAX_VALUE;
					}
				} else {
					if (b[i] == val) {

					} else if (a[i] == val) {
						ans++;
					} else {
						return Integer.MAX_VALUE;
					}
				}
			}
			return ans;
		}

	}
*/