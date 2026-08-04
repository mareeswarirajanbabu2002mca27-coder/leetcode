class Solution {
    public int uniquePaths(int m, int n) {
        // To optimize calculation, we choose the smaller of (m - 1) or (n - 1)
        int totalMoves = m + n - 2;
        int r = Math.min(m - 1, n - 1);
        
        long result = 1;
        
        // Calculate Combination (nCr) dynamically to prevent integer overflow
        for (int i = 1; i <= r; i++) {
            result = result * (totalMoves - r + i) / i;
        }
        
        return (int) result;
    }
}
