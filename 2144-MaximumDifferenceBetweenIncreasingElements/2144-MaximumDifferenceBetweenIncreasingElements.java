// Last updated: 8/28/2025, 9:57:45 AM
class Solution {
    public int maximumDifference(int[] nums) {
        int minValue = nums[0];
        int maxDiff = -1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > minValue) {
                maxDiff = Math.max(maxDiff, nums[i] - minValue);
            } else {
                minValue = nums[i]; // update minValue if current number is smaller
            }
        }

        return maxDiff;
    }
}
