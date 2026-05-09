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
        ListNode curr = head;
        int len=0;
        while(curr!=null){
            len++;
            curr=curr.next;
        }
        int half = (len+1)/2;

        System.out.println("hey");
        curr = head;
        len=0;
        ListNode secondHead=null;
        while(curr!=null){
            len++;
            if(len==half){
                secondHead=curr.next;
                curr.next=null;
                break;
            }
            curr=curr.next;
        }
           System.out.println("hello");
        curr=secondHead;
        ListNode prev=null;
        while(curr!=null){
            ListNode temp = curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        secondHead=prev;

        System.out.println("hai");

        ListNode list1=head;
        ListNode list2=secondHead;
        ListNode dummy=new ListNode();
        curr=dummy;
        while(list1!=null && list2!=null){
            curr.next=list1;
            list1=list1.next;
            curr.next.next=list2;
            curr=list2;
            list2=list2.next;
        }

        if(list1!=null){
            curr.next=list1;
        }

        head=dummy.next;
    }
}