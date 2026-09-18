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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        ListNode i = head;
        while(i!=null){
            if(i.next==null || i.val !=i.next.val){
                temp.next = i;
                temp = i;
                i = i.next;
            }
            else{
                ListNode j = i.next;
                while(j!=null && j.val==i.val){
                    j=j.next;
                }
                i=j;
            }
        }
        temp.next = i;
        return dummy.next;
    }
}