class Solution {
    public int numSubmat(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] height = new int[n][m];
        int total = 0;

        // Build heights for histogram
        for (int j = 0; j < m; j++) {
            height[0][j] = matrix[0][j];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 1) {
                    height[i][j] = height[i-1][j] + 1;
                } else {
                    height[i][j] = 0;
                }
            }
        }

        // For each row, count rectangles using heights
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int minHeight = Integer.MAX_VALUE;
                for (int k = j; k >= 0; k--) {
                    if (height[i][k] == 0) break;
                    minHeight = Math.min(minHeight, height[i][k]);
                    total += minHeight;
                }
            }
        }
        return total;
    }
}