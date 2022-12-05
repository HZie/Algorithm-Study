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
  public ListNode middleNode(ListNode head) {
      int count=0;
      ListNode p=head, runner=head;

      while(runner != null && runner.next != null){
          p = p.next;
          runner = runner.next;
          runner = runner.next;
      }

      return p;
  }
}