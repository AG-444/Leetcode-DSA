// Last updated: 8/28/2025, 9:58:41 AM
class Solution {
    public int uniquePaths(int m, int n) {
        // Total moves = m + n - 2
        // Choose (m - 1) moves to go down (or (n - 1) to go right)
        // So result is C(m+n-2, m-1)

        long res = 1;

        // res = (m+n-2)! / ((m-1)! * (n-1)!)
        // To avoid overflow, we calculate it iteratively:
        for (int i = 1; i <= m - 1; i++) {
            res = res * (n - 1 + i) / i;
        }

        return (int) res;
    }
}
