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

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode head = new ListNode();
    ListNode curr = head, prev = head;
    ListNode l1Curr = l1, l2Curr = l2;
    int carry = 0;

    while(l1Curr != null && l2Curr != null){
      int added = l1Curr.val + l2Curr.val + carry;
      curr.val = added % 10;
      carry = added/10;
      l1Curr = l1Curr.next;
      l2Curr = l2Curr.next;
      curr.next = new ListNode();
      prev = curr;
      curr = curr.next;
    }

    while(l1Curr != null){
      int added = l1Curr.val + carry;
      curr.val = added % 10;
      carry = added / 10;
      l1Curr = l1Curr.next;
      curr.next = new ListNode();
      prev = curr;
      curr = curr.next;
    }
    while(l2Curr != null){
      int added = l2Curr.val + carry;
      curr.val = added % 10;
      carry = added / 10;
      l2Curr = l2Curr.next;
      prev = curr;
      curr.next = new ListNode();
      curr = curr.next;
    }

    if(carry != 0)
      curr.val = carry;
    else 
      prev.next = null;
    return head;
  }
}