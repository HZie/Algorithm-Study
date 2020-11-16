// https://leetcode.com/problems/add-two-numbers/
// Medium
// 다음번에는 더 깨끗하게 코드를 짜봐야겠다.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode curr = new ListNode();
        ListNode result = null;
        boolean isUp = false;
        boolean isFirst = true;
        
        while(l1 != null && l2 != null){
            if(isFirst){
                result = curr;
                isFirst = false;
            }
            else{
                curr.next = new ListNode();
                curr = curr.next;
            }
            int sum = l1.val + l2.val;
            
            if(isUp){
                sum++;
                isUp = false;
            }
            
            if(sum >= 10){
                curr.val = sum % 10;
                isUp = true;
            }
            else
                curr.val = sum;
            l1 = l1.next;
            l2 = l2.next;
        }
        
        while(l1 != null){
            curr.next = new ListNode();
            curr = curr.next;
            int value = l1.val;
            if(isUp){
                value++;
                isUp = false;
            }
            if(value >= 10){
                curr.val = value % 10;
                isUp = true;
            }
            else
                curr.val = value;
            l1 = l1.next;
        }
        
        while(l2 != null){
            curr.next = new ListNode();
            curr = curr.next;
            int value = l2.val;
            if(isUp){
                value++;
                isUp = false;
            }
            if(value >= 10){
                curr.val = value % 10;
                isUp = true;
            }
            else
                curr.val = value;
            l2 = l2.next;
        }
        
        if(isUp){
            curr.next = new ListNode(1);
        }
        
        return result;
        
    }

}