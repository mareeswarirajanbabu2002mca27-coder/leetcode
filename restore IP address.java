import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        // An IP address has 4 segments, each max 3 digits. Max length is 12.
        if (s == null || s.length() < 4 || s.length() > 12) {
            return result;
        }
        
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(String s, int startIndex, List<String> currentSegments, List<String> result) {
        // Base case: If we have successfully formed 4 segments
        if (currentSegments.size() == 4) {
            // If we also consumed the entire string, it's a valid IP address
            if (startIndex == s.length()) {
                result.add(String.join(".", currentSegments));
            }
            return;
        }

        // Try extracting a segment of length 1, 2, or 3 digits
        for (int len = 1; len <= 3; len++) {
            // Ensure we don't go out of bounds
            if (startIndex + len > s.length()) {
                break;
            }

            String segment = s.substring(startIndex, startIndex + len);

            // Validate the segment:
            // 1. Cannot have leading zeros (length > 1 and starts with '0')
            // 2. Must be less than or equal to 255 if length is 3
            if ((segment.length() > 1 && segment.charAt(0) == '0') || 
                (segment.length() == 3 && Integer.parseInt(segment) > 255)) {
                continue;
            }

            // Choose: Add the valid segment
            currentSegments.add(segment);
            
            // Explore: Recurse for the next segment
            backtrack(s, startIndex + len, currentSegments, result);
            
            // Unchoose: Backtrack for other combinations
            currentSegments.remove(currentSegments.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solver = new Solution();
        
        // Test examples
        System.out.println(solver.restoreIpAddresses("25525511135")); 
        // Output: ["255.255.11.135", "255.255.111.35"]
        
        System.out.println(solver.restoreIpAddresses("0000"));        
        // Output: ["0.0.0.0"]
        
        System.out.println(solver.restoreIpAddresses("101023"));      
        // Output: ["1.0.10.23", "1.0.102.3", "10.1.0.23", "10.10.2.3", "101.0.2.3"]
    }
}
