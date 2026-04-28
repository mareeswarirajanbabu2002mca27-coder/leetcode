class Solution {
    public boolean isMatch(String s, String p) {
        int sIdx = 0, pIdx = 0, match = 0, starIdx = -1;            
        
        while (sIdx < s.length()) {
            // 1. If characters match or pattern has '?'
            if (pIdx < p.length() && (p.charAt(pIdx) == '?' || s.charAt(sIdx) == p.charAt(pIdx))) {
                sIdx++;
                pIdx++;
            }
            // 2. If pattern has '*', record position and try matching 0 characters first
            else if (pIdx < p.length() && p.charAt(pIdx) == '*') {
                starIdx = pIdx;
                match = sIdx;
                pIdx++;
            }
            // 3. If last pattern char was '*', but current chars don't match, 
            //    backtrack: make '*' match one more character in 's'
            else if (starIdx != -1) {
                pIdx = starIdx + 1;
                match++;
                sIdx = match;
            }
            // 4. No match possible
            else {
                return false;
            }
        }
        
        // Check for remaining '*' in pattern
        while (pIdx < p.length() && p.charAt(pIdx) == '*') {
            pIdx++;
        }
        
        return pIdx == p.length();
    }
}
