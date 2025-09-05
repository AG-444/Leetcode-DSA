// Last updated: 9/5/2025, 11:40:24 AM
class Solution {
    /**
     * Return the minimum number of operations to make num1 zero by repeatedly
     * subtracting (2^i + num2). If impossible, return -1.
     *
     * Approach:
     * For each t = 1..60, let S = num1 - t * num2.
     * If S >= 0 and popcount(S) <= t <= S then it's possible with t operations.
     */
    public int makeTheIntegerZero(int num1, int num2) {
        for (int t = 1; t <= 60; t++) {
            long S = (long) num1 - (long) t * (long) num2; // use long to avoid overflow
            if (S < 0) {
                continue;
            }
            int ones = Long.bitCount(S); // number of 1-bits in S
            // condition: can we split S into exactly t powers of two?
            if (ones <= t && t <= S) {
                return t;
            }
        }
        return -1;
    }
}
