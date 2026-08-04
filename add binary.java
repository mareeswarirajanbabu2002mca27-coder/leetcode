class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        
        // Pointers for both strings starting at the back (least significant bit)
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        
        // Loop as long as there are characters to process or a carry remains
        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;
            
            // Add bits from string a if available
            if (i >= 0) {
                sum += a.charAt(i) - '0'; // Convert char to int
                i--;
            }
            
            // Add bits from string b if available
            if (j >= 0) {
                sum += b.charAt(j) - '0'; // Convert char to int
                j--;
            }
            
            // Append the remainder bit (sum % 2) to our result
            sb.append(sum % 2);
            
            // Calculate the new carry (sum / 2)
            carry = sum / 2;
        }
        
        // Since we added bits from right to left, the result is backwards
        return sb.reverse().toString();
    }
}
