class Solution {
    public boolean isNumber(String s) {
        // Flags to track seen states
        boolean seenDigit = false;
        boolean seenDot = false;
        boolean seenExponent = false;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            // Case 1: The character is a digit
            if (Character.isDigit(c)) {
                seenDigit = true;
            } 
            // Case 2: The character is a sign (+ or -)
            else if (c == '+' || c == '-') {
                // A sign can only appear at the very beginning 
                // or immediately after an exponent 'e'/'E'
                if (i > 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') {
                    return false;
                }
            } 
            // Case 3: The character is an exponent notation (e or E)
            else if (c == 'e' || c == 'E') {
                // We cannot have multiple exponents, and we MUST have seen a digit before it
                if (seenExponent || !seenDigit) {
                    return false;
                }
                seenExponent = true;
                seenDigit = false; // Reset seenDigit to ensure an integer follows the exponent
            } 
            // Case 4: The character is a decimal dot (.)
            else if (c == '.') {
                // A dot cannot appear if we already saw a dot or an exponent
                if (seenDot || seenExponent) {
                    return false;
                }
                seenDot = true;
            } 
            // Case 5: Invalid character encountered
            else {
                return false;
            }
        }
        
        // The string is valid only if it ends with at least one digit processed
        return seenDigit;
    }
}
