class Solution {
    public int numSubmat(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] width = new int[n][m];
        int total = 0;

        // Fill width array
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 1) {
                    if (j == 0) {
                        width[i][j] = 1;
                    } else {
                        width[i][j] = width[i][j-1] + 1;
                    }

                    // Count rectangles ending at (i, j)
                    int minWidth = width[i][j];
                    for (int k = i; k >= 0 && minWidth > 0; k--) {
                        minWidth = Math.min(minWidth, width[k][j]);
                        total += minWidth;
                    }
                }
            }
        }
        return total;
    }
}