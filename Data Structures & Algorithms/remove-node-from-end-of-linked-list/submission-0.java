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
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode curr = head;
        int size =0;
        while(curr!=null){
            curr=curr.next;
            size++;
        }

        int count = size-n;

        curr = head;
        ListNode prev=null;
        int i=0;
        if(count==0){
            return head.next;
        }
        while(i<count && curr!=null){
            prev=curr;
            curr=curr.next;
            i++;
        }
        if(curr!=null){
            prev.next=curr.next;
        }
        
        return head;
    }
}
