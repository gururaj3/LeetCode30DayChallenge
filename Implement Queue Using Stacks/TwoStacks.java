class MyQueue {

    /** Initialize your data structure here. */
    Stack<Integer> s;
    Stack<Integer> temp;
    
    public MyQueue() {
        this.s = new Stack<>();
        this.temp = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {

        for(int i=s.size(); i>=1; i--){
            int p = s.pop();
            temp.push(p);
        }
        s.push(x);
        for(int i=temp.size(); i>=1; i--){
            int p = temp.pop();
            s.push(p);
        }
    }
 
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {  
        return s.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        return s.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s.isEmpty();
    }
}
/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
