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
    public ListNode rotateRight(ListNode head, int k) {
        
        if(head == null || head.next == null)
            return head;
        
        ListNode old_tail = head;
        int cnt = 1;
        while(old_tail.next!=null){
            old_tail = old_tail.next;
            cnt++;
        }
            
        old_tail.next = head;
        
        ListNode new_tail = head;
        for(int i=0; i< cnt-k%cnt-1; i++)
            new_tail = new_tail.next;
        
        ListNode new_head = new_tail.next;
        
        new_tail.next = null;
        
        return new_head;
    }
}