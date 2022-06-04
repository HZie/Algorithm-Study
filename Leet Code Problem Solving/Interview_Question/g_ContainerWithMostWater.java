// First Idea
// Time: O(N^2), Space: O(1)
// Time Limit Exceed

/*
 * make two pointer
 * one is start pointer, and the other one is end pointer
 * O(N^2) with search every possibility. and get max value
 */

import java.util.*;

class Solution {
  public int maxArea(int[] height) {
    int maxArea = 0;

    // i : start, j: end
    for(int i = 0; i < height.length; i++){
      for(int j = i+1; j < height.length; j++){
        int h = Math.min(height[i],height[j]);
        int w = j-i;
        maxArea = Math.max(maxArea, w*h);
      }
    }

    return maxArea;
  }
}

// Second Idea
// time: O(N), space: O(1)

/*
 * use two pointer. one starts from the start, the other one starts from the end.
 * make the index go forward or backward that has smaller height
 * compare the width 
 */

import java.util.*;

class Solution {
  public int maxArea(int[] height) {
    int start = 0, end = height.length-1;
    int answer = 0;

    // O(N);
    while(start < end){
      int minHeight = 0;
      int width = end-start;
      if(height[start] < height[end]){
        minHeight = height[start];
        start++;
      }
      else{
        minHeight = height[end];
        end--;
      }

      answer = Math.max(answer, minHeight * width);
    }

    return answer;
  }
}