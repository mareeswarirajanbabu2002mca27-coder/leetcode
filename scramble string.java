import java.util.HashMap;
import java.util.Map;

class Solution {
    // Memoization map to store results of evaluated string pairs
    private Map<String, Boolean> memo = new HashMap<>();

    public boolean isScramble(String s1, String s2) {
        // Base Case 1: If strings are identical, they are scrambles of each other
        if (s1.equals(s2)) {
            return true;
        }

        // Base Case 2: If lengths differ or character frequencies don't match, return false
        if (s1.length() != s2.length() || !hasSameFrequency(s1, s2)) {
            return false;
        }

        // Create a unique key for the current pair of substrings
        String key = s1 + "#" + s2;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int n = s1.length();

        // Try splitting the string at every possible index 'i'
        for (int i = 1; i < n; i++) {
            // Case 1: The two substrings were NOT swapped
            // Compare s1's left with s2's left, and s1's right with s2's right
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) && 
                isScramble(s1.substring(i), s2.substring(i))) {
                memo.put(key, true);
                return true;
            }

            // Case 2: The two substrings WERE swapped
            // Compare s1's left with s2's right, and s1's right with s2's left
            if (isScramble(s1.substring(0, i), s2.substring(n - i)) && 
                isScramble(s1.substring(i), s2.substring(0, n - i))) {
                memo.put(key, true);
                return true;
            }
        }

        // If no split choice yields a valid scramble configuration
        memo.put(key, false);
        return false;
    }

    // Helper method to quickly prune invalid branches using character counts
    private boolean hasSameFrequency(String s1, String s2) {
        int[] counts = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            counts[s1.charAt(i) - 'a']++;
            counts[s2.charAt(i) - 'a']--;
        }
        for (int count : counts) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
}
