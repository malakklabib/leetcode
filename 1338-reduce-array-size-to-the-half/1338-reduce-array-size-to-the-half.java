class Solution {
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> counts = new HashMap<>();
        for(int i = 0; i < arr.length; i++)
            counts.put(arr[i], counts.getOrDefault(arr[i], 0) + 1);
        Integer[] boxedArr = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) 
            boxedArr[i] = arr[i];
        Arrays.sort(boxedArr, (a, b) -> counts.get(b)-counts.get(a));
        int res = 0;
        int length = 0;
        for(int i: boxedArr){
            if(!counts.isEmpty() && counts.containsKey(i)){
                length+=counts.get(i);
                counts.remove(i);
                res++;
            }
            if(length >= arr.length/2)
                break;
        }   
        return res;
    }
}