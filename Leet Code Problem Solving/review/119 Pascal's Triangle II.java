// https://leetcode.com/problems/pascals-triangle-ii/
// Easy

class Solution {
    public List<Integer> getRow(int rowIndex) {
        ArrayList<ArrayList<Integer>> Tri = new ArrayList<ArrayList<Integer>>();
        
        for(int i = 0; i <= rowIndex; i++){
            ArrayList<Integer> index = new ArrayList<>();
            if(i==0)
                index.add(1);
            else if(i==1){
                index.add(1);
                index.add(1);
            }
            else{
                ArrayList<Integer> formerIndex = Tri.get(i-1);
                for(int j = 0; j <= i; j++){
                    if(j == 0 || j == i)
                        index.add(1);
                    else{
                        index.add(formerIndex.get(j-1) + formerIndex.get(j));
                    }
                }
            }
            
            Tri.add(index);

        }
        
        return Tri.get(rowIndex);
    }
}

// time complexity: O(n^2)
// space complexity: O(1)