import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0, nums, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int start, int[] nums, List<Integer> current, List<List<Integer>> result) {
        // Every state reached is a valid subset, so add a copy of it to the result
        result.add(new ArrayList<>(current));

        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]);                 // Include the current element
            backtrack(i + 1, nums, current, result); // Recurse with the next elements
            current.remove(current.size() - 1);  // Backtrack (exclude the element)
        }
    }
}
