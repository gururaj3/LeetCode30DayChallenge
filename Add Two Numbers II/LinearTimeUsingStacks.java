class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null)
            return null;
        if(l1 == null || l2 == null)
            return l1 == null ? l2 : l1;
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        
        ListNode curr = l1;
        while(curr != null){
            s1.add(curr.val);
            curr = curr.next;
        }
        
        curr = l2;
        while(curr != null){
            s2.add(curr.val);
            curr = curr.next;
        }
        
        ListNode head = null;
        int carry = 0;
        // build result list backwards
        while(!s1.isEmpty() || !s2.isEmpty()){
            int x = !s1.isEmpty() ? s1.pop() : 0;
            int y = !s2.isEmpty() ? s2.pop() : 0;
            int sum = x + y + carry;
            curr = new ListNode(sum % 10);
            curr.next = head;
            head = curr;
            carry = sum / 10;
        }
        
        if(carry == 1){
            curr = new ListNode(1);
            curr.next = head;
            head = curr;
        }
        
        return head;
    }
}
