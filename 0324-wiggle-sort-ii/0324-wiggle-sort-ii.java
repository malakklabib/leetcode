class Solution {
    public void wiggleSort(int[] nums) {
        Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        int n = nums.length;
        
        for(int num: nums)
            maxHeap.offer(num);
        
        for(int i = 1; i < n; i+=2)
            nums[i] = maxHeap.poll();
            
        for(int i = 0; i < n; i+=2)
            nums[i] = maxHeap.poll();
        
    }
}