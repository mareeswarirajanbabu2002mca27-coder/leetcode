import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        
        // Edge case handling for empty matrix
        if (matrix == null || matrix.length == 0) {
            return result;
        }
        
        // Initialize boundary pointers
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        
        // Loop until boundaries cross each other
        while (left <= right && top <= bottom) {
            
            // 1. Traverse from left to right along the top row
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++; // Move the top boundary down
            
            // 2. Traverse from top to bottom along the right column
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--; // Move the right boundary left
            
            // 3. Traverse from right to left along the bottom row
            // (Check if top and bottom boundary crossed after step 1)
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--; // Move the bottom boundary up
            }
            
            // 4. Traverse from bottom to top along the left column
            // (Check if left and right boundary crossed after step 2)
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++; // Move the left boundary right
            }
        }
        
        return result;
    }
}
