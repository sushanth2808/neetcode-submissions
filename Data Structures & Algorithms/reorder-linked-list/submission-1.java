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
    public void reorderList(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast=fast.next.next;
        }
        ListNode curr = slow.next;
        slow.next=null;
        ListNode prev=null;
        while(curr!=null){
            ListNode temp = curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }

        ListNode head1=prev;
        ListNode currNode = head;

        while(head1!=null){
            ListNode temp1 = currNode.next;
            ListNode temp2=head1.next;
            currNode.next=head1;
            head1.next=temp1;
            currNode = temp1;
            head1=temp2;
        }

    }
}
