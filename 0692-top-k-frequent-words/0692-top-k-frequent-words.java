class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> freqMap = new HashMap<>();
        
        for(String word: words)
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        
        Queue<String> pq = new PriorityQueue<>((s1, s2) -> {
                int freq1 = freqMap.get(s1);
                int freq2 = freqMap.get(s2);
                
                if(freq1 != freq2)
                    return freq1-freq2;
                
                return s2.compareTo(s1);
        });
        
        for(String word: freqMap.keySet()){
            pq.offer(word);
            if(pq.size() > k)
                pq.poll();
        }
        
        List<String> res = new ArrayList<>();
        while(!pq.isEmpty())
            res.add(pq.poll());
        
        Collections.reverse(res);
        
        return res;
    }
}