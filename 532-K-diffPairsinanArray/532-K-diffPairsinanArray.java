// Last updated: 9/12/2025, 11:46:03 AM
class Solution {
    public int findPairs(int[] nums, int k) {
        if(k < 0) return 0;

        if(k == 0){
            Map<Integer, Integer> freq = new HashMap<>();
            int count = 0;
            for(int n : nums){
                freq.put(n, freq.getOrDefault(n, 0) + 1);
            }
            for(int val : freq.values()){
                if(val >= 2) count++;
            }
            return count;
        } else {
            Set<Integer> set = new HashSet<>();
            Set<Integer> seen = new HashSet<>();
            int count = 0;
            for(int n : nums) set.add(n);
            for(int n : set){
                if(set.contains(n + k)) count++;
            }
            return count;
        }
    }
}
