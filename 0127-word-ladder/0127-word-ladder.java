class Pair{
    String word;
    int steps;
    public Pair(String word, int steps) 
    {
        this.word = word;
        this.steps = steps;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord))
            return 0;
        
        if(!wordList.contains(beginWord))
            wordList.add(beginWord);
        
        List<String> seen = new ArrayList<>();
        Queue<Pair> queue = new LinkedList<>();
        Map<String, List<String>> perms = new HashMap<>();
        
        queue.add(new Pair(beginWord, 1));
        seen.add(beginWord);
        
        for(int i = 0; i < wordList.size(); i++){
            String word = wordList.get(i);
            for(int j = 0; j < word.length(); j++) {
                String newWord = word.substring(0, j) + '*' + word.substring(j+1);
                if(!perms.containsKey(newWord))
                    perms.put(newWord, new ArrayList<>());
                perms.get(newWord).add(word);
            }
        }
        while(!queue.isEmpty()){
            Pair curr = queue.remove();
            String word = curr.word;
            int steps = curr.steps;
            if(word.equals(endWord))
                return steps;
            for(int i = 0; i < word.length(); i++){
                String newWord = word.substring(0,i)+'*'+word.substring(i+1);
                for(String adj: perms.get(newWord))
                    if(!seen.contains(adj)) {
                        seen.add(adj);
                        queue.add(new Pair(adj, steps+1));
                    }
            }
        }
        return 0;
    }
}