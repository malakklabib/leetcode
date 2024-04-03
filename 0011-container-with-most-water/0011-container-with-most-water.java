class Solution {
    public int maxArea(int[] height) {
        int n = height.length;            
        int area = 0;
        int s = 0, e = n-1;
        while(s<e){
            int f = height[s], l = height[e];
            int b = e-s;
            int h = Math.min(f, l);
            area = Math.max(area, b*h);
            if(h==f)
                s++;
            else
                e--;
        }
        return area;
    }
}