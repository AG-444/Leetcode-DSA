class Solution {
    public boolean isPowerOfTwo(int n) {
        double logValue = Math.log(n)/Math.log(2);
        if (Math.abs(logValue - Math.round(logValue))< 1e-10){
            return true;
        }
        else{
            return false;
        }
    }
}