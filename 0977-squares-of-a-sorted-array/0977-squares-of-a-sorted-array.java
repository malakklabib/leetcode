class Solution {
    public int[] sortedSquares(int[] n) {
        int a = 0, b = n.length-1;
        int[] r = new int[n.length];
        int c = n.length-1;
        while(a <= b){
            if(Math.abs(n[a]) <= Math.abs(n[b])){
                r[c] = (int)Math.pow(n[b],2);
                b--;
            }
            else{
                r[c] = (int)Math.pow(n[a],2);
                a++;
            }
            c--;
        }
        return r;
    }
}