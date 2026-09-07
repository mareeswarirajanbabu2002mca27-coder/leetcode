class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // Pointer for the last valid element in nums1
        int p1 = m - 1;
        // Pointer for the last element in nums2
        int p2 = n - 1;
        // Pointer for the last slot of the combined array
        int p = m + n - 1;
        
        // Move backward through both arrays, picking the larger value
        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] > nums2[p2]) {
                nums1[p] = nums1[p1];
                p1--;
            } else {
                nums1[p] = nums2[p2];
                p2--;
            }
            p--;
        }
        
        // If there are remaining elements in nums2, copy them over.
        // (Note: If elements are left in nums1, they are already in the correct place)
        while (p2 >= 0) {
            nums1[p] = nums2[p2];
            p2--;
            p--;
        }
    }
}
