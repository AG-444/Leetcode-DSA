// Last updated: 9/6/2025, 6:46:48 PM
class Solution {
    
    private long countOperations(long l, long r) {
        long totalDivisions = 0;
        long currentPower = 1;  // 4^0

        while (currentPower <= r) {
            long nextPower = currentPower * 4;

            long lowerBound = Math.max(l, currentPower);
            long upperBound = Math.min(r, nextPower - 1);

            if (lowerBound <= upperBound) {
                long count = upperBound - lowerBound + 1;
                long divisionsNeeded = (long)(Math.log(currentPower) / Math.log(4)) + 1;

                totalDivisions += count * divisionsNeeded;
            }

            currentPower = nextPower;
        }

        // Each operation handles 2 numbers
        return (totalDivisions + 1) / 2;
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
