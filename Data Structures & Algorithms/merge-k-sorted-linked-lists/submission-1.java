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
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a,b)->a.val-b.val);
        for(ListNode list: lists){
            minHeap.offer(list);
        }

        ListNode curr= dummyNode;
        while(!minHeap.isEmpty()){
            ListNode node = minHeap.poll();
            curr.next=node;
            curr=node;

            node = node.next;
            if(node!=null){
                minHeap.offer(node);
            }   
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
