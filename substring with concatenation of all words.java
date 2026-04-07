import java.util.*;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) return res;

        // FIXED: Changed words.length to words[0].length()
        int wordLen = words[0].length(); 
        int wordCount = words.length;
        
        Map<String, Integer> wordFreq = new HashMap<>();
        for (String word : words) {
            wordFreq.put(word, wordFreq.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i < wordLen; i++) {
            int left = i, right = i, count = 0;
            Map<String, Integer> currentWindow = new HashMap<>();

            while (right + wordLen <= s.length()) {
                String word = s.substring(right, right + wordLen);
                right += wordLen;

                if (wordFreq.containsKey(word)) {
                    currentWindow.put(word, currentWindow.getOrDefault(word, 0) + 1);
                    count++;

                    while (currentWindow.get(word) > wordFreq.get(word)) {
                        String leftWord = s.substring(left, left + wordLen);
                        currentWindow.put(leftWord, currentWindow.get(leftWord) - 1);
                        left += wordLen;
                        count--;
                    }

                    if (count == wordCount) {
                        res.add(left);
                        // Optional: Slide left once to keep looking for next match
                        String leftWord = s.substring(left, left + wordLen);
                        currentWindow.put(leftWord, currentWindow.get(leftWord) - 1);
                        left += wordLen;
                        count--;
                    }
                } else {
                    currentWindow.clear();
                    count = 0;
                    left = right;
                }
            }
        }
        return res;
    }
}
