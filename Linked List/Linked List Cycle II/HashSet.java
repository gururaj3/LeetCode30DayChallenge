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
        
        Set<ListNode> h = new HashSet<>();
        
        while(head!=null){
            if(h.contains(head))
                return head;
            else
                h.add(head);
            head = head.next;
        }
        return null;
    }
}