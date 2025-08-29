// Last updated: 8/29/2025, 4:32:12 PM
// Parity of 2 numbers is different when: 1 is odd other is even and vice versa
class Solution {
    public long flowerGame(int n, int m) {
        double N = n;
        double M = m;

        long oddN  = (n + 1L) / 2;
        long evenN = n / 2L;
        long oddM  = (m + 1L) / 2;
        long evenM = m / 2L;
        long ans = oddN * evenM + evenN * oddM;
        return ans;
    }
}