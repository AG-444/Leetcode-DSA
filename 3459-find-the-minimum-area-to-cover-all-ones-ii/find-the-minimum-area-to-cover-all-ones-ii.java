import java.util.*;

/**
 * LC 3197 — Find the Minimum Area to Cover All Ones II
 *
 * Idea:
 * 1) Collect coordinates of all 1s.
 * 2) Enumerate partitions where 3 rectangles are induced by cuts:
 *    - Three vertical strips  (two vertical cut lines)
 *    - Three horizontal strips (two horizontal cut lines)
 *    - T-shaped partitions using one horizontal and one vertical cut:
 *        (A) top-bar     + bottom-left + bottom-right
 *        (B) bottom-bar  + top-left    + top-right
 *        (C) left-bar    + top-right   + bottom-right
 *        (D) right-bar   + top-left    + bottom-left
 * 3) For each partition, compute bounding box for each group; sum areas.
 * 4) Take the minimum over all valid partitions (each group must contain at least one '1').
 *
 * Complexity:
 *  - Let K be number of ones (K ≤ 900). n,m ≤ 30.
 *  - Vertical strips:  O(m^2 * K)
 *  - Horizontal strips: O(n^2 * K)
 *  - T-shapes (4 orientations): O(4 * n * m * K)
 *  - This is easily fine for constraints.
 */
class Solution {
    public int minimumSum(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        List<int[]> ones = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) ones.add(new int[]{i, j});
            }
        }

        int ans = Integer.MAX_VALUE;

        // Case 1: three vertical strips (two vertical cuts c1 < c2)
        for (int c1 = 0; c1 < m; c1++) {
            for (int c2 = c1 + 1; c2 < m; c2++) {
                int[][] boxes = new int[3][4];
                initBoxes(boxes);
                for (int[] p : ones) {
                    int r = p[0], c = p[1];
                    int idx = (c <= c1 ? 0 : (c <= c2 ? 1 : 2));
                    updateBox(boxes[idx], r, c);
                }
                ans = Math.min(ans, sumAreaIfValid(boxes));
            }
        }

        // Case 2: three horizontal strips (two horizontal cuts r1 < r2)
        for (int r1 = 0; r1 < n; r1++) {
            for (int r2 = r1 + 1; r2 < n; r2++) {
                int[][] boxes = new int[3][4];
                initBoxes(boxes);
                for (int[] p : ones) {
                    int r = p[0], c = p[1];
                    int idx = (r <= r1 ? 0 : (r <= r2 ? 1 : 2));
                    updateBox(boxes[idx], r, c);
                }
                ans = Math.min(ans, sumAreaIfValid(boxes));
            }
        }

        // Case 3: T-shaped partitions (all four orientations)
        // Cut at (cutR, cutC): r <= cutR is "top", c <= cutC is "left"
        for (int cutR = 0; cutR < n; cutR++) {
            for (int cutC = 0; cutC < m; cutC++) {
                // (A) top-bar + bottom-left + bottom-right
                ans = Math.min(ans, evalT(ones, cutR, cutC, 0));

                // (B) bottom-bar + top-left + top-right
                ans = Math.min(ans, evalT(ones, cutR, cutC, 1));

                // (C) left-bar + top-right + bottom-right
                ans = Math.min(ans, evalT(ones, cutR, cutC, 2));

                // (D) right-bar + top-left + bottom-left
                ans = Math.min(ans, evalT(ones, cutR, cutC, 3));
            }
        }

        return ans;
    }

    /** Initialize 3 boxes with sentinel -1: [minR, maxR, minC, maxC] */
    private void initBoxes(int[][] boxes) {
        for (int[] b : boxes) Arrays.fill(b, -1);
    }

    /** Expand bounding box with a new point (r,c). */
    private void updateBox(int[] box, int r, int c) {
        if (box[0] == -1) {
            box[0] = box[1] = r;
            box[2] = box[3] = c;
        } else {
            box[0] = Math.min(box[0], r);
            box[1] = Math.max(box[1], r);
            box[2] = Math.min(box[2], c);
            box[3] = Math.max(box[3], c);
        }
    }

    /** Sum area of three boxes if all are valid (contain at least one point), else INF. */
    private int sumAreaIfValid(int[][] boxes) {
        long total = 0;
        for (int[] b : boxes) {
            if (b[0] == -1) return Integer.MAX_VALUE;
            total += (long)(b[1] - b[0] + 1) * (b[3] - b[2] + 1);
            if (total > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        }
        return (int) total;
    }

    /**
     * Evaluate a T-shaped partition for given (cutR, cutC).
     * mode:
     *   0: top-bar     + bottom-left + bottom-right
     *   1: bottom-bar  + top-left    + top-right
     *   2: left-bar    + top-right   + bottom-right
     *   3: right-bar   + top-left    + bottom-left
     */
    private int evalT(List<int[]> ones, int cutR, int cutC, int mode) {
        int[][] boxes = new int[3][4];
        initBoxes(boxes);

        for (int[] p : ones) {
            int r = p[0], c = p[1];
            int idx;

            if (mode == 0) {
                // top bar
                if (r <= cutR) idx = 0;
                else idx = (c <= cutC ? 1 : 2);
            } else if (mode == 1) {
                // bottom bar
                if (r > cutR) idx = 0;
                else idx = (c <= cutC ? 1 : 2);
            } else if (mode == 2) {
                // left bar
                if (c <= cutC) idx = 0;
                else idx = (r <= cutR ? 1 : 2);
            } else {
                // right bar
                if (c > cutC) idx = 0;
                else idx = (r <= cutR ? 1 : 2);
            }

            updateBox(boxes[idx], r, c);
        }

        return sumAreaIfValid(boxes);
    }
}
