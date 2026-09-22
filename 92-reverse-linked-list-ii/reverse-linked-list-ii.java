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
        // Base case: if the list is empty or no reversal is needed
        if (head == null || left == right) {
            return head;
        }
        
        // Step 1: Set up a dummy node to seamlessly handle edge cases where left = 1
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        // Step 2: Advance the 'prev' pointer to the node right before the sublist starts
        ListNode prev = dummy;
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }
        
        // Step 3: Initialize pointers for the iterative link reversal
        ListNode curr = prev.next; // This node remains fixed as the tail of our sublist
        ListNode nextNode = null;  // Temporary pointer to track the next node to move
        
        // Step 4: Interlink and shift nodes to reverse the target section
        for (int i = 0; i < right - left; i++) {
            nextNode = curr.next;
            curr.next = nextNode.next;
            nextNode.next = prev.next;
            prev.next = nextNode;
        }
        
        // Step 5: Return the modified list starting from the true head
        return dummy.next;
    }
}