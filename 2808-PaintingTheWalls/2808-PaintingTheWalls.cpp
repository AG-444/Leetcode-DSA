// Last updated: 8/28/2025, 9:57:33 AM
class Solution {
public:
    int paintWalls(vector<int>& cost, vector<int>& time) {
        int n = cost.size();
        vector<vector<int>> dp(n, vector<int>(n + 1, -1));
        return dfs(0, n, cost, time, dp);
    }

    int dfs(int i, int remain, vector<int>& cost, vector<int>& time, vector<vector<int>>& dp) {
        if (remain <= 0) return 0;
        if (i >= cost.size()) return INT_MAX / 2; 
        if (dp[i][remain] != -1) return dp[i][remain];

        int paint = cost[i] + dfs(i + 1, remain - 1 - time[i], cost, time, dp);
        int skip = dfs(i + 1, remain, cost, time, dp);

        return dp[i][remain] = min(paint, skip);
    }
};
