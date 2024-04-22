class Solution {
    public int halveArray(int[] nums) {
        PriorityQueue<Double> pq = new PriorityQueue(Collections.reverseOrder());
        double sum = 0;
        for(int num: nums){
            sum+=num;
            pq.add((double)num);
        }
        
        double halfSum = sum/2;
        int ops = 0;
        while(sum > halfSum){
            double max = pq.poll()/2;
            pq.add(max);
            sum-=max;
            ops++;
        }
        return ops;
    }
}