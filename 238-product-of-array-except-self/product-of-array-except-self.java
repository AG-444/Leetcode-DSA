class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];
        int pref[] = new int[n];
        int suf[] = new int[n];
        int mul = 1;
        
        for(int i=0;i<n;i++){
            mul *= nums[i];
            pref[i] = mul;
        }
        mul = 1;
        for(int i=n-1;i>=0;i--){
            mul *= nums[i];
            suf[i] = mul;
        }
        ans[0] = suf[1];
        ans[n-1] = pref[n-2];
        for(int i=1;i<n-1;i++){
            ans[i] = suf[i+1] * pref[i-1];
        }
        return ans;
    }
}