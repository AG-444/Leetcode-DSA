// Last updated: 9/8/2025, 2:06:41 PM
class Solution {
    public int largestRectangleArea(int[] height){
      int[] heights = new int[height.length+1];
      for(int i=0;i<height.length;i++){
        heights[i] = height[i];
      }
      heights[height.length] = 0;
      
      Stack<Integer> stack = new Stack<>();
      int maxArea = 0;
      for(int i=0;i<heights.length;i++){
        while(!stack.isEmpty() && heights[stack.peek()] > heights[i]){
            int curr = stack.peek();
            stack.pop();
            int pse = stack.isEmpty() ? -1:stack.peek();
            int area = heights[curr] * (i - pse - 1);
            if(area > maxArea) maxArea = area;
        }
        stack.push(i);
      }
      return maxArea;
    }
}