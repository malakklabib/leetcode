class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int[] p = new int[nums.length];
        int sum = 0;
        for(int i = 0 ; i < nums.length; i++){
            sum+= nums[i];
            p[i] = sum;
        }
        int[] res = new int[queries.length];
        for(int i = 0; i < queries.length; i++) {
            int l = 0, r = nums.length-1, m = 0;
            while(l<=r) {
                m = l + (r-l)/2;
                if(p[m] == queries[i])
                    break;
                if(p[m] < queries[i])
                    l = m+1;
                else
                    r = m-1;
            }
            res[i] = Math.min(m,r) + 1;
        }
        return res;
    }
}