// https://leetcode.com/problems/rotate-list/submissions/
// Medium
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        // greedy
        int count = 1;
        ListNode tail = head;
        if(head == null)    // 노드가 존재하지 않는 경우
            return head;
            
        
        while(tail.next != null){   // 몇 개의 노드가 있는지 count하고 마지막 노드를 찾음
            count++;
            tail = tail.next;
        }
        
        int rotation = k % count;   // 원점으로 돌아가지 않게 rotate를 함으로써 시간복잡도를 줄인다.
        
         // 순환 리스트
        tail.next = head;
        
        ListNode node = tail;
        if(rotation != 0){
            for(int i = 0; i < count - rotation; i++)    // 마지막 노드가 될 노드를 찾음
                node = node.next;
        }
        
        // tail을 만들어줌으로써 singly linked list
        head = node.next;
        node.next = null;
        
        return head;
        
    }
}

// time: O(n) n = list's size, space = O(1)