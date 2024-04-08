class Solution {
    List<List<Integer>> combinations;
    int[] candidates;
    int n;
    int target;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        combinations = new ArrayList<List<Integer>>();
        this.candidates = candidates;
        this.target = target;
        n = candidates.length;
        combs(0, target, new ArrayList<>());
        return combinations;
    }
    public void combs(int i, int target, List<Integer> currComb) {
        
        if(target==0){
            combinations.add(new ArrayList<>(currComb));
            return;
        }
        
        if(i==n || target<0)
            return;
        
        currComb.add(candidates[i]);
        combs(i, target-candidates[i], currComb);
        currComb.remove(currComb.size()-1);
        combs(i+1, target, currComb);
    }
}