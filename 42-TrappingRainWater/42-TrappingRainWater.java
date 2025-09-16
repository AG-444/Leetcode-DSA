// Last updated: 9/16/2025, 11:11:11 PM
class Solution {
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int max = 0;

        for (int i = 1; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int left = stack.peek();
                stack.pop();

                if (stack.isEmpty()) {
                    break;
                }

                int distance = i - stack.peek() - 1;
                int boundedHeight = Math.min(height[stack.peek()], height[i]) - height[left];
                int area = boundedHeight * distance;

                if (area > 0) {
                    max += area;
                }
            }
            stack.push(i);
        }

        return max;
    }
}
