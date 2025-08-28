// Last updated: 8/28/2025, 9:58:09 AM
class Solution {
    public boolean isPowerOfThree(int n) {
        if (n==1) return true;
        else if(n<=0) return false;
        double ans = Math.log(n)/Math.log(3);
        System.out.println(ans);
        double expected = Math.round(ans);
        double tolerance = 1e-10;
        if (Math.abs(ans-expected) < tolerance){
            ans = Math.round(ans);
        }
        return (ans%1 == 0.0);
    }
}