class Solution {
    public boolean search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (nums[mid] == target) {
                return true;
            }
            
            // Edge Case: When elements at low, mid, and high are all equal,
            // we cannot determine which half is sorted. Shrink the boundaries.
            if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
                low++;
                high--;
            } 
            // Case 1: The left half is sorted
            else if (nums[low] <= nums[mid]) {
                // Check if target lies within the sorted left half
                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } 
            // Case 2: The right half is sorted
            else {
                // Check if target lies within the sorted right half
                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        
        return false;
    }
}
