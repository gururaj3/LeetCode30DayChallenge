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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        
        
        ListNode newList = new ListNode(0);
        ListNode n = newList;
        
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                newList.next = l1;
                newList = newList.next;
                l1 = l1.next;
            }
            
            else{
                newList.next = l2;
                newList = newList.next;
                l2 = l2.next;
            }
            
        }
        newList.next = l1 == null ? l2 : l1;
        return n.next;
    }
}