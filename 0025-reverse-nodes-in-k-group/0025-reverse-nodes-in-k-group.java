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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        int len = 0;
        while (temp != null) {
            temp = temp.next;
            len++;
        }

        int n = len / k;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p1 = dummy;
        ListNode crr = head;

        for (int i = 0; i < n; i++) {
            int x = k;
            ListNode prev = null;
            ListNode p2 = crr;
            while (x > 0 && crr != null) {
                x--;
                ListNode next = crr.next;
                crr.next = prev;
                prev = crr;
                crr = next;
            }
            p1.next = prev;
            p2.next = crr;
            p1 = p2;
        }
        return dummy.next;
    }
}