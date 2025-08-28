// Last updated: 8/28/2025, 9:57:40 AM
class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long ans = 0;
        long n = nums.length;
        long subSize =0;
        for(int i=0;i<n;i++){
            if(nums[i] == 0){
                subSize++;
                ans += subSize;
            }
            else{
                subSize = 0;
            }
        }
        return ans;
    }
}