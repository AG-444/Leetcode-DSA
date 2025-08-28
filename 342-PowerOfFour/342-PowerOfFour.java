// Last updated: 8/28/2025, 9:58:06 AM
class Solution {
    public boolean isPowerOfFour(int n){
        double check = Math.log(n)/Math.log(4);
        System.out.println(check);
        if(check%1.0==0.0) return true;
        return false;
    }
}