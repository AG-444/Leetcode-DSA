// Last updated: 9/11/2025, 4:53:43 PM
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int len = nums.length;
        
        for(int i=0; i<len; i++) {
            if(nums[i] % 2 == 0) nums[i] = 0;
            else nums[i] = 1;
        }

        int[] freq = new int[len+1];
        int prefix = 0, count = 0;
        freq[0] = 1;

        for(int num : nums) {
            prefix += num;

            if(prefix >= k) {
                count += freq[prefix - k];
            }

            freq[prefix]++;
        }

        return count;
    }
}