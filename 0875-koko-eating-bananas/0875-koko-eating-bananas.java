class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1, r = piles[0];
        for(int p : piles)
            r = Math.max(p, r);
        int m = 0;
        while(l <= r) {
            m = l + (r-l)/2;
            if(check(piles, h, m))
                r = m - 1;
            else
                l = m + 1;
        }
        return l;
    }
    
    public boolean check(int[] p, int h, double k) {
        int hours = 0;
        for(double pile: p) {
            hours+= Math.ceil(pile/k);
            if(hours > h) return false;
        }
        return true;
    }
}