// Last updated: 8/28/2025, 9:58:59 AM
class Solution {
    public boolean isPalindrome(int x) {
        // Negative numbers are not palindrome
        if (x < 0) return false;

        int original = x;
        int reversed = 0;

        while (x != 0) {
            int digit = x % 10;
            // Check for overflow
            if (reversed > (Integer.MAX_VALUE - digit) / 10) return false;
            reversed = reversed * 10 + digit;
            x /= 10;
        }

        return original == reversed;
    }
}
