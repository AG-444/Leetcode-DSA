// Last updated: 9/8/2025, 2:08:33 PM
class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxArea = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (int i = 0; i <= n; i++) {
            int h = (i == n) ? 0 : heights[i]; // sentinel at end
            while (!stack.isEmpty() && heights[stack.peek()] > h) {
                int heightIndex = stack.pop();
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, heights[heightIndex] * width);
            }
            stack.push(i);
        }
        
        return maxArea;
    }
}
