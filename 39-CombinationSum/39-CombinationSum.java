// Last updated: 8/28/2025, 9:58:50 AM
import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] candidates, int target, int start, List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current)); // found a valid combination
            return;
        }
        if (target < 0) return; // exceed target, stop

        for (int i = start; i < candidates.length; i++) {
            current.add(candidates[i]); // choose the candidate
            backtrack(candidates, target - candidates[i], i, current, result); // not i + 1, because we can reuse same elements
            current.remove(current.size() - 1); // backtrack
        }
    }
}
