class MedianFinder {
    Queue<Integer> minHeap, maxHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        maxHeap.add(num);
        
        minHeap.add(maxHeap.remove());
        
        if(minHeap.size() > maxHeap.size())
            maxHeap.add(minHeap.remove());
    }
    
    public double findMedian() {
        if(minHeap.size() == maxHeap.size())
            return (minHeap.peek() + maxHeap.peek())/2.0;
        
        return maxHeap.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */