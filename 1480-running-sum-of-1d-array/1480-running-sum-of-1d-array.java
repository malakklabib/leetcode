class Solution {
    public int[] runningSum(int[] a) {
        int[]r=new int[a.length];
        int s=0;
        for(int i=0;i<a.length;i++){
            s+=a[i];
            r[i]=s;
        }
        return r;
    }
}