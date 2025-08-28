// Last updated: 8/28/2025, 9:58:15 AM
class Solution {
    public boolean isPowerOfTwo(int n) {
        // n > 0 and only one bit set in binary representation
        return n > 0 && (n & (n - 1)) == 0;
    }
}
