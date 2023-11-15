class Solution {
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> counts = new HashMap<>();
        for(int i = 0; i < arr.length; i++)
            counts.put(arr[i], counts.getOrDefault(arr[i], 0) + 1);
        int res = 0;
        int length = 0;
        List<Integer> l = new ArrayList<Integer>(counts.values());
        Collections.sort(l, Collections.reverseOrder());
        for(int i: l){
            length+=i;
            res++;
            if(length >= arr.length/2)
                break;
        }
        return res;
    }
}