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
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode prev = null;
        ListNode crr = slow;

        while(crr != null) {
            ListNode next = crr.next;
            crr.next = prev;
            prev = crr;
            crr = next;
        }

        ListNode l1 = head;
        ListNode l2 = prev;

        while(l2.next != null) {
            ListNode l1n = l1.next;
            l1.next = l2;
            ListNode l2n = l2.next;
            l2.next = l1n;

            l1 = l1n;
            l2 = l2n;
        }
    }
}