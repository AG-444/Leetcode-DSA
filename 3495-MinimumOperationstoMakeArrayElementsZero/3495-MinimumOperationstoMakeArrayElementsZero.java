// Last updated: 9/6/2025, 6:49:08 PM
class Solution {

    // Precompute the power-of-4 ranges up to 4^15 (~10^9)
    private final long[] powerOf4;

    public Solution() {
        powerOf4 = new long[31];  // 4^0 up to 4^30 (plenty of range)
        powerOf4[0] = 1;
        for (int i = 1; i < powerOf4.length; i++) {
            powerOf4[i] = powerOf4[i - 1] * 4;
        }
    }

    private long countOperations(long l, long r) {
        long totalSelections = 0;

        for (int power = 1; power < powerOf4.length; power++) {
            long low = powerOf4[power - 1];
            long high = powerOf4[power] - 1;

            if (low > r) break;

            long overlapStart = Math.max(l, low);
            long overlapEnd = Math.min(r, high);

            long overlapCount = Math.max(0, overlapEnd - overlapStart + 1);

            totalSelections += overlapCount * power;
        }

        // Minimum number of operations is ceil(totalSelections / 2)
        return (totalSelections + 1) / 2;
    }

    public long minOperations(int[][] queries) {
        long totalOperations = 0;

        for (int[] query : queries) {
            long l = query[0];
            long r = query[1];
            totalOperations += countOperations(l, r);
        }

        return totalOperations;
    }
}
