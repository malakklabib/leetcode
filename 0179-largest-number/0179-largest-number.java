class Solution {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        Queue<String> pq = new PriorityQueue<>(new Comparator<String>(){
            @Override
            public int compare(String a, String b){
                String ab = a + b;
                String ba = b + a;
                return ba.compareTo(ab);
            }
        });
        
        for(int num: nums)
            pq.add(String.valueOf(num));
        
        while(pq.size() > 1 && pq.peek().equals("0"))
            pq.poll();
        
        StringBuilder res = new StringBuilder();
        while(!pq.isEmpty())
            res.append(pq.poll());
                
        return res.toString();
    }
}