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
    public boolean hasCycle(ListNode head) {
        ListNode slowPointer = head;
        if(head==null){return false;}
        ListNode fastPointer = head.next;

        while(slowPointer!=fastPointer){
            slowPointer = slowPointer.next;
            if(fastPointer==null || fastPointer.next==null){
               return false;
            }
            else{
                 fastPointer= fastPointer.next.next;
            }
        }
        return true;
    }
}
