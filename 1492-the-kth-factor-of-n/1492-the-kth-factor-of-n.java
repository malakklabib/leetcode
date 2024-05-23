class Solution {
    public int kthFactor(int n, int k) {
        for(int i = n; i > 0; i--){
            if(n%i==0){
                k--;
                if(k==0)
                    return n/i;
            }
        }
        return -1;
    }
}