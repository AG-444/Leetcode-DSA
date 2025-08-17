class Solution {
    public double new21Game(int n, int k, int maxPts) {
        // Edge case: if Alice never draws (k == 0), or
        // if n is large enough that all possible outcomes are <= n
        if (k == 0 || n >= k + maxPts - 1) {
            return 1.0;
        }
        double[] dp = new double[n + 1];
        dp[0] = 1.0;
        double windowSum = 1.0;  // running sum of the last maxPts dp values (valid states)
        double result = 0.0;

        for (int i = 1; i <= n; i++) {
            dp[i] = windowSum / maxPts;

            if (i < k) {
                // Still in the drawing phase -> this state can lead to future states
                windowSum += dp[i];
            } else {
                // Already >= k -> Alice stops -> final outcome
                result += dp[i];
            }

            // Slide the window: remove dp[i - maxPts] if it’s outside range
            if (i - maxPts >= 0) {
                windowSum -= dp[i - maxPts];
            }
        }

        return result;
    }
}
