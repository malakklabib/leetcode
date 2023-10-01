class MyQueue {
    Stack<Integer> s;
    Stack<Integer> t;
    public MyQueue() {
        s = new Stack<>();
        t = new Stack<>();
    }
    
    public void push(int x) {
        s.push(x);
    }
    
    public int pop() {
        while(!s.isEmpty())
            t.push(s.pop());
        int x = t.pop();
        while(!t.isEmpty())
            s.push(t.pop());
        return x;
    }
    
    public int peek() {
        while(!s.isEmpty())
            t.push(s.pop());
        int x = t.peek();
        while(!t.isEmpty())
            s.push(t.pop());
        return x;
    }
    
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