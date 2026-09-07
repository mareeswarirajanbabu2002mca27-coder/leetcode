import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // Sort the array so that duplicates are adjacent
        Arrays.sort(nums);
        
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> currentSubset, int[] nums, int start) {
        // Add a copy of the current valid subset to the results list
        result.add(new ArrayList<>(currentSubset));

        for (int i = start; i < nums.length; i++) {
            // Skip duplicates: If the current element is the same as the previous element 
            // AND we didn't just pick the previous element in this recursion level.
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            // Include the current element
            currentSubset.add(nums[i]);
            
            // Move to the next element
            backtrack(result, currentSubset, nums, i + 1);
            
            // Backtrack: Remove the element to explore subsets without it
            currentSubset.remove(currentSubset.size() - 1);
        }
    }
}
