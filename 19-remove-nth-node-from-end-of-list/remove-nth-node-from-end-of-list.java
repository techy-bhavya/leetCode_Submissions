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
    
    //The main reason for the dummy node is to handle the case where the node to remove is the HEAD.
    //We need slow to be before the node we want to delete.
    // eg ll : 1->2->3
    //n = 3; now slow cannot be before 1, dummy solves that problem
    public ListNode removeNthFromEnd(ListNode head, int n) {
        

        ListNode dummy = new ListNode(0, head);
        ListNode slow = dummy;
        ListNode fast = head;
        for(int i=0;i<n;i++){
            if(fast==null) return null;
            fast = fast.next;

        }
        while(fast!=null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummy.next; // return dummy.next is important and crucial!!
        //coz if head node is deleted, then we can only access the remaining 
        //elements by dummy.next
    }
}