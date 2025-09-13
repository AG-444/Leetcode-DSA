// Last updated: 9/13/2025, 3:04:34 PM
class Solution {
    public int mySqrt(int x){
        if(x==0 || x==1)return x;
        long left = 0;
        long right = x;
        while(left<right){
            if(right - left <=1)break;
            long middle = (left+right)/2;
            if(middle*middle>x){
                right = middle;
            }
            else if(middle*middle < x){
                left = middle;
            }
            else{
                return (int)middle;
            }
        }
        // System.out.println(left+" "+right);
        return (int)(left+right)/2;
    }
}