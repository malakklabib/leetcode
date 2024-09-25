
public class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return result;

        Map<String, List<String>> parents = new HashMap<>();
        Map<String, Integer> distance = new HashMap<>();
        bfs(beginWord, endWord, wordSet, parents, distance);

        List<String> path = new ArrayList<>();
        dfs(result, path, endWord, beginWord, parents, distance);

        return result;
    }

    private void bfs(String beginWord, String endWord, Set<String> wordSet, 
                     Map<String, List<String>> parents, Map<String, Integer> distance) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        distance.put(beginWord, 0);
        int shortestPath = Integer.MAX_VALUE;
        
        while (!queue.isEmpty()) {
            String word = queue.poll();
            int currDistance = distance.get(word);
            if (currDistance >= shortestPath) break;
            
            for (String neighbor : getNeighbors(word, wordSet)) {
                if (!distance.containsKey(neighbor)) {
                    distance.put(neighbor, currDistance + 1);
                    queue.offer(neighbor);
                }
                if (distance.get(neighbor) == currDistance + 1) {
                    parents.computeIfAbsent(neighbor, k -> new ArrayList<>()).add(word);
                    if (neighbor.equals(endWord)) {
                        shortestPath = currDistance + 1;
                    }
                }
            }
        }
    }

    private void dfs(List<List<String>> result, List<String> path, String word, String beginWord,
                     Map<String, List<String>> parents, Map<String, Integer> distance) {
        if (word.equals(beginWord)) {
            path.add(0, word);
            result.add(new ArrayList<>(path));
            path.remove(0);
            return;
        }

        for (String parent : parents.getOrDefault(word, new ArrayList<>())) {
            if (distance.get(word) == distance.get(parent) + 1) {
                path.add(0, word);
                dfs(result, path, parent, beginWord, parents, distance);
                path.remove(0);
            }
        }
    }

    private List<String> getNeighbors(String word, Set<String> wordSet) {
        List<String> neighbors = new ArrayList<>();
        char[] chars = word.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char oldChar = chars[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == oldChar) continue;
                chars[i] = c;
                String newWord = new String(chars);
                if (wordSet.contains(newWord)) {
                    neighbors.add(newWord);
                }
            }
            chars[i] = oldChar;
        }

        return neighbors;
    }
}
