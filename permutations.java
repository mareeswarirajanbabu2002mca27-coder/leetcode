import java.util.*;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums) {
        // If the current permutation is complete
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                // If number is already used, skip it
                if (tempList.contains(nums[i])) continue;
                
                tempList.add(nums[i]);
                backtrack(result, tempList, nums);
                
                // Remove the last element to backtrack and try the next number
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
