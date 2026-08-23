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
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode crr1 = head;
        ListNode prev = dummy;

        while(crr1 != null && crr1.next != null) {
            ListNode crr2 = crr1.next;
            prev.next = crr2;
            crr1.next = crr2.next;
            crr2.next = crr1;

            prev = crr1;
            crr1 = crr1.next;
        }

        return dummy.next;
    }
}

// TC = O(n) linear
// SC = O(1) constant