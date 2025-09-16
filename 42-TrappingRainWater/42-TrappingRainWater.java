// Last updated: 9/16/2025, 11:12:32 PM
class Solution {
    public int trap(int[] height) {
        Stack<Integer> s = new Stack<>();
        int max = height[0];
        int maxInd = 0;
        int i = 1;
        int result = 0;
        while (i < height.length) {
            if (height[i] > max) {
                result += (i - maxInd - 1) * max;
                for (int x : s) {
                    result -= x;
                }
                s = new Stack<>();
                max = height[i];
                maxInd = i;
            } else {
                s.add(height[i]);
            }
            i++;
        }
        max=0;
        while (!s.isEmpty()){
            int c = s.pop();
            max=Math.max(c,max);
            result+=(max-c);
        }

        return result;
    }
}