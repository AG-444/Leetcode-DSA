// Last updated: 8/28/2025, 9:57:27 AM
import java.util.*;

class Solution {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);  // Sort the array
        int n = nums.length;

        List<int[]> result = new ArrayList<>();

        for (int i = 0; i < n; i += 3) {
            int a = nums[i], b = nums[i + 1], c = nums[i + 2];
            // Check if max difference within the triplet is <= k
            if (c - a > k) {
                return new int[0][];
            }
            result.add(new int[]{a, b, c});
        }

        return result.toArray(new int[0][]);
    }
}
