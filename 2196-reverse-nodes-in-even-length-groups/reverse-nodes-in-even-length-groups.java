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
    public ListNode reverseEvenLengthGroups(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode prevGroupEnd = dummy;
        int expectedGroupLen = 1;
        while (prevGroupEnd.next != null) {
            ListNode groupStart = prevGroupEnd.next;
            ListNode curr = groupStart;
            int actualLen = 0;
            // Count actual nodes in this group and find its end
            while (curr != null && actualLen < expectedGroupLen) {
                curr = curr.next;
                actualLen++;
            }
            // If actual length is even, reverse the nodes in this group
            if (actualLen % 2 == 0) {
                prevGroupEnd.next = reverse(groupStart, actualLen);
                // After reversal, groupStart becomes the tail of this group
                prevGroupEnd = groupStart;
            } else {
                // If odd, just move prevGroupEnd to the end of this group
                prevGroupEnd = groupStart;
                for (int i = 1; i < actualLen; i++) {
                    prevGroupEnd = prevGroupEnd.next;
                }
            }
            expectedGroupLen++;
        }
        return dummy.next;
    }

    // Helper method to reverse k nodes starting from head
    private ListNode reverse(ListNode head, int k) {
        ListNode prev = null;
        ListNode curr = head;
        while (k > 0) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
            k--;
        }
        // Connect the newly reversed tail (which is 'head') to the remaining list ('curr')
        head.next = curr;
        return prev; // new head of this reversed group
    }
}
