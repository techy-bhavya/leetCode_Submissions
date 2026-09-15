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
    public int getSize(ListNode head){
        int count = 0;
        ListNode ptr = head;
        while(ptr!=null){
            count++;
            ptr = ptr.next;
        }
        return count;
    }

    ListNode oHead = null;
    ListNode oTail = null;
    ListNode tHead = null;
    ListNode tTail = null;

    public void addFirst(ListNode node){
        if(tHead == null){
            tHead = node;
            tTail = node;
        }
        else{
            node.next = tHead;
            tHead = node;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
            int size = getSize(head);
            ListNode curr = head;
            while(size>=k){
                int K = k; //kyoki harbaar yeh loop khatm hone k baad, k ka value toh 0 ho jaega na...toh yeh value kho na jaye, isliye kahi aur save karalo, coz utna nodes ko isolate karke add karna h using addFirst

                while(K-->0){
                    ListNode currNext = curr.next;
                    curr.next = null;
                    addFirst(curr);
                    curr = currNext;
                    size--;
                    
                }
                // yaha pe vo temporary ll ban gya, ab, depending on whether pehle se list h ya nhi, vo original mein attach hoga, ya original ban jaega
                if(oHead == null){
                    oHead = tHead;
                    oTail = tTail;
                }
                else{
                    oTail.next = tHead;
                    oTail = tTail;
                }
                
                tHead = null;
                tTail = null;
            }
            oTail.next = curr;
            return oHead;
    }
}

