import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(1, n, k, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int start, int n, int k, List<Integer> current, List<List<Integer>> result) {
        // Base case: If the combination is done
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Optimization: No need to iterate if there aren't enough elements left to fulfill k
        // i <= n - (k - current.size()) + 1
        for (int i = start; i <= n - (k - current.size()) + 1; i++) {
            current.add(i);                  // Choose the element
            backtrack(i + 1, n, k, current, result); // Recurse to the next number
            current.remove(current.size() - 1); // Backtrack (undo the choice)
        }
    }
}
