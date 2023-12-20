class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> dp = new ArrayList<List<Integer>>();
        for(int i = 0; i < numRows; i++)
            dp.add(new ArrayList<>());
        dp.get(0).add(1);
        if(numRows==1)
            return dp;
        dp.get(1).addAll(Arrays.asList(1,1));
        for(int i = 2; i < numRows; i++){
            for(int j = 0; j <= i; j++){
                if(j==0 || j==i)
                    dp.get(i).add(1);
                else{
                    int n1 = dp.get(i-1).get(j-1);
                    int n2 = dp.get(i-1).get(j);
                    dp.get(i).add(n1+n2); 
                }
            }
        }
        return dp;
    }
}