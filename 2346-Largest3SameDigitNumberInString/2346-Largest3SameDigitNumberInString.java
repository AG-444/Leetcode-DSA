// Last updated: 8/28/2025, 9:57:44 AM
class Solution {
    public String largestGoodInteger(String num) {
        int max = -99999;
        String ans = "";
        for(int i=0;i<num.length()-2;i++){
            if(num.charAt(i) == num.charAt(i+1) && num.charAt(i+1) == num.charAt(i+2)){
                int a = Integer.parseInt(num.substring(i,i+3));
                if(max<a){
                    max = a;
                    ans = num.substring(i,i+3);
                }
            }
        }
        return ans;
    }
}