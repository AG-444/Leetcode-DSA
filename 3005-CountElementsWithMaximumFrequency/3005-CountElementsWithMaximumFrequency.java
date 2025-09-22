// Last updated: 9/22/2025, 10:39:05 AM
class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            if(map.get(nums[i]) >= max){
                max = map.get(nums[i]);
            }
        }
        // System.out.println(map);
        int ans = 0;
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue() == max){
                ans+=max;
            }
        }
        return ans;
    }
}