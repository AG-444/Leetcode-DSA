// Last updated: 8/28/2025, 9:57:20 AM
class Solution {
    private static final int MOD = 1_000_000_007;
    private static final int MAX = 100_005;
    private long[] fact = new long[MAX];
    private long[] invFact = new long[MAX];

    public Solution() {
        precomputeFactorials();
    }

    public int countGoodArrays(int n, int m, int k) {
        long choose = nCr(n - 1, k);
        long pow = modPow(m - 1, n - k - 1, MOD);
        long res = choose * pow % MOD;
        res = res * m % MOD;
        return (int) res;
    }

    // Precompute factorials and inverse factorials
    private void precomputeFactorials() {
        fact[0] = invFact[0] = 1;
        for (int i = 1; i < MAX; i++) {
            fact[i] = (fact[i - 1] * i) % MOD;
        }
        invFact[MAX - 1] = modInverse(fact[MAX - 1], MOD);
        for (int i = MAX - 2; i >= 1; i--) {
            invFact[i] = (invFact[i + 1] * (i + 1)) % MOD;
        }
    }

    private long nCr(int n, int r) {
        if (r < 0 || r > n) return 0;
        return (((fact[n] * invFact[r]) % MOD) * invFact[n - r]) % MOD;
    }

    private long modPow(long base, long exp, int mod) {
        long res = 1;
        base %= mod;
        while (exp > 0) {
            if ((exp & 1) == 1)
                res = (res * base) % mod;
            base = (base * base) % mod;
            exp >>= 1;
        }
        return res;
    }

    private long modInverse(long a, int mod) {
        return modPow(a, mod - 2, mod);
    }
}
