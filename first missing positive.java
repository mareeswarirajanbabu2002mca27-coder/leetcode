class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // 1. Cyclic Sort: Place each number x at index x-1 if possible
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                // Swap nums[i] to its target index nums[i] - 1
                int targetIdx = nums[i] - 1;
                int temp = nums[i];
                nums[i] = nums[targetIdx];
                nums[targetIdx] = temp;
            }
        }

        // 2. Identify the first index where the value is incorrect
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        // 3. If all positions are correct, the missing number is n + 1
        return n + 1;
    }
}
