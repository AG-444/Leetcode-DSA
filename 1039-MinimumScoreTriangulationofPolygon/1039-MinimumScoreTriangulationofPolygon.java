// Last updated: 9/29/2025, 11:26:32 AM
class Solution {
    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        int[][] dp = new int[n][n];

        // dp[i][j] = minimum score to triangulate polygon between vertices i and j
        // length >= 3 needed to form a triangle
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;

                // try every possible middle point k
                for (int k = i + 1; k < j; k++) {
                    int score = dp[i][k] + dp[k][j] + values[i] * values[j] * values[k];
                    dp[i][j] = Math.min(dp[i][j], score);
                }
            }
        }
        return dp[0][n - 1];
    }
}
