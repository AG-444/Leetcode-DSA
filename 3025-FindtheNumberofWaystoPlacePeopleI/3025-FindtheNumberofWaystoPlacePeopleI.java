// Last updated: 9/3/2025, 4:20:46 PM
class Solution {
    public int numberOfPairs(int[][] points) {
        int count = 0;
        int n = points.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;

                // check orientation first
                if (points[i][0] >= points[j][0] && points[i][1] <= points[j][1]) {

                    // bounding box limits
                    int xLow = points[j][0];
                    int xHigh = points[i][0];
                    int yLow = points[i][1];
                    int yHigh = points[j][1];

                    boolean valid = true;

                    for (int k = 0; k < n; k++) {
                        if (k == i || k == j) continue;

                        int x = points[k][0];
                        int y = points[k][1];

                        if (x >= xLow && x <= xHigh && y >= yLow && y <= yHigh) {
                            valid = false;
                            break;
                        }
                    }
                    if (valid) count++;
                }
            }
        }
        return count;
    }
}
