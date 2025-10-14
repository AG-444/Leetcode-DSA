// Last updated: 10/14/2025, 9:44:11 AM
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[2];
        for(int i=0;i<nums.length;i++){
            int curr = target - nums[i];
            if(map.containsKey(curr)){
                return new int[]{i,map.get(curr)}; 
            }
            map.put(nums[i],i);
        }
        return ans;
    }
}