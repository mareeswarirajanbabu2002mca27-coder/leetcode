class Solution {
    public int removeElement(int[] nums, int val) {
        // 'k' tracks the index for the next valid (non-val) element
        int k = 0;

        for (int i = 0; i < nums.length; i++) {
            // If the current element is NOT the value we want to remove
            if (nums[i] != val) {
                nums[k] = nums[i]; // Move it to the 'k' position
                k++;               // Increment the count of valid elements
            }
        }

        // 'k' is the total number of elements not equal to 'val'
        return k;
    }
}
