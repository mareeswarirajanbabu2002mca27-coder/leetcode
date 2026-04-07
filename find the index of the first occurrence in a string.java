class Solution {
    public int strStr(String haystack, String needle) {
        int hLen = haystack.length();
        int nLen = needle.length();

        // If needle is longer than haystack, it can't be a substring
        if (nLen > hLen) return -1;

        // Iterate through haystack until there's no room left for the needle
        for (int i = 0; i <= hLen - nLen; i++) {
            // Check if the substring starting at i matches needle
            if (haystack.substring(i, i + nLen).equals(needle)) {
                return i;
            }
        }

        return -1;
    }
}
