// Last updated: 9/16/2025, 2:48:51 PM
import java.util.*;

class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (int n : nums) {
            // Keep merging as long as the top of the stack is non-coprime with n
            while (!stack.isEmpty() && gcd(stack.peekLast(), n) > 1) {
                n = (int)(lcm(stack.pollLast(), n));
            }
            stack.addLast(n);
        }
        
        return new ArrayList<>(stack);
    }
    
    // GCD function
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return Math.abs(a);
    }
    
    // LCM function
    public static long lcm(int a, int b) {
        return Math.abs((long)a * (long)b) / gcd(a, b);
    }
}
