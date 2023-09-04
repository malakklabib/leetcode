class Solution {
    public int removeDuplicates(int[] nums) {
        ArrayList<Integer> tmp=new ArrayList<Integer>();
        int k=0;
        for(int i=0;i<nums.length;i++){
            if(tmp.indexOf(nums[i])==-1){
                tmp.add(nums[i]);
                    k++;
            }
        }
        Object[] t = tmp.toArray();
        for(int i=0;i<t.length;i++){
            nums[i]=(int)t[i];
        }
        return k;
    }
}