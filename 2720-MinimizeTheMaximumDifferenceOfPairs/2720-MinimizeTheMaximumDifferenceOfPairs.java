// Last updated: 8/28/2025, 9:57:35 AM
import java.util.Arrays;

class Solution {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int left = 0, right = nums[nums.length - 1] - nums[0];
        int result = right;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canFormPairs(nums, p, mid)) {
                result = mid;
                right = mid - 1; // Try smaller max difference
            } else {
                left = mid + 1; // Increase the allowed max difference
            }
        }
        return result;
    }

    private boolean canFormPairs(int[] nums, int p, int maxDiff) {
        int count = 0;
        int i = 1;
        while (i < nums.length) {
            if (nums[i] - nums[i - 1] <= maxDiff) {
                count++;
                i += 2; // Skip both elements in the pair
            } else {
                i++;
            }
        }
        return count >= p;
    }
}
