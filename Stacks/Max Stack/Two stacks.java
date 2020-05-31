class MaxStack {

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> max_stack = new Stack<>();
    
    /** initialize your data structure here. */
    public MaxStack() {
        
    }
    
    public void push(int x) {
        int max = max_stack.isEmpty() ? x : max_stack.peek();
        max_stack.push(max > x ? max : x);
        stack.push(x);       
    }
    
    public int pop() {
                max_stack.pop();
            return stack.pop();
    }
    
    public int top() {
            return stack.peek();
    }
    
    public int peekMax() {
            return max_stack.peek();
    }
    
    public int popMax() {
        int max = peekMax();
        Stack<Integer> buffer = new Stack();
        while (top() != max) buffer.push(pop());
        pop();
        while (!buffer.isEmpty()) push(buffer.pop());
        return max;
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */