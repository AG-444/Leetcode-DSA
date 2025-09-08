// Last updated: 9/8/2025, 3:19:33 PM
class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0, maxSum = nums[0];
        for(int i=0;i<nums.length;i++){
            sum = sum + nums[i];
            maxSum = maxSum < sum ? sum : maxSum;
            if(sum < 0){
                sum=0;
            }
           
        }
        return maxSum;
    }
}