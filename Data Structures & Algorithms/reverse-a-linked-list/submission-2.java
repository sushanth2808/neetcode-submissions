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
    public ListNode reverseList(ListNode head) {

        return reverse(head,head,null);
    }

    private ListNode reverse(ListNode head, ListNode curr, ListNode prev){
        if(curr==null){
          
            return prev;
        }

        ListNode node = reverse(head,curr.next,curr);
        curr.next=prev;
        return node;
    }
}
