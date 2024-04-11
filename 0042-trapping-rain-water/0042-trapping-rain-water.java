class Solution {
    public int trap(int[] height) {
        if(height.length < 3)
            return 0;
        
        int l = 0, r = 0;
        int n = height.length;
        int area = 0;
        
        for(int i = 0; i < n; i++){
            
            int maxH = Integer.MIN_VALUE;
            for(int j = i-1; j >= 0; j--){
                if(maxH < height[j]){
                    maxH = height[j];
                    l = j;
                }
            }
            
            if(r <= i){
                maxH = Integer.MIN_VALUE;
                for(int j = i+1; j < n; j++){
                    if(maxH < height[j]){
                        maxH = height[j];
                        r = j;
                    }
                }
            }
            
            int currArea = Math.min(height[l],height[r]) - height[i];
            if(currArea > 0)
                area += currArea;
        }
        
        return area;
    }
}