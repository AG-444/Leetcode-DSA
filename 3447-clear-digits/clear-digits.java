import java.util.*;

class Solution {
    public String clearDigits(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                if (!stack.isEmpty()) {
                    stack.removeLast();  // remove the closest letter to the left
                }
                // discard the digit
            } else {
                stack.addLast(ch);  // push letter to the stack
            }
        }
        
        StringBuilder result = new StringBuilder();
        for (char ch : stack) {
            result.append(ch);
        }
        return result.toString();
    }
}
