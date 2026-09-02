import java.util.HashMap;
import java.util.Map;

class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        // Map to store frequency of characters needed from string t
        Map<Character, Integer> targetMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
        }

        // Map to store frequency of characters in the current window of s
        Map<Character, Integer> windowMap = new HashMap<>();
        
        int left = 0;
        int right = 0;
        
        // 'have' tracks how many unique characters meet the required frequency condition
        // 'need' is the total number of unique characters required from t
        int have = 0;
        int need = targetMap.size();
        
        // Track the best window properties
        int minLen = Integer.MAX_VALUE;
        int minLeft = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            
            // Add current character to window frequency map
            if (targetMap.containsKey(c)) {
                windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);
                
                // If the count of character c matches the desired count in t, increment 'have'
                if (windowMap.get(c).equals(targetMap.get(c))) {
                    have++;
                }
            }

            // Try to shrink the window from the left once it is valid
            while (have == need) {
                // Update our smallest window tracking
                if ((right - left + 1) < minLen) {
                    minLen = right - left + 1;
                    minLeft = left;
                }

                char leftChar = s.charAt(left);
                
                // Remove the character at the left pointer from the window
                if (targetMap.containsKey(leftChar)) {
                    if (windowMap.get(leftChar).equals(targetMap.get(leftChar))) {
                        have--;
                    }
                    windowMap.put(leftChar, windowMap.get(leftChar) - 1);
                }
                
                left++; // Shrink the window
            }
            
            right++; // Expand the window
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLen);
    }
}
