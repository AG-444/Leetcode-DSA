class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long ans = 0;
        long n = nums.length;
        long subSize =0;
        for(int i=0;i<n;i++){
            if(nums[i] == 0){
                subSize++;
            }
            else{
                if(subSize>0){
                    ans += (subSize*(subSize+1))/2;
                    subSize = 0;
                }
            }
        }
        if(subSize>0){
            ans += (subSize*(subSize+1))/2;
        }
        return ans;
    }
}