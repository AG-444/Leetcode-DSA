// Last updated: 9/12/2025, 9:58:46 AM
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            Set<Integer> curr = new HashSet<>();
            for(int j=i+1;j<nums.length;j++){
                int third = -(nums[i]+nums[j]);
                if(curr.contains(third)){
                    List<Integer> current = new ArrayList<>(List.of(nums[i],nums[j],third));
                    Collections.sort(current);
                    set.add(new ArrayList<>(current));
                }
                curr.add(nums[j]);
            }
        }
        return new ArrayList<>(set);
    }
}