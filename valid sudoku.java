import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Use Sets to track numbers seen in each row, column, and box
        // We use an array of Sets for easy indexing
        Set<Character>[] rows = new HashSet[9];
        Set<Character>[] cols = new HashSet[9];
        Set<Character>[] boxes = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char val = board[r][c];

                // Skip empty cells
                if (val == '.') continue;

                // Calculate the index for the 3x3 sub-box
                // (r/3) gives row group (0-2), (c/3) gives column group (0-2)
                int boxIndex = (r / 3) * 3 + (c / 3);

                // If the value already exists in the row, column, or box, it's invalid
                if (rows[r].contains(val) || 
                    cols[c].contains(val) || 
                    boxes[boxIndex].contains(val)) {
                    return false;
                }

                // Add the value to the respective sets
                rows[r].add(val);
                cols[c].add(val);
                boxes[boxIndex].add(val);
            }
        }

        return true;
    }
}
