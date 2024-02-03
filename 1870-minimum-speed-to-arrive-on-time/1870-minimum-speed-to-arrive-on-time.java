class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int low = 1, high = (int)Math.pow(10, 7);
        while(low <= high) {
            int mid = low + (high-low)/2;
            if(check(dist,mid,hour))
                high = mid-1;
            else
                low = mid+1;
        }
        return check(dist, low, hour)? low : -1;
    }
    
    public boolean check(int[] dist, int s, double hour) {
    double sum = 0;
    for(int i = 0; i < dist.length; i++) {
        int d = dist[i];
        sum += (double)d / s;
        if(i < dist.length - 1) {
            sum = Math.ceil(sum);
        }
    }
    return sum <= hour;
}

}
