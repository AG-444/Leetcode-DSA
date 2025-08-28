// Last updated: 8/28/2025, 9:58:26 AM
class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num; // XOR-ing all elements
        }
        return result;
    }
}
