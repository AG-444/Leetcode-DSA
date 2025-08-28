// Last updated: 8/28/2025, 9:58:44 AM
class Solution {
    public double myPow(double x, int n) {
        long N = n; // convert to long to avoid overflow for Integer.MIN_VALUE
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        double result = 1.0;
        while (N > 0) {
            if ((N % 2) == 1) {
                result *= x;
            }
            x *= x;
            N /= 2;
        }

        return result;
    }
}
