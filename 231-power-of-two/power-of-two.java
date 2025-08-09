class Solution {
    public boolean isPowerOfTwo(int n) {
        // n > 0 and only one bit set in binary representation
        return n > 0 && (n & (n - 1)) == 0;
    }
}
