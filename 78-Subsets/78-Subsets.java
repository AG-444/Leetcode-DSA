// Last updated: 9/2/2025, 2:32:21 PM
class Solution {
    public void addSubsets(List<List<Integer>> ans, int nums[], int idx, List<Integer> curr){
        if(nums.length == idx){
            ans.add(new ArrayList<>(curr));
            return;
        }
        addSubsets(ans, nums, idx+1, curr);
        curr.add(nums[idx]);
        addSubsets(ans,nums,idx+1,curr);
        curr.remove(curr.size()-1);

    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        addSubsets(ans,nums,0,new ArrayList<>());
        return ans;    
    }
}