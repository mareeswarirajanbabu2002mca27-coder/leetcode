class Solution {
    public double myPow(double x, int n) {
        // Handle negative exponent
        // We use long to avoid overflow when n is Integer.MIN_VALUE
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        double result = 1;
        double currentProduct = x;

        // Binary Exponentiation
        for (long i = N; i > 0; i /= 2) {
            // If the current bit is 1, multiply the result by the current product
            if (i % 2 == 1) {
                result *= currentProduct;
            }
            // Square the base for the next bit
            currentProduct *= currentProduct;
        }

        return result;
    }
}
