import java.util.Stack;

class Solution {
    public String simplifyPath(String path) {
        // 1. Split the path by slashes into directory components
        String[] tokens = path.split("/");
        Stack<String> stack = new Stack<>();
        
        for (String token : tokens) {
            // Case 1: Empty token (from consecutive slashes) or current directory '.'
            if (token.isEmpty() || token.equals(".")) {
                continue; 
            }
            
            // Case 2: Parent directory '..'
            if (token.equals("..")) {
                // Pop the last directory if stack is not empty (cannot go above root)
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } 
            // Case 3: Valid directory name (including '...', '....', etc.)
            else {
                stack.push(token);
            }
        }
        
        // 2. Reconstruct the canonical path from the stack components
        StringBuilder sb = new StringBuilder();
        for (String dir : stack) {
            sb.append("/").append(dir);
        }
        
        // If the stack was empty, return the root path "/"
        return sb.length() == 0 ? "/" : sb.toString();
    }
}
