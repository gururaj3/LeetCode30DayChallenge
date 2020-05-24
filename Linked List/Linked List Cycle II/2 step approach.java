/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        
        if(head == null || head.next == null)
            return null;
        
        ListNode slow = head, fast = head;
        
        while(slow!=null && fast != null && fast.next != null &&fast.next.next != null){
            
            slow = slow.next;
            fast = fast.next.next;
            
            if(slow == fast)
                break;
            
        }
        
        slow = head;
        while(slow!=null && fast != null && fast.next != null &&fast.next.next != null){
            if(slow == fast)
                return slow;
            slow = slow.next;
            fast = fast.next;
            
        }
        return null;
        //throw new IllegalArgumentException("Error");
    }
}