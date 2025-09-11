// Last updated: 9/11/2025, 4:50:58 PM
class Solution {
    private int solve(int[] nums, int k) {
        int ans = 0;
        int left = 0;
        int count = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] % 2 != 0) count++;

            while (count >= k && left <= right) {
                if (nums[left] % 2 != 0) count--;

                left++;
            }

            ans += left;
        }

        return ans;
    }

    public int numberOfSubarrays(int[] nums, int k) {
        return solve(nums, k) - solve(nums, k + 1);
    }
}