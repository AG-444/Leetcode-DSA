// Last updated: 10/14/2025, 3:07:45 PM
class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        int freq = nums.length / 2;
        for(int num:nums){
            if(map.get(num) > freq){
                return num;
            }
        }
        return -1;
    }
}