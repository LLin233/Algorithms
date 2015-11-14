import java.util.*;
/*
*	Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
*	Follow up:
*	Can you solve it without using extra space?
*
*/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null ) {
            return null;
        }
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        if(slow==null || fast==null || fast.next==null){
            return null;
        }
        while (head != fast) {
            head = head.next;
            fast = fast.next;
        }
        return head;
    }
}