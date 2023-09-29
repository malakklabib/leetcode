class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> s = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i: nums2){
            if(!s.isEmpty() && s.peek() < i)
                while(!s.isEmpty() && s.peek() < i)
                    map.put(s.pop(), i);
            s.push(i);
        }
        while(!s.isEmpty())
            map.put(s.pop(), -1);
        int [] ans = new int[nums1.length];
        for(int i = 0; i < nums1.length; i++){
            if(map.containsKey(nums1[i]))
                ans[i] = map.get(nums1[i]);
        }
        return ans;
    }
}