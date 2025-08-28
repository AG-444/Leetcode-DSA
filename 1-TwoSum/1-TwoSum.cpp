// Last updated: 8/28/2025, 9:59:05 AM
#include <unordered_map>
class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int, int> seen;  // Stores {value, index}
        for (int i = 0; i < nums.size(); i++) {
            int complement = target - nums[i];  // What we need to find
            if (seen.find(complement) != seen.end()) {
                return {seen[complement], i};  // Return the stored index and current index
            }
            seen[nums[i]] = i;  // Store current number with its index
        }
        return {};  // No solution found (shouldn't happen based on problem constraints)
    }
};
