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
        
        Queue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);
        
        for(ListNode head : lists){
            if(head != null){
                minHeap.add(head);
            }
        }
        
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        
        while(!minHeap.isEmpty()){
            ListNode curr = minHeap.poll();
            
            head.next = curr;
            head = head.next;
            
            if(curr.next != null){
                minHeap.add(curr.next);
            }
            
        }
        return dummy.next;
        
    }
}
