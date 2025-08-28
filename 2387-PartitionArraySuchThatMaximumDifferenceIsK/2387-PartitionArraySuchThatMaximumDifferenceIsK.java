// Last updated: 8/28/2025, 9:57:42 AM
import java.util.Arrays;

class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);  // Step 1: Sort the array
        int count = 1;      // Step 2: At least one subsequence
        int start = nums[0]; // Step 3: First element of the current subsequence

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - start > k) {
                count++;           // Start a new subsequence
                start = nums[i];   // Update the start of the new subsequence
            }
        }

        return count;
    }
}
