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
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;
        ListNode curr = head; 
        while(curr!=null && curr.next!=null){
            //save ptrs
            ListNode nxtPair = curr.next.next;
            ListNode second = curr.next;
            //reverse pair
            second.next = curr;
            curr.next = nxtPair;
            prev.next = second;
            //update pairs
            prev = curr;
            curr = nxtPair;
        }
        return dummy.next;
    }
}