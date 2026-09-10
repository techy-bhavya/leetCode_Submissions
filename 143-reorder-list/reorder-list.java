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
    public ListNode getMiddleNode(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next!=null && fast.next.next !=null){
            slow=slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode reverseLL(ListNode head){
        ListNode curr = head;
        ListNode prev = null;

        while(curr!=null){
            ListNode currNext = curr.next;
            curr.next = prev;
            prev=curr;
            curr=currNext;
        }
        return prev;
    }

    public void reorderList(ListNode head) {
        //if(head==null || head.next == null) return;
        ListNode mid = getMiddleNode(head);
        ListNode secondHalfHead = mid.next;
        mid.next=null;
        secondHalfHead = reverseLL(secondHalfHead);
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        ListNode p1 = head, p2 = secondHalfHead;
        while(p1!=null && p2!=null){
            ListNode p1kaNext = p1.next;
            p1.next=null;
            curr.next = p1;
            p1=p1kaNext;
            curr=curr.next;
            ListNode p2kaNext = p2.next;
            p2.next=null;
            curr.next=p2;
            p2=p2kaNext;
            curr=curr.next;
        }
        if(p1!=null){
            curr.next = p1;
        }
    }
}