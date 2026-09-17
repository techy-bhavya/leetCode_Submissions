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
    public void swapKardo(ListNode a, ListNode b){
        int temp = a.val;
        a.val = b.val;
        b.val = temp;
    }

    public ListNode swapNodes(ListNode head, int k) {
        ListNode slow = head;
        ListNode fast = head;
        for(int i=1;i<k;i++){
            if(fast==null) return null;
            fast = fast.next;
        }
        ListNode i = fast;
        while(fast.next!=null){
            slow = slow.next;
            fast = fast.next;
        }
        ListNode j = slow;
        swapKardo(i,j);
        return head;
    }
}