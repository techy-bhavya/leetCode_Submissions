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

    // helper function to find middle of linkedList (first middle in case of even)
    public ListNode findMiddleNode(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
    
    // helper function to reverse linkedlist and return new head
    public ListNode reverseLinkedList(ListNode head){
        ListNode curr = head;
        ListNode prev = null;

        while(curr != null){
            ListNode currKaNext = curr.next;

            curr.next = prev;

            prev = curr;
            curr = currKaNext;
        }

        return prev; // new head
    }

    public boolean isPalindrome(ListNode head) {
        ListNode mid = findMiddleNode(head);
        ListNode secondHead = mid.next;
        mid.next = null;

        secondHead = reverseLinkedList(secondHead);
        ListNode ptr1 = head, ptr2 = secondHead;
        boolean isPal = true;
        while(ptr1!=null && ptr2!=null){
            if(ptr1.val != ptr2.val){
                isPal = false;
            }
            ptr1= ptr1.next;
            ptr2 = ptr2.next;
        }
        return isPal;
    }
}