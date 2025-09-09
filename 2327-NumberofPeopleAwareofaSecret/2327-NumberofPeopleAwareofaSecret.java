// Last updated: 9/9/2025, 9:53:36 AM
class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        int MOD = 1_000_000_007;

        long[] dp = new long[n + 1]; // dp[i] = number of people who learn the secret on day i
        dp[1] = 1; // Day 1: first person learns the secret

        long sharers = 0; // number of active sharers at day i

        for (int day = 2; day <= n; day++) {
            // People start sharing after `delay` days
            if (day - delay >= 1) {
                sharers = (sharers + dp[day - delay]) % MOD;
            }
            // People forget after `forget` days
            if (day - forget >= 1) {
                sharers = (sharers - dp[day - forget] + MOD) % MOD;
            }

            // All current sharers create new learners today
            dp[day] = sharers;
        }

        // Count how many people still remember the secret at the end of day n
        long result = 0;
        for (int day = n - forget + 1; day <= n; day++) {
            if (day >= 1) {
                result = (result + dp[day]) % MOD;
            }
        }

        return (int) result;
    }
}
