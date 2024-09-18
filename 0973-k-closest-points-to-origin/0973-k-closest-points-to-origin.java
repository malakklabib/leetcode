class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Comparator<int[]> myComp = new Comparator<>(){
            @Override
            public int compare(int[] p1, int[] p2){
                int x1 = p1[0]*p1[0];
                int y1 = p1[1]*p1[1];
                double d1 = Math.sqrt(x1+y1);
                
                int x2 = p2[0]*p2[0];
                int y2 = p2[1]*p2[1];
                double d2 = Math.sqrt(x2+y2);
                
                return Double.compare(d1, d2);
            }
        };
        
        Arrays.sort(points, myComp);
        int[][] res = new int[k][2];
        for(int i = 0; i < res.length; i++)
            res[i] = points[i];
        
        return res;
    }
}