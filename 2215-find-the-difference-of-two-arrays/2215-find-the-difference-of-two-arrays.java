class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> seen = new HashSet();
        
        for(int num: nums1)
            seen.add(num);
        
        for(int num: nums2) {
            if(seen.contains(num))
                seen.remove(num);
        }
        
        List<Integer> ans0 = new ArrayList(seen);
        seen.clear();
        
        for(int num: nums2)
            seen.add(num);
        
        for(int num: nums1) {
            if(seen.contains(num))
                seen.remove(num);
        }        
        List<Integer> ans1 = new ArrayList(seen);
        
        return new ArrayList(Arrays.asList(ans0,ans1));
    }
}