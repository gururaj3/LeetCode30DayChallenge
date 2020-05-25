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
    public int getDecimalValue(ListNode head) {
        
        if(head == null)
            return -1;
        
        ListNode curr = head;
        int count =-1;
        int decimalValue = 0;
        while(curr!=null){
            count++;
            curr = curr.next;
        }
        System.out.println(count);
        
        while(head!=null){
            int k = (int)Math.pow(2, count);
            decimalValue = decimalValue + head.val*k;
            count--;
            head = head.next;
        }
        return decimalValue;
    }
}