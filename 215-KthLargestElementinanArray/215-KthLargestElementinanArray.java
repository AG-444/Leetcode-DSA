// Last updated: 9/3/2025, 10:07:10 PM
class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
        
    }
}