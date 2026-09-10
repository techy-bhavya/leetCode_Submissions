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
    public ListNode oddEvenList(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode evenDummy = new ListNode(-1);
        ListNode oddDummy = new ListNode(-1);
        ListNode oddTail = oddDummy;
        ListNode evenTail = evenDummy;
        ListNode ptr = head;
        int idx=1;
        while(ptr!=null){
            ListNode ptrKaNext = ptr.next;
            ptr.next=null;
            if(idx%2!=0){
                oddTail.next = ptr;
                ptr = ptrKaNext;
                oddTail = oddTail.next;
            }
            else{
                evenTail.next = ptr;
                ptr = ptrKaNext;
                evenTail = evenTail.next;
            }
            idx++;
        }
        ListNode oddDummyHead = oddDummy.next;
        ListNode evenDummyHead = evenDummy.next;
        oddTail.next = evenDummyHead;
        return oddDummyHead;

    }
}