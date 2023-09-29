class StockSpanner {
    Stack<int[]> s;
    public StockSpanner() {
        s = new Stack<int[]>();
    }
    
    public int next(int price) {
        int[] p = new int[2];
        p[0] = price;
        p[1] = 1;
        if(s.isEmpty() || s.peek()[0]>price){
            s.push(p);
            return 1;
        }
        while(!s.isEmpty() && s.peek()[0]<=price){
            p[1]+=s.peek()[1];
            s.pop();
        }
        s.push(p);
        return p[1];
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */