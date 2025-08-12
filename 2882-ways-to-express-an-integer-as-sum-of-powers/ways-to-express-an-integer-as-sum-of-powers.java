class Solution {
    static final int MOD = 1000000007;

    public int numberOfWays(int n, int x) {
        // Step 1: precompute all i^x <= n
        List<Integer> powers = new ArrayList<>();
        for (int i = 1; Math.pow(i, x) <= n; i++) {
            powers.add((int) Math.pow(i, x));
        }

        int m = powers.size();
        int[][] dp = new int[m + 1][n + 1];
        dp[0][0] = 1; // one way to make sum 0

        // Step 2: fill dp
        for (int i = 1; i <= m; i++) {
            int p = powers.get(i - 1);
            for (int sum = 0; sum <= n; sum++) {
                // Exclude current power
                dp[i][sum] = dp[i - 1][sum];
                // Include current power
                if (sum >= p) {
                    dp[i][sum] = (dp[i][sum] + dp[i - 1][sum - p]) % MOD;
                }
            }
        }

        return dp[m][n];
    }
}
