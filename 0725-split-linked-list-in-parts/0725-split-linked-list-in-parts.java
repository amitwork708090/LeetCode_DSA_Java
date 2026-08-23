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
    public ListNode[] splitListToParts(ListNode head, int k) {
        int len = 0;
        ListNode crr = head;

        while(crr != null){
            len++;
            crr = crr.next;
        }

        int uniformNumber = len / k;
        int remainingNumber = len % k;

        crr = head;

        ListNode[] res = new ListNode[k];

        for(int i=0; i<k; i++) {
            int count = uniformNumber;

            if(remainingNumber > 0) {
                count = count + 1;
                remainingNumber = remainingNumber - 1;
            }

            ListNode temp = crr;
            ListNode prev = null;
            int counter = 0;

            while(counter < count) {
                prev = crr;
                crr = crr.next;
                counter++;
            }

            if(prev != null) {
                prev.next = null;
            }

            res[i] = temp;

        }

        return res;
    }
}