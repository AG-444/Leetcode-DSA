import java.util.*;

class Solution {
    public long countGoodIntegers(int n, int k) {
        Set<String> seen = new HashSet<>();
        long result = 0;

        for (long pal : generatePalindromes(n)) {
            if (pal % k != 0) continue;

            int[] freq = digitFreq(pal);
            String key = freqKey(freq);

            if (seen.contains(key)) continue;
            seen.add(key);

            result += countPermutations(freq, n);
        }
        return result;
    }

    // Generate all palindromes of length n with no leading 0
    private List<Long> generatePalindromes(int n) {
        List<Long> palindromes = new ArrayList<>();

        int halfLen = (n + 1) / 2;
        int start = (int) Math.pow(10, halfLen - 1);
        int end = (int) Math.pow(10, halfLen);

        for (int half = start; half < end; half++) {
            String left = Integer.toString(half);
            String right = new StringBuilder(left.substring(0, n / 2)).reverse().toString();
            String full = left + right;
            palindromes.add(Long.parseLong(full));
        }
        return palindromes;
    }

    private int[] digitFreq(long num) {
        int[] freq = new int[10];
        while (num > 0) {
            freq[(int)(num % 10)]++;
            num /= 10;
        }
        return freq;
    }

    private String freqKey(int[] freq) {
        StringBuilder sb = new StringBuilder();
        for (int f : freq) sb.append(f).append(',');
        return sb.toString();
    }

    // Count permutations with the same digit freq, skipping those with leading zero
    private long countPermutations(int[] freq, int n) {
        long total = factorial(n);
        for (int f : freq) {
            total /= factorial(f);
        }

        // subtract permutations with leading zero
        if (freq[0] > 0) {
            int[] freqCopy = Arrays.copyOf(freq, 10);
            freqCopy[0]--;
            long subtract = factorial(n - 1);
            for (int f : freqCopy) {
                subtract /= factorial(f);
            }
            total -= subtract;
        }

        return total;
    }

    private long factorial(int x) {
        long res = 1;
        for (int i = 2; i <= x; i++) res *= i;
        return res;
    }
}
