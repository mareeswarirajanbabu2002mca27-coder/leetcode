class Solution {
    public int climbStairs(int n) {
        // Base cases: 1 way for 1 step, 2 ways for 2 steps
        if (n == 1) return 1;
        if (n == 2) return 2;
        
        // Track the number of ways for the previous two steps
        int prev2 = 1; // Ways to reach step 1
        int prev1 = 2; // Ways to reach step 2
        int current = 0;
        
        // Compute ways for steps 3 up to n
        for (int i = 3; i <= n; i++) {
            current = prev1 + prev2;
            prev2 = prev1;   // Shift pointers forward
            prev1 = current;
        }
        
        return current;
    }
}
