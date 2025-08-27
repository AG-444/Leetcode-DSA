class Solution {
    // Directions: ↘, ↙, ↖, ↗ (dx, dy)
    private static final int[][] DIRECTIONS = {
        {1, 1},   // down-right
        {1, -1},  // down-left
        {-1, -1}, // up-left
        {-1, 1}   // up-right
    };

    public int lenOfVDiagonal(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int maxLen = 0;

        // Start from every cell containing 1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    // Try all 4 diagonal directions
                    for (int d = 0; d < 4; d++) {
                        maxLen = Math.max(maxLen, dfs(grid, i, j, d, 2, false));
                    }
                }
            }
        }

        return maxLen;
    }

    /**
     * DFS brute force search.
     * @param grid matrix
     * @param x current row
     * @param y current col
     * @param dir direction index (0-3)
     * @param expected next expected value in sequence
     * @param turned whether we already turned once
     * @return length of longest valid segment starting here
     */
    private int dfs(int[][] grid, int x, int y, int dir, int expected, boolean turned) {
        int n = grid.length;
        int m = grid[0].length;
        int length = 1; // current cell is always valid

        int dx = DIRECTIONS[dir][0];
        int dy = DIRECTIONS[dir][1];
        int nx = x + dx;
        int ny = y + dy;

        // Move straight if valid
        if (inBounds(nx, ny, n, m) && grid[nx][ny] == expected) {
            length = Math.max(length, 1 + dfs(grid, nx, ny, dir, nextExpected(expected), turned));
        }

        // Try one clockwise turn if not used
        if (!turned) {
            int newDir = (dir + 1) % 4; // clockwise turn
            dx = DIRECTIONS[newDir][0];
            dy = DIRECTIONS[newDir][1];
            nx = x + dx;
            ny = y + dy;

            if (inBounds(nx, ny, n, m) && grid[nx][ny] == expected) {
                length = Math.max(length, 1 + dfs(grid, nx, ny, newDir, nextExpected(expected), true));
            }
        }

        return length;
    }

    // Compute the next expected value in sequence 1 → 2 → 0 → 2 → 0 …
    private int nextExpected(int curr) {
        if (curr == 1) return 2;
        if (curr == 2) return 0;
        return 2; // curr == 0
    }

    // Check if coordinates are valid
    private boolean inBounds(int x, int y, int n, int m) {
        return x >= 0 && y >= 0 && x < n && y < m;
    }
}
