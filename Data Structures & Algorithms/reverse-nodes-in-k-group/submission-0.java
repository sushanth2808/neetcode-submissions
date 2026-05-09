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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummyNode = new ListNode(0);
        ListNode beforekhead = dummyNode;
        ListNode curr = head;
        
        while(curr!=null){

            ListNode tempCheck = curr;
            int count = 0;
            while(tempCheck != null && count < k){
                tempCheck = tempCheck.next;
                count++;
            }

            if(count < k){
                beforekhead.next = curr;
                break;
            }
            
        
            ListNode khead = curr;
            ListNode prev=null;
            while(curr!=null && count>0){
                ListNode temp = curr.next;
                curr.next = prev;
                prev=curr;
                curr = temp;
                count--;
            }
            beforekhead.next=prev;
            beforekhead=khead;
        }
        return dummyNode.next;
    }
    
}
