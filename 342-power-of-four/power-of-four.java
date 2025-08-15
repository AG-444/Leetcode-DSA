class Solution {
    public boolean isPowerOfFour(int n){
        double check = Math.log(n)/Math.log(4);
        System.out.println(check);
        if(check%1.0==0.0) return true;
        return false;
    }
}