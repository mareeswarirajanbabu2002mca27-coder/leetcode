class Solution {
    public int removeDuplicates(int[] nums) {
        // If the array has 2 or fewer elements, every element is allowed
        if (nums.length <= 2) {
            return nums.length;
        }
        
        // 'i' represents the index where the next valid element should be written
        int i = 2; 
        
        // Start checking from the 3rd element (index 2)
        for (int j = 2; j < nums.length; j++) {
            // Compare current element with the one placed 2 steps behind in the valid array
            if (nums[j] != nums[i - 2]) {
                nums[i] = nums[j];
                i++;
            }
        }
        
        return i; // 'i' is the count of valid elements
    }
}
