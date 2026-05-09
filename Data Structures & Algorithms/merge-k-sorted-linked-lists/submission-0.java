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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummyNode = new ListNode(0);
        if(lists.length==0){
            return null;
        }
        if(lists.length==1){
            return lists[0];
        }
        dummyNode.next=lists[0];
       for(int i=1;i<lists.length;i++){
        mergeTwoLinkedLists(dummyNode.next,lists[i],dummyNode);
       } 
       return dummyNode.next;
    }

    private void mergeTwoLinkedLists(ListNode list1,ListNode list2,ListNode dummyNode){
        ListNode curr = dummyNode;
        while(list1!=null && list2!=null){
        if(list1.val<=list2.val){
            curr.next=list1;
            curr=list1;
            list1=list1.next;
            
        }
        else{
            curr.next=list2;
            curr=list2;
            list2=list2.next;
        }
        }
        if(list1!=null){
            curr.next=list1;
        }else{
            curr.next=list2;
        }
    }
}
