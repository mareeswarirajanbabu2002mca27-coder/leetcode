import java.util.ArrayList;
import java.util.List;

class Solution {
    public String getPermutation(int n, int k) {
        // 1. Precompute factorials and populate a list of available numbers
        int[] factorials = new int[n + 1];
        List<Integer> numbers = new ArrayList<>();
        
        factorials[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorials[i] = factorials[i - 1] * i;
            numbers.add(i); // List becomes [1, 2, 3, ..., n]
        }
        
        // Convert to 0-based indexing for easier block calculations
        k--; 
        
        StringBuilder sb = new StringBuilder();
        
        // 2. Determine digits sequentially
        for (int i = n; i > 0; i--) {
            // Find the size of each permutation block for the remaining elements
            int blockSize = factorials[i - 1];
            
            // Determine the index of the number to pick
            int index = k / blockSize;
            
            // Append the number and remove it from the available pool
            sb.append(numbers.get(index));
            numbers.remove(index);
            
            // Update k for the next position
            k %= blockSize;
        }
        
        return sb.toString();
    }
}
