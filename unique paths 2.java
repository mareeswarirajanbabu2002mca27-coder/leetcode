class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // Edge case: If the starting cell or ending cell has an obstacle, no paths exist
        if (obstacleGrid == null || obstacleGrid[0][0] == 1 || obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1] == 1) {
            return 0;
        }
        
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        // dp[j] will store the number of unique paths to the current cell in column j
        int[] dp = new int[n];
        
        // Base case: There is 1 way to start at the top-left cell
        dp[0] = 1;
        
        // Iterate through all cells in the grid row by row
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // If the current cell is an obstacle, it blocks all paths
                if (obstacleGrid[i][j] == 1) {
                    dp[j] = 0;
                } 
                // Otherwise, update the paths if we are not at the first column
                // (First column cells only depend on the cell directly above them)
                else if (j > 0) {
                    // dp[j] (cell above) + dp[j-1] (cell to the left)
                    dp[j] = dp[j] + dp[j - 1];
                }
            }
        }
        
        // Return the number of unique paths to the bottom-right corner
        return dp[n - 1];
    }
}
