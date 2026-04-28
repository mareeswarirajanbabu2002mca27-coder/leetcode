import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates); // Step 1: Sort to handle duplicates
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, int remain, int start) {
        if (remain < 0) return;
        else if (remain == 0) result.add(new ArrayList<>(tempList));
        else {
            for (int i = start; i < nums.length; i++) {
                // Step 2: Skip duplicates in the same level of recursion
                if (i > start && nums[i] == nums[i - 1]) continue; 
                
                tempList.add(nums[i]);
                // Step 3: Move to 'i + 1' because each number can only be used once
                backtrack(result, tempList, nums, remain - nums[i], i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
