// Last updated: 9/3/2025, 4:29:47 PM
import java.util.Arrays;

class Solution {

    /**
     * Counts pairs (Alice, Bob) such that:
     *  - Alice is the upper-left corner: xA <= xB and yA >= yB
     *  - No other point lies inside or on the rectangle [xA..xB] x [yB..yA]
     *
     * Algorithm:
     * 1) Sort points by x asc, and for ties by y desc.
     * 2) For each i (Alice = points[i]), sweep j = i+1..n-1 (Bob candidates).
     *    Keep 'best' = max y among points between i and j with y <= y[i].
     *    A pair (i, j) is valid iff y[j] <= y[i] AND y[j] > best.
     *
     * Why it works:
     * - Sorting by (x asc, y desc) makes all points with the same x contiguous,
     *   and within that block, higher y comes earlier.
     * - For fixed i, any point k in (i, j) with y in [y[j], y[i]] would update
     *   'best' to >= y[j], thus invalidating j. Equality blocks "on the fence".
     *
     * Time:  O(n^2)
     * Space: O(1)
     */
    public int numberOfPairs(int[][] points) {
        final int n = points.length;

        // Sort by x asc, y desc
        Arrays.sort(points, (a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(b[1], a[1]); // y descending for equal x
        });

        int count = 0;

        for (int i = 0; i < n; i++) {
            int topY = points[i][1];
            int best = Integer.MIN_VALUE; // max y seen in (i, j) with y <= topY

            for (int j = i + 1; j < n; j++) {
                int y = points[j][1];

                // Alice must be above Bob
                if (y > topY) continue;

                // Valid iff no y in (i, j) lies in [y, topY] (i.e., y > best)
                if (y > best) {
                    count++;
                    best = y; // expand the blocked bottom boundary
                }
            }
        }

        return count;
    }
}
