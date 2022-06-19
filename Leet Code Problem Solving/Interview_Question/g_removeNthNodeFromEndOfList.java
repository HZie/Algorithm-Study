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
/* 
1 2 3 4 5 6 7 8 9 10
n = 2
curr: 1, runner: 1

n = 1
curr: 1, runner: 2

n = 0
curr: 1, runner: 3
*/

class Solution {
  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode runner = head, curr = head, prev = head;;

    n--;
    if(curr.next == null && n == 0)
      return null;

    while(n > 0){
      runner = runner.next;
      n--;
    }

    System.out.println(runner.val);
    while(runner.next != null){
      runner = runner.next;
      prev = curr;
      curr = curr.next;
    }

    if(prev == curr)
      head = curr.next;
    else
      prev.next = curr.next;

    return head;
  }
}