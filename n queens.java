import java.util.*;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        
        // Trackers for columns and diagonals
        boolean[] cols = new boolean[n];
        boolean[] diag1 = new boolean[2 * n]; // row + col
        boolean[] diag2 = new boolean[2 * n]; // row - col + n
        
        backtrack(result, board, 0, n, cols, diag1, diag2);
        return result;
    }

    private void backtrack(List<List<String>> res, char[][] board, int row, int n, 
                           boolean[] cols, boolean[] diag1, boolean[] diag2) {
        if (row == n) {
            res.add(construct(board));
            return;
        }

        for (int col = 0; col < n; col++) {
            int d1 = row + col;
            int d2 = row - col + n;
            
            if (!cols[col] && !diag1[d1] && !diag2[d2]) {
                // Place queen
                board[row][col] = 'Q';
                cols[col] = diag1[d1] = diag2[d2] = true;
                
                // Move to next row
                backtrack(res, board, row + 1, n, cols, diag1, diag2);
                
                // Remove queen (backtrack)
                board[row][col] = '.';
                cols[col] = diag1[d1] = diag2[d2] = false;
            }
        }
    }

    private List<String> construct(char[][] board) {
        List<String> path = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            path.add(new String(board[i]));
        }
        return path;
    }
}
