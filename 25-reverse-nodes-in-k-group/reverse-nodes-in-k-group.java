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

    ListNode ohead = null;
    ListNode otail = null;
    ListNode thead = null;
    ListNode ttail = null;

    public static int getSize(ListNode head){
        ListNode ptr = head;
        int count=0;
        while(ptr!=null){
            count++;
            ptr=ptr.next;
        }
        return count;
    }

    public void addFirst(ListNode node){
        if(thead == null){
            thead = node;
            ttail = node;
        }
        else{
            node.next = thead;
            thead = node;
        }
    }

    

    public ListNode reverseKGroup(ListNode head, int k) {
        int size = getSize(head);
        ListNode curr = head;
        while(size>=k){
            int K = k;
            while(K-->0){
                ListNode currNext = curr.next;
                addFirst(curr);
                curr = currNext;
                size--;
            }

            if(ohead==null){
                ohead = thead;
                otail = ttail;
            }
            else{
                otail.next = thead;
                otail = ttail;
            }
            thead=null;
            ttail=null;
        }
        otail.next = curr;
        return ohead;
    }
}