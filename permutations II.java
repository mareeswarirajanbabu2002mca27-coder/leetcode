import java.util.*;

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Step 1: Sort to handle duplicates
        backtrack(result, new ArrayList<>(), nums, new boolean[nums.length]);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, boolean[] used) {
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // Skip if the element is already used in this permutation
            if (used[i]) continue;
            
            // Step 2: Skip duplicates
            // If current number is same as previous, and previous hasn't been used 
            // in this path, it means we already explored this branch.
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;

            used[i] = true;
            tempList.add(nums[i]);
            
            backtrack(result, tempList, nums, used);
            
            // Backtrack
            used[i] = false;
            tempList.remove(tempList.size() - 1);
        }
    }
}
