// Last updated: 8/28/2025, 9:57:54 AM
class Solution {
    public:
        int longestCommonSubsequence(string text1, string text2) {
        int n = text1.length(), m = text2.length();
        if (m > n) swap(text1, text2), swap(n, m); // Ensure text2 is shorter

        vector<int> prev(m + 1, 0), curr(m + 1, 0);

        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= m; ++j) {
                if (text1[i - 1] == text2[j - 1]) {
                    curr[j] = 1 + prev[j - 1];
                } else {
                    curr[j] = max(prev[j], curr[j - 1]);
                }
            }
            prev = curr;
        }

        return prev[m];
    }
};
