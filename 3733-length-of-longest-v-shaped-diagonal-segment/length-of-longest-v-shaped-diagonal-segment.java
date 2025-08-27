/**
 * Time Complexity: O(m * n)
 * Space Complexity: O(m * n)
 */
class Solution {
    // Diagonal directions: ↘, ↙, ↖, ↗
    private static final int[][] DIRS = {
        { 1, 1 },   // down-right
        { 1, -1 },  // down-left
        { -1, -1 }, // up-left
        { -1, 1 }   // up-right
    };

    public int lenOfVDiagonal(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // memo[row][col][mask], mask encodes (dir, canTurn)
        // dir: 0..3, canTurn: 0/1  => mask = dir << 1 | canTurn
        int[][][] memo = new int[m][n][1 << 3];

        int ans = 0;

        // Start from every cell containing 1
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 1) continue;

                // Precompute theoretical max path length in each direction
                int[] maxs = { m - i, j + 1, i + 1, n - j };

                // Try all 4 starting directions
                for (int k = 0; k < 4; k++) {
                    if (maxs[k] > ans) { // prune: skip if impossible to beat ans
                        ans = Math.max(ans, dfs(i, j, k, 1, 2, grid, memo) + 1);
                    }
                }
            }
        }
        return ans;
    }

    private int dfs(int i, int j, int dir, int canTurn, int target,
                    int[][] grid, int[][][] memo) {
        int m = grid.length, n = grid[0].length;

        // Move to the next cell along direction
        i += DIRS[dir][0];
        j += DIRS[dir][1];

        // Stop if out of bounds or wrong value
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != target) {
            return 0;
        }

        // Encode state
        int mask = dir << 1 | canTurn;
        if (memo[i][j][mask] > 0) return memo[i][j][mask];

        // Continue straight
        int res = dfs(i, j, dir, canTurn, 2 - target, grid, memo);

        // Try one clockwise turn if available
        if (canTurn == 1) {
            int[] maxs = { m - i - 1, j, i, n - j - 1 };
            int newDir = (dir + 1) % 4;
            if (maxs[newDir] > res) { // prune: only recurse if possible improvement
                res = Math.max(res, dfs(i, j, newDir, 0, 2 - target, grid, memo));
            }
        }

        return memo[i][j][mask] = res + 1;
    }
}
