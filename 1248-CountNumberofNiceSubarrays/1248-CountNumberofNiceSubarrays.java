// Last updated: 9/11/2025, 4:48:14 PM
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        for(int i=0;i<nums.length;i++){
            nums[i] = nums[i]%2;
        }

        Map<Integer, Integer> map = new HashMap<>();

        int prefSum = 0;
        int count = 0;
        map.put(0,1);
        for(int i=0;i<nums.length;i++){
            prefSum += nums[i];
            if(map.containsKey(prefSum-k)){
                count += map.get(prefSum-k);
            }
            map.put(prefSum,map.getOrDefault(prefSum,0)+1);
        }

        return count;
    }
}