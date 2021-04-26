// https://leetcode.com/discuss/interview-question/553399/

// Question: Given an Array A, find the minimum amplitude you can get after changing up to 3 elements.
// Amplitude is the range of the array (basically difference between largest and smallest element).
// example 1
// input: [-1, 3, -1, 8, 5, 4]
// output: 2

// example 2
// input: [10, 10, 3, 4, 10]
// output: 0

// can change element up to 3
class Solution {
    public int minAmplitude(int[] amplitude) {

        if(amplitude.length <= 4)
            return 0;
        
        Arrays.sort(amplitude);
        
        int[] order = new int[4];
        int[] reverseOrder = new int[4];

        for(int i = 0; i < order.length; i++){
            order[i] = amplitude[i];
            reverseOrder[i] = amplitude[amplitude.length - 4 + i];
        }

        int min = Integer.MAX_VALUE;

        for(int i = 0; i < order.length; i++){
            int diff = reverseOrder[i] - order[i];
            if(min > diff)
                min = diff;
        }
        
        return min;
    }
}

// similar leet code problem
// https://leetcode.com/problems/minimum-difference-between-largest-and-smallest-value-in-three-moves/