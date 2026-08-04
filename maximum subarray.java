class Solution {
    public int maxSubArray(int[] nums) {
        return findMaxSum(nums, 0, nums.length - 1);
    }

    private int findMaxSum(int[] nums, int left, int right) {
        if (left == right) return nums[left];

        int mid = left + (right - left) / 2;

        // Recursively find max in left and right halves
        int leftSum = findMaxSum(nums, left, mid);
        int rightSum = findMaxSum(nums, mid + 1, right);
        
        // Find max that crosses the midpoint
        int crossSum = findCrossMax(nums, left, mid, right);

        return Math.max(Math.max(leftSum, rightSum), crossSum);
    }

    private int findCrossMax(int[] nums, int left, int mid, int right) {
        // Max sum starting from mid and going left
        int leftPart = Integer.MIN_VALUE;
        int currentSum = 0;
        for (int i = mid; i >= left; i--) {
            currentSum += nums[i];
            leftPart = Math.max(leftPart, currentSum);
        }

        // Max sum starting from mid+1 and going right
        int rightPart = Integer.MIN_VALUE;
        currentSum = 0;
        for (int i = mid + 1; i <= right; i++) {
            currentSum += nums[i];
            rightPart = Math.max(rightPart, currentSum);
        }

        return leftPart + rightPart;
    }
}
