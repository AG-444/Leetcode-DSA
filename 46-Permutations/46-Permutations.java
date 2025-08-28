// Last updated: 8/28/2025, 9:58:46 AM
import java.util.*;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(nums, 0, list);
        return list;
    }
    public void backtrack(int[] nums, int start, List<List<Integer>> list) {
        if (start == nums.length) {
            List<Integer> current = new ArrayList<>();
            for (int num : nums) {
                current.add(num);
            }
            list.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            swap(nums, start, i);
            backtrack(nums, start + 1, list);
            swap(nums, start, i);
        }
    }

    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
