import java.util.*;
/**
*   Given a linked list, swap every two adjacent nodes and return its head.
*	For example,
*	Given 1->2->3->4, you should return the list as 2->1->4->3.
*	Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
*
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = head;
        ListNode prev = dummy;
        //{ p  q  r  s } to { q  p  r  s }.
        while (p != null && p.next != null) {
            ListNode q = p.next, r = p.next.next;
            prev.next = q;
            q.next = p;
            p.next = r;
            prev = p;
            p = r;
        }
        return dummy.next;
    }
}
