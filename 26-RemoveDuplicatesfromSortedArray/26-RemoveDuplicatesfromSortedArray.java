// Last updated: 10/14/2025, 3:32:38 PM
class Solution {
    public int removeDuplicates(int[] nums) {
        List<Integer> uni = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        for(int i=0;i<nums.length;i++){
            if(!set.contains(nums[i])){
                set.add(nums[i]);
                uni.add(nums[i]);
            }
        }

        for(int i=0;i<uni.size();i++){
            nums[i] = uni.get(i);
        }

        return set.size();
    }
}