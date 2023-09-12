class Solution {
    public int findLucky(int[] arr) {
        Arrays.sort(arr);
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : arr)
            map.put(i, map.getOrDefault(i, 0) + 1);
        for(int i = arr.length-1; i >= 0; i--)
            if(map.get(arr[i])==arr[i])
                return arr[i];
        return -1;
            
    }
}