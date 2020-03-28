// https://leetcode.com/problems/merge-two-sorted-lists/
// Easy
// time complexity: O(l1.length + l2.length)
// space complexity: O(1)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode ln1 = l1, ln2 = l2;
        ListNode merged = null;
        ListNode mergedChng = null;
        
        if(l1 == null){
            return l2;
        }
        else if(l2 == null){
            return l1;
        }
        while(ln1 != null && ln2 != null){
            if(merged == null){
                if(ln1.val < ln2.val){
                    merged = new ListNode(ln1.val);
                    ln1 = ln1.next;
                }
                else{
                    merged = new ListNode(ln2.val);
                    ln2 = ln2.next;
                }
                mergedChng = merged;
            }
            else{
                if(ln1.val < ln2.val){
                    mergedChng.next = new ListNode(ln1.val);
                    ln1 = ln1.next;
                }
                else{
                    mergedChng.next = new ListNode(ln2.val);
                    ln2 = ln2.next;
                }
                mergedChng = mergedChng.next;
            }
        }
        
        if(ln1 != null){
            while(ln1 != null){
                mergedChng.next = new ListNode(ln1.val);
                ln1 = ln1.next;
                mergedChng = mergedChng.next;
            }
        }
        else if(ln2 != null){
            while(ln2 != null){
                mergedChng.next = new ListNode(ln2.val);
                ln2 = ln2.next;
                mergedChng = mergedChng.next;
            }
        }
        
        return merged;
    }
}