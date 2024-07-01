class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Map<Integer, Integer> map = new HashMap();

        int n = position.length;
        
        for(int i = 0; i < n; i++){
            map.put(position[i], speed[i]);
        }
        
        Arrays.sort(position);
        
        int ans = 1;
        double slowest = (double)(target-position[n-1])/map.get(position[n-1]);
        
        for(int i = n-2; i >= 0; i--){
            double currTime = (double)(target-position[i])/map.get(position[i]);
            if(currTime > slowest){
                ans++;
                slowest = currTime;
            }
        }
        
        return ans;
    }
}