class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        
        // Iterate from the least significant digit to the most
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits; // No carry forward needed, return early
            }
            
            // If the digit is 9, it becomes 0
            digits[i] = 0;
        }
        
        // If we are here, it means all digits were 9 (e.g., 999 -> 1000)
        int[] result = new int[n + 1];
        result[0] = 1; // The rest are 0 by default in Java
        return result;
    }
}
