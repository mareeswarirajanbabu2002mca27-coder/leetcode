class Solution {
    public int[][] generateMatrix(int n) {
        // Initialize the n x n matrix
        int[][] matrix = new int[n][n];
        
        // Define our boundary pointers
        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = n - 1;
        
        // Counter to fill the matrix
        int num = 1;
        
        // Loop until boundaries cross or we fill all elements
        while (left <= right && top <= bottom) {
            
            // 1. Fill from left to right along the top row
            for (int i = left; i <= right; i++) {
                matrix[top][i] = num++;
            }
            top++; // Shrink the top boundary downward
            
            // 2. Fill from top to bottom along the right column
            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = num++;
            }
            right--; // Shrink the right boundary leftward
            
            // 3. Fill from right to left along the bottom row
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    matrix[bottom][i] = num++;
                }
                bottom--; // Shrink the bottom boundary upward
            }
            
            // 4. Fill from bottom to top along the left column
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    matrix[i][left] = num++;
                }
                left++; // Shrink the left boundary rightward
            }
        }
        
        return matrix;
    }
}
