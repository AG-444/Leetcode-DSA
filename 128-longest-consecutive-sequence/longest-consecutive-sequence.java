class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);

        int ans = 0;
        int maxAns = 0;

        for (int num : set) {
            // start sequence only if num-1 is not present
            if (!set.contains(num - 1)) {
                int current = num;
                ans = 1;

                while (set.contains(current + 1)) {
                    current++;
                    ans++;
                }

                if (ans > maxAns) maxAns = ans;
            }
        }

        return maxAns;
    }
}
