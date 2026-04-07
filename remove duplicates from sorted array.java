class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        // 'i' is the pointer for the last unique element found
        int i = 0;

        // 'j' scans through the array to find new unique elements
        for (int j = 1; j < nums.length; j++) {
            // If we find a value different from the last unique one
            if (nums[j] != nums[i]) {
                i++;           // Move to the next slot
                nums[i] = nums[j]; // Update it with the new unique value
            }
        }

        // Return the count of unique elements (index + 1)
        return i + 1;
    }
}
