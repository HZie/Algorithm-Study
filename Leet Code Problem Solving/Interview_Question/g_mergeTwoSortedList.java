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
  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    ListNode head, curr;
    ListNode l1Curr = list1, l2Curr = list2;

    if(list1 == null)
      return list2;
    if(list2 == null)
      return list1;

    if(l1Curr.val <= l2Curr.val){
      head = l1Curr;
      l1Curr = l1Curr.next;
    }
    else{
      head = l2Curr;
      l2Curr = l2Curr.next;
    }

    curr = head;

    while(l1Curr != null && l2Curr != null){

      if(l1Curr.val <= l2Curr.val){
        curr.next = l1Curr;
        l1Curr = l1Curr.next;
      }
      else{
        curr.next = l2Curr;
        l2Curr = l2Curr.next;
      }
      curr = curr.next;
    }

    while(l1Curr != null){
      curr.next = l1Curr;
      l1Curr = l1Curr.next;
      curr = curr.next;
    }

    while(l2Curr != null){
      curr.next = l2Curr;
      l2Curr = l2Curr.next;
      curr = curr.next;
    }

    return head;
  }
}