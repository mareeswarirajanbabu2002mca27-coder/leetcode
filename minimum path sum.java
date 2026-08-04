class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int m = grid.length;
        int n = grid[0].length;
        
        // dp[j] will store the minimum path sum to reach the current cell in column j
        int[] dp = new int[n];
        
        // Base case: initialize the top-left corner
        dp[0] = grid[0][0];
        
        // Initialize the rest of the first row (can only be reached from the left)
        for (int j = 1; j < n; j++) {
            dp[j] = dp[j - 1] + grid[0][j];
        }
        
        // Process the remaining rows
        for (int i = 1; i < m; i++) {
            // For the first column of any row, you can only arrive from above
            dp[0] = dp[0] + grid[i][0];
            
            for (int j = 1; j < n; j++) {
                // Choose the minimum cost between coming from above (dp[j]) or from the left (dp[j-1])
                dp[j] = Math.min(dp[j], dp[j - 1]) + grid[i][j];
            }
        }
        
        // Return the minimum path sum to the bottom-right corner
        return dp[n - 1];
    }
}
