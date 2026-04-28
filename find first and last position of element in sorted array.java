class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        
        // Find the first (leftmost) occurrence
        result[0] = findBound(nums, target, true);
        
        // If the target wasn't found at all, no need to search for the second bound
        if (result[0] != -1) {
            result[1] = findBound(nums, target, false);
        }
        
        return result;
    }

    private int findBound(int[] nums, int target, boolean isFirst) {
        int left = 0, right = nums.length - 1;
        int bound = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                bound = mid;
                if (isFirst) {
                    // Continue searching to the left to find the first occurrence
                    right = mid - 1;
                } else {
                    // Continue searching to the right to find the last occurrence
                    left = mid + 1;
                }
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return bound;
    }
}
