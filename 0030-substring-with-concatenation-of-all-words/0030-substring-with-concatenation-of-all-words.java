import java.util.*;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < words.length * words[0].length()) {
            return result;
        }

        int wordLen = words[0].length();
        int windowLen = words.length * wordLen;
        int n = s.length();

        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) 
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);

        for (int i = 0; i < wordLen; i++) {
            int left = i, count = 0;
            Map<String, Integer> seenWords = new HashMap<>();

            for (int j = i; j <= n - wordLen; j += wordLen) {
                String sub = s.substring(j, j + wordLen);
                if (wordCount.containsKey(sub)) {
                    seenWords.put(sub, seenWords.getOrDefault(sub, 0) + 1);
                    count++;

                    while (seenWords.get(sub) > wordCount.get(sub)) {
                        String leftWord = s.substring(left, left + wordLen);
                        seenWords.put(leftWord, seenWords.get(leftWord) - 1);
                        count--;
                        left += wordLen;
                    }

                    if (count == words.length) {
                        result.add(left);
                        String leftWord = s.substring(left, left + wordLen);
                        seenWords.put(leftWord, seenWords.get(leftWord) - 1);
                        count--;
                        left += wordLen;
                    }
                } else {
                    seenWords.clear();
                    count = 0;
                    left = j + wordLen;
                }
            }
        }
        return result;
    }
}
