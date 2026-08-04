class Solution {
    public boolean canJump(int[] nums) {
        // Tracks the furthest index reachable so far
        int maxReachable = 0;
        
        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            // If the current index is beyond the furthest reachable index, 
            // it means we are stuck and cannot proceed further.
            if (i > maxReachable) {
                return false;
            }
            
            // Update the maximum reachable index from the current position
            maxReachable = Math.max(maxReachable, i + nums[i]);
            
            // Optimization: If we can already reach or exceed the last index,
            // we can safely return true early.
            if (maxReachable >= nums.length - 1) {
                return true;
            }
        }
        
        return true;
    }
}
