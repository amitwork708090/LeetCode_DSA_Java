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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        int counter = 0;
        ListNode p = dummy;
        ListNode c = head;

        while(counter < left - 1) {
            p = c;
            c = c.next;
            counter++;
        }

        ListNode prev = null;
        ListNode crr = c;

        counter = 0;

        while(counter < (right - left + 1)) {
            counter++;

            ListNode next = crr.next;
            crr.next = prev;
            prev = crr;
            crr = next;
        }

        p.next = prev;
        c.next = crr;

        return dummy.next;
    }
}