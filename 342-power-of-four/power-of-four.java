class Solution {
    public boolean isPowerOfFour(int n) {
        if(n == 1){
            return true;
        }
        else if(n<=0){
            return false;
        }
        double N= n;

        while(n>0){
            double check = N/4;
            System.out.println(check);
            if(check%1.0 == 0.0){
                N = N/4;
            }

            else if(N==1.0){
                return true;
            }
            else{
                return false;
            }
        }
        return true;
    }
}