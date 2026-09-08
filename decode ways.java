public class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int n = s.length();
        // dp[i] stores the number of ways to decode the prefix of length i
        int[] dp = new int[n + 1];
        
        // Base case: An empty string has 1 valid decoding way
        dp[0] = 1;
        
        // Base case: First character
        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        for (int i = 2; i <= n; i++) {
            // Check if successful single-digit decode is possible
            int oneDigit = Integer.parseInt(s.substring(i - 1, i));
            if (oneDigit >= 1 && oneDigit <= 9) {
                dp[i] += dp[i - 1];
            }

            // Check if successful two-digit decode is possible
            int twoDigits = Integer.parseInt(s.substring(i - 2, i));
            if (twoDigits >= 10 && twoDigits <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Solution solver = new Solution();
        
        // Test examples
        System.out.println(solver.numDecodings("12"));  // Output: 2
        System.out.println(solver.numDecodings("226")); // Output: 3
        System.out.println(solver.numDecodings("06"));  // Output: 0
    }
}
