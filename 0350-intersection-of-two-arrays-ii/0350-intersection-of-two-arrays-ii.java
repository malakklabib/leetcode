class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int l = 0;
        if(nums1.length>nums2.length)
            l = nums2.length;
        else
            l = nums1.length;
        
        ArrayList<Integer> r = new ArrayList<Integer>();
        int o = 0;
        int t = 0;
        int[] n1 = sort(nums1);
        int[] n2 = sort(nums2);
        int size = 0; 
        
        for(int i=0; i < nums1.length + nums2.length; i++){
            if(o==nums1.length || t==nums2.length)
                break;
            if(n1[o]>n2[t])
                t++;
            else if(n1[o]<n2[t])
                o++;
            else{
                r.add(n1[o]);
                size++;
                o++;
                t++;
            }
        }
        int[] result = new int[size];
        for(int i=0;i<size;i++){
            result[i] = r.get(i);
        }
        
        return result;
    }
    
    public static int[] sort(int[] x){
        int tmp = 0;
        for(int i = 0; i<x.length; i++){
            for(int j = i+1; j<x.length;j++){
                if(x[i]>x[j]){
                    tmp = x[i];
                    x[i] = x[j];
                    x[j] = tmp;
                }
            }
        }
        return x;
    }
}