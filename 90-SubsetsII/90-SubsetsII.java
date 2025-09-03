// Last updated: 9/3/2025, 5:07:07 PM
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<Integer> partialRes = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        List<List<Integer>> res = new ArrayList<>();
        for (int i=0;i<=nums.length;i++)
        {
            backtrace(i, nums, visited, partialRes, res);
        }

        return res;
    }

    public void backtrace(int start, int[] nums, boolean[] visited, List<Integer> partialRes, List<List<Integer>> res)
    {
        if (start==nums.length)
        {
            res.add(new ArrayList<Integer>(partialRes));
        }
        for (int i=start;i<nums.length;i++)
        {
            if ((start>0)&&(nums[start]==nums[start-1]&&!visited[start-1]))
            {
                continue;
            }
            visited[start] = true;
            partialRes.add(nums[start]);
            backtrace(i+1, nums, visited, partialRes, res);
            partialRes.remove(partialRes.size()-1);
            visited[start] = false;


        }
    }
}