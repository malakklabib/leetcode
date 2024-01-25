class Solution {
    public boolean isPerfectSquare(int num) {
        double res = Math.sqrt((double)num);
        int low = 1, high = num/2;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(mid==res)
                return true;
            else if(mid < res)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return num==1? true:false;
    }
}