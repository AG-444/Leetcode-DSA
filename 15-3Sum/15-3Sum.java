// Last updated: 9/12/2025, 10:33:17 AM
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<nums.length-1;i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            int j = i+1;
            int k = nums.length-1;
            while(j<k){
                int sum = nums[i]+nums[j]+nums[k];
                if(sum<0){
                    j++;
                }
                else if(sum>0){
                    k--;
                }
                else{
                    List<Integer> curr = new ArrayList<>(List.of(nums[i],nums[j],nums[k]));
                    ans.add(new ArrayList<>(curr));
                    j++;
                    k--;
                    while(j<k && nums[j] == nums[j-1])j++;
                    while( k > j && nums[k] == nums[k+1])k--;
                }
            }
        }
        return ans;
    }
}