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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode curr1 = l1;
        ListNode curr2 = l2;
        int carry = 0;
        ListNode prev  = null;
        while(curr1!=null && curr2!=null){
            int sum = curr1.val + curr2.val+carry;
            if(sum > 9){
                carry = sum/10;
            }else{carry=0;}
            curr1.val = sum%10;
            prev=curr1;
            curr1=curr1.next;
            curr2=curr2.next;
        } 
        while(curr1!=null){
            int sum = curr1.val+carry;
            if(sum > 9){
                carry = sum/10;
            }else{carry=0;}
            curr1.val = sum%10;
            prev=curr1;
            curr1=curr1.next;
        }
        while(curr2!=null){
            int sum = curr2.val+carry;
            if(sum > 9){
                carry = sum/10;
            }else{carry=0;}
            curr2.val = sum%10;
            prev.next=curr2;
            prev=curr2;
            curr2=curr2.next;
        }

        if(carry!=0){
            ListNode node = new ListNode(carry);
            prev.next=node;
        }
        return l1;
    }
}
