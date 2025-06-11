class Solution {
    public int maxSubArray(int[] nums) {
        int maxSoFar = nums[0]; // holds the max subarray sum found so far
        int currentSum = nums[0]; // holds the current subarray sum

        for (int i = 1; i < nums.length; i++) {
            // Either start new subarray or extend the previous one
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSoFar = Math.max(maxSoFar, currentSum);
        }

        return maxSoFar;
    }
}
