// Last updated: 8/28/2025, 9:58:04 AM
class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int total = n * m;
        int[] result = new int[total];
        int idx = 0;

        for (int i = 0; i < n + m - 1; i++) {
            int row, col;
            if (i % 2 == 0) {
                // go up-right
                row = Math.min(i, n - 1);
                col = i - row;
                while (row >= 0 && col < m) {
                    result[idx++] = mat[row][col];
                    row--;
                    col++;
                }
            } else {
                // go down-left
                col = Math.min(i, m - 1);
                row = i - col;
                while (row < n && col >= 0) {
                    result[idx++] = mat[row][col];
                    row++;
                    col--;
                }
            }
        }
        return result;
    }
}
