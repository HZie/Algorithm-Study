// https://leetcode.com/problems/median-of-two-sorted-arrays/
// Hard
// Time: O((m+n)/2)
// Space: O(1)

/*
    Runtime: 2 ms, faster than 99.83% of Java online submissions for Median of Two Sorted Arrays.
    Memory Usage: 40.5 MB, less than 82.17% of Java online submissions for Median of Two Sorted Arrays.
*/

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[] merged = new int[(m+n)/2+1];
        
        int p1 = 0, p2 = 0;
        int i;
        for(i = 0; i < merged.length; i++){
            if(p1 == m || p2 == n){
                break;
            }
            
            if(nums1[p1] < nums2[p2]){
                merged[i] = nums1[p1];
                p1++;
            }
            else{
                merged[i] = nums2[p2];
                p2++;
            }
        }
        
        while(p1 < m && i < merged.length){
            merged[i] = nums1[p1];
            i++; p1++;
        }
        while(p2 < n && i < merged.length){
            merged[i] = nums2[p2];
            i++; p2++;
        }

        
        
        int sum = 0;
        double div = 1;
        
        sum += merged[merged.length-1];
        
        if((m+n)%2 == 0){
            div = 2;
            sum += merged[merged.length - 2];
        }
        
        return sum / div;
        
        
    }
}