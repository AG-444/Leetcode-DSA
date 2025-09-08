// Last updated: 9/8/2025, 6:33:44 PM
class Solution {
    public static void makePerm(int[] nums, List<List<Integer>> ans , List<Integer> curr, boolean[] freq){
        if(curr.size() == nums.length){
            ans.add(new ArrayList<>(curr));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!freq[i]){
                curr.add(nums[i]);
                freq[i] = true;
                makePerm(nums,ans,curr,freq);
                curr.remove(curr.size()-1);
                freq[i] = false;
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] freq = new boolean[nums.length];
        makePerm(nums,ans,new ArrayList<>(),freq);
        return ans;
    }
}