class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int max = Integer.MIN_VALUE;
        int left = 0;
        int right = n-1;
        while(left<right){
            int width = right - left;
            int min = Math.min(height[left], height[right]);
            int area = width * min;
            if(max<area) max = area;
            if(min == height[left]) left++;
            else if(min ==height[right]) right--;
        }
        return max;
    }
}
