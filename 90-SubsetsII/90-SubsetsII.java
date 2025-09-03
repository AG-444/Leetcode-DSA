// Last updated: 9/3/2025, 5:05:35 PM
// class Solution {
//     public List<List<Integer>> subsetsWithDup(int[] nums) {
        
//     }
// }

class Solution {
    public void subsetAdd(int[] nums, int idx,List<Integer> curr, List<List<Integer>> result){
        if(idx == nums.length){
            List<Integer> include = new ArrayList<>(curr);
            if(!result.contains(include)) result.add(include);
            return;
        }

        subsetAdd(nums, idx+1,curr,result);
        curr.add(nums[idx]);
        subsetAdd(nums,idx+1,curr,result);
        curr.remove(curr.size()-1);

    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        subsetAdd(nums,0,new ArrayList<>(), result);
        return result;
    }
}