class Solution {
    public int findDuplicate(int[] nums) {
        // Step 1: Find the intersection point of the two runners.
        int slow = nums[0];
        int fast = nums[0];
        
        do {
            slow = nums[slow];         // Move by 1 step
            fast = nums[nums[fast]];   // Move by 2 steps
        } while (slow != fast);
        
        // Step 2: Find the entrance to the cycle (duplicate number)
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        
        return slow;
    }
}
