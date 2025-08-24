class Solution {
    public int longestSubarray(int[] nums) {
        int left = 0;
        int zeroCount = 0;
        int maxLength = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                zeroCount++;
            }

            // Shrink the window if it has more than one zero
            while (zeroCount > 1) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
                System.out.println(right +"-"+ left + " - "+nums[left]);
            }

            // The length of the current valid subarray of 1s
            // is the window size (right - left + 1) minus the number of zeros.
            // Since zeroCount is at most 1, this is (right - left).
            maxLength = Math.max(maxLength, right - left);
        }

        return maxLength;
    }
}