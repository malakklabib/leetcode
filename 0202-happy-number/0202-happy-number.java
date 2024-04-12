class Solution {
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        int mod = 0;

        while(true){
            int sum = 0;
            while(n!=0){
                mod = n%10;
                sum += mod*mod;
                n/=10;
            }
            if(sum==1)
                return true;
            if(seen.contains(sum))
                return false;
            n = sum;
            seen.add(sum);
        }
    }
}