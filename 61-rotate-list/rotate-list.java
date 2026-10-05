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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        ListNode tail = head;
        int length = 1;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }
        tail.next = head;
        k = k % length;
        //Find the new tail node, which is at (length - k) steps from head
        int stepsToNewTail = length - k;
        for (int i = 0; i < stepsToNewTail; i++) {
            tail = tail.next;
        }
        //The node after the new tail becomes the new head
        ListNode newHead = tail.next;
        // Break the circular link
        tail.next = null;
        return newHead;
    }
}
