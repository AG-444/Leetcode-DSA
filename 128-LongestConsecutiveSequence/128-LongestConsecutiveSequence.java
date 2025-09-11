// Last updated: 9/11/2025, 6:56:54 PM
class Solution {
    public int longestConsecutive(int[] nums){
        if(nums.length == 0) return 0;

        Arrays.sort(nums);

        int lastSmallest = Integer.MIN_VALUE;
        int currCount = 1;
        int max = 1;
        for(int num:nums){
            if(num == lastSmallest) continue;
            if(lastSmallest == num-1){
                currCount++;
                lastSmallest = num;
            }
            else{
                currCount = 1;
                lastSmallest = num;
            }
            if(currCount>max){
                max = currCount;
            }
        }

        return max;
    }
}