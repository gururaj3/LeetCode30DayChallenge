class MyQueue {
    List<Integer> list;
    /** Initialize your data structure here. */
    public MyQueue() {
        list = new ArrayList<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        list.add(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        int pop = list.get(0);
        list.remove(0);
        return pop;
    }
    
    /** Get the front element. */
    public int peek() {
        return list.get(0);
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return list.isEmpty();
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
