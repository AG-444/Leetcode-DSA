// Last updated: 9/8/2025, 12:04:24 PM
class Solution {
    public int largestRectangleArea(int[] height){
      int[] heights = new int[height.length+1];
      for(int i=0;i<height.length;i++){
        heights[i] = height[i];
      }
      heights[height.length] = 0;
      int[] nse = new int[heights.length];
      for(int i=0;i<heights.length;i++){
        nse[i] = -1;  
      }
      Stack<Integer> stack = new Stack<>();
      stack.push(0);
      for(int i=1;i<heights.length;i++){
        while(!stack.isEmpty() && heights[stack.peek()]>heights[i]){
            nse[stack.peek()] = i;
            stack.pop();
        }
        stack.push(i);
      }
      
      stack.clear();
      int[] pse = new int[heights.length];
      for(int i=0;i<heights.length;i++){
        while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
            stack.pop();
        }
        pse[i] = stack.isEmpty()? -1:stack.peek();
        stack.push(i);
      }

    //   for(int i=0;i<heights.length;i++){
    //     System.out.println(i+ " " + nse[i]);
    //     System.out.println(i+ " " + pse[i]+"\n");
    //   }
      int max = 0;
      for(int i =0;i<height.length;i++){
        int area = heights[i]*(nse[i] - pse[i] - 1);
        if(area>max) max =area;
      }
      return max;
    }
}