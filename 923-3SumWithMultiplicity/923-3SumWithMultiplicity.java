// Last updated: 9/12/2025, 11:47:30 AM
class Solution {
    public int threeSumMulti(int[] nums, int target) {

        int modulo = (int) 1e9 + 7;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();

        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        for (int i = 0; i < nums.length - 1; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum < target) {
                    j++;
                } else if (sum > target) {
                    k--;
                } else {
                    List<Integer> curr = new ArrayList<>(List.of(nums[i], nums[j], nums[k]));
                    ans.add(new ArrayList<>(curr));
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) j++;
                    while (k > j && nums[k] == nums[k + 1]) k--;
                }
            }
        }

        long count = 0;
        for (int i = 0; i < ans.size(); i++) {
            long a = ans.get(i).get(0);
            long b = ans.get(i).get(1);
            long c = ans.get(i).get(2);

            if (a == b && a == c) {
                long freq = map.get((int)a);
                count += (freq * (freq - 1) * (freq - 2)) / 6;
            } else if (a == b) {
                long freq = map.get((int)a);
                count += (freq * (freq - 1)) / 2 * map.get((int)c);
            } else if (a == c) {
                long freq = map.get((int)a);
                count += (freq * (freq - 1)) / 2 * map.get((int)b);
            } else if (b == c) {
                long freq = map.get((int)b);
                count += (freq * (freq - 1)) / 2 * map.get((int)a);
            } else {
                count += (long) map.get((int)a) * map.get((int)b) * map.get((int)c);
            }
            count %= modulo; // reduce at each step
        }

        return (int) (count % modulo);
    }
}
