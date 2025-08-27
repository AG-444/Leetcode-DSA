class Solution {
    // Directions: ↘, ↙, ↖, ↗ (dx, dy)
    private static final int[][] DIRECTIONS = {
        {1, 1},   // down-right
        {1, -1},  // down-left
        {-1, -1}, // up-left
        {-1, 1}   // up-right
    };

    // Memoization table:
    // dp[row][col][dir][expected][turned]
    // expected: only 0 or 2, but we map (0 -> 0, 2 -> 1) for indexing
    // turned: 0 = not turned, 1 = turned
    private int[][][][][] dp;

    public int lenOfVDiagonal(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        dp = new int[n][m][4][2][2]; // default 0 means uncomputed

        int maxLen = 0;

        // Start from every cell that is 1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    // Try all 4 directions
                    for (int d = 0; d < 4; d++) {
                        maxLen = Math.max(maxLen, dfs(grid, i, j, d, 2, 0));
                    }
                }
            }
        }

        return maxLen;
    }

    /**
     * DFS with memoization.
     * @param grid matrix
     * @param x current row
     * @param y current col
     * @param dir direction index (0-3)
     * @param expected next expected value
     * @param turned 0 if not turned yet, 1 if already turned
     */
    private int dfs(int[][] grid, int x, int y, int dir, int expected, int turned) {
        int n = grid.length;
        int m = grid[0].length;

        // Map expected (0 or 2) to index 0/1
        int expIndex = (expected == 0 ? 0 : 1);

        // Check cache
        if (dp[x][y][dir][expIndex][turned] != 0) {
            return dp[x][y][dir][expIndex][turned];
        }

        int best = 1; // current cell is valid

        // Try to continue straight
        int dx = DIRECTIONS[dir][0];
        int dy = DIRECTIONS[dir][1];
        int nx = x + dx, ny = y + dy;
        if (inBounds(nx, ny, n, m) && grid[nx][ny] == expected) {
            best = Math.max(best, 1 + dfs(grid, nx, ny, dir, nextExpected(expected), turned));
        }

        // Try one clockwise turn if not yet used
        if (turned == 0) {
            int newDir = (dir + 1) % 4;
            int tx = x + DIRECTIONS[newDir][0];
            int ty = y + DIRECTIONS[newDir][1];
            if (inBounds(tx, ty, n, m) && grid[tx][ty] == expected) {
                best = Math.max(best, 1 + dfs(grid, tx, ty, newDir, nextExpected(expected), 1));
            }
        }

        // Save to cache and return
        dp[x][y][dir][expIndex][turned] = best;
        return best;
    }

    // Compute the next expected value in sequence 1 → 2 → 0 → 2 → 0 …
    private int nextExpected(int curr) {
        if (curr == 1) return 2;
        if (curr == 2) return 0;
        return 2; // curr == 0
    }

    private boolean inBounds(int x, int y, int n, int m) {
        return x >= 0 && y >= 0 && x < n && y < m;
    }
}
