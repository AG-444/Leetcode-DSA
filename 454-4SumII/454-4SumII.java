// Last updated: 9/11/2025, 7:28:31 PM
class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int x = 0;
        Map<Integer, Integer> cPlusD = new HashMap<>();
        for (int num3 : nums3) {
            for (int num4 : nums4) {
                int sum = num3 + num4;
                cPlusD.put(sum, cPlusD.getOrDefault(sum, 0) + 1);
            }
        }
        for(int num1:nums1){
            for(int num2:nums2){
                if(cPlusD.containsKey(0-num1-num2)){
                    x += cPlusD.get(0-num1-num2);
                }
            }
        }
        return x;
    }
}