class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        
        int n1 = num1.length();
        int n2 = num2.length();
        int[] pos = new int[n1 + n2];
        
        // Multiply each digit from right to left
        for (int i = n1 - 1; i >= 0; i--) {
            for (int j = n2 - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                
                // Indices in the result array
                int p1 = i + j;
                int p2 = i + j + 1;
                
                int sum = mul + pos[p2];

                pos[p2] = sum % 10;   // Units place
                pos[p1] += sum / 10;  // Carry to the tens place
            }
        }
        
        // Convert array back to string
        StringBuilder sb = new StringBuilder();
        for (int p : pos) {
            // Skip leading zeros
            if (!(sb.length() == 0 && p == 0)) {
                sb.append(p);
            }
        }
        
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
