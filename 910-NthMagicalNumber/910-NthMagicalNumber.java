// Last updated: 8/28/2025, 9:57:59 AM
class Solution {
    long i;
    long count;
    long gcd;
    long mod = (int) (Math.pow(10, 9) + 7);

    long lcm(long a, long b) {
        if (a > b) {
            a = a + b;
            b = a - b;
            a = a - b;
        }
        for (i = 1; i <= b; ++i) {
            if (a % i == 0 && b % i == 0) {
                gcd = i;
            }
        }
        return ((a * b) / gcd);
    }

    long BS(long high, long low, long a, long b, long n, long LCM) {
        long mid = low + (high - low) / 2;
        if (low >= high) {
            return low;
        } else if (mid / a + mid / b - mid / LCM < n) {
            return BS(high, mid + 1, a, b, n, LCM);
        } else {
            return BS(mid, low, a, b, n, LCM);
        }
    }

    int nthMagicalNumber(long n, long a, long b) {
        long LCM = lcm(a, b);
        if (a > b) {
            a = a + b;
            b = a - b;
            a = a - b;
        }
        long low = a;
        long high = n * a;
        long x = BS(high, low, a, b, n, LCM);
        return (int)(x % mod);
    }
}
