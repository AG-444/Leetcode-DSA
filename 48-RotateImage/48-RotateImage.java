// Last updated: 10/11/2025, 11:37:31 AM
class Solution {
    /**
     * Rotates the given n x n matrix by 90 degrees clockwise in-place.
     * @param grid The matrix to rotate
     */
    public void rotate(int[][] grid) {
        int n = grid.length;

        // Step 1: Transpose the matrix
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = grid[i][j];
                grid[i][j] = grid[j][i];
                grid[j][i] = temp;
            }
        }

        // Step 2: Reverse each row
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = grid[i][j];
                grid[i][j] = grid[i][n - 1 - j];
                grid[i][n - 1 - j] = temp;
            }
        }
    }
}
